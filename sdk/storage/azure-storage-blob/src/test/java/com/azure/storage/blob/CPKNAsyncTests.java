// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob;

import com.azure.core.http.HttpHeaders;
import com.azure.storage.blob.models.BlobContainerEncryptionScope;
import com.azure.storage.blob.models.BlobStorageException;
import com.azure.storage.blob.models.CustomerProvidedKey;
import com.azure.storage.blob.models.PageRange;
import com.azure.storage.blob.options.BlobCopyFromUrlOptions;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.azure.storage.blob.specialized.AppendBlobAsyncClient;
import com.azure.storage.blob.specialized.BlobAsyncClientBase;
import com.azure.storage.blob.specialized.BlockBlobAsyncClient;
import com.azure.storage.blob.specialized.PageBlobAsyncClient;
import com.azure.storage.blob.specialized.PageBlobClient;
import com.azure.storage.blob.specialized.SpecializedBlobClientBuilder;
import com.azure.storage.common.test.shared.extensions.RequiredServiceVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CPKNAsyncTests extends BlobTestBase {

    private final String scope1 = "testscope1";
    private final String scope2 = "testscope2";
    private String es;
    private BlobContainerEncryptionScope ces;
    private BlobContainerClientBuilder builder;

    private BlobContainerAsyncClient cpknContainer;
    private BlockBlobAsyncClient cpknBlockBlob;
    private PageBlobAsyncClient cpknPageBlob;
    private AppendBlobAsyncClient cpknAppendBlob;

    @BeforeEach
    public void setup() {
        es = scope1;
        ces = new BlobContainerEncryptionScope().setDefaultEncryptionScope(scope2)
            .setEncryptionScopeOverridePrevented(true);

        builder = getContainerClientBuilder(ccAsync.getBlobContainerUrl())
            .credential(ENVIRONMENT.getPrimaryAccount().getCredential());

        cpknContainer = builder.encryptionScope(es).buildAsyncClient();

        cpknBlockBlob = cpknContainer.getBlobAsyncClient(generateBlobName()).getBlockBlobAsyncClient();
        cpknPageBlob = cpknContainer.getBlobAsyncClient(generateBlobName()).getPageBlobAsyncClient();
        cpknAppendBlob = cpknContainer.getBlobAsyncClient(generateBlobName()).getAppendBlobAsyncClient();
    }

    @Test
    public void containerCreate() {
        BlobContainerAsyncClient cpknCesContainer = builder.blobContainerEncryptionScope(ces).encryptionScope(null)
            .containerName(generateContainerName()).buildAsyncClient();

        assertAsyncResponseStatusCode(cpknCesContainer.createWithResponse(null, null),
            201);
    }

    @Test
    public void containerDenyEncryptionScopeOverride() {
        BlobContainerAsyncClient cpknCesContainer = builder.blobContainerEncryptionScope(ces)
            .containerName(generateContainerName()).buildAsyncClient();
        cpknCesContainer.create().block();

        cpknAppendBlob = builder.encryptionScope(es)
            .containerName(cpknCesContainer.getBlobContainerName())
            .buildAsyncClient()
            .getBlobAsyncClient(generateBlobName())
            .getAppendBlobAsyncClient();

        StepVerifier.create(cpknAppendBlob.create())
            .verifyError(BlobStorageException.class);
    }

    @Test
    public void containerListBlobsFlat() {
        BlobContainerAsyncClient cpkncesContainer = builder
            .blobContainerEncryptionScope(ces)
            .encryptionScope(null)
            .containerName(generateContainerName())
            .buildAsyncClient();
        cpkncesContainer.create().block();
        AppendBlobAsyncClient cpknAppendBlob = cpkncesContainer.getBlobAsyncClient(generateBlobName())
            .getAppendBlobAsyncClient();
        cpknAppendBlob.create().block();

        StepVerifier.create(cpkncesContainer.listBlobs())
            .assertNext(r -> assertEquals(scope2, r.getProperties().getEncryptionScope()))
            .verifyComplete();
    }

    @Test
    public void containerListBlobsHierarchical() {
        BlobContainerAsyncClient cpkncesContainer = builder
            .blobContainerEncryptionScope(ces)
            .encryptionScope(null)
            .containerName(generateContainerName())
            .buildAsyncClient();
        cpkncesContainer.create().block();
        AppendBlobAsyncClient cpknAppendBlob = cpkncesContainer.getBlobAsyncClient(generateBlobName())
            .getAppendBlobAsyncClient();
        cpknAppendBlob.create().block();

        StepVerifier.create(cpkncesContainer.listBlobsByHierarchy(""))
            .assertNext(r -> assertEquals(scope2, r.getProperties().getEncryptionScope()))
            .verifyComplete();
    }

    @Test
    public void appendBlobCreate() {
        StepVerifier.create(cpknAppendBlob.createWithResponse(null, null, null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void appendBlobAppendBlock() {
        cpknAppendBlob.create().block();

        StepVerifier.create(cpknAppendBlob.appendBlockWithResponse(DATA.getDefaultFlux(),
            DATA.getDefaultDataSize(), null, null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void appendBlobAppendBlockFromURL() {
        cpknAppendBlob.create().block();
        String blobName = generateBlobName();
        BlockBlobAsyncClient sourceBlob = ccAsync.getBlobAsyncClient(blobName).getBlockBlobAsyncClient();
        sourceBlob.upload(DATA.getDefaultFlux(), DATA.getDefaultDataSize()).block();

        String sas = ccAsync.generateSas(new BlobServiceSasSignatureValues(testResourceNamer.now().plusHours(1),
            new BlobSasPermission().setReadPermission(true)));

        StepVerifier.create(cpknAppendBlob.appendBlockFromUrlWithResponse(
            sourceBlob.getBlobUrl() + "?" + sas, null, null, null,
            null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void pageBlobCreate() {
        StepVerifier.create(cpknPageBlob.createWithResponse(1024, null, null, null,
            null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void pageBlobPutPage() {
        cpknPageBlob.create(PageBlobClient.PAGE_BYTES).block();

        StepVerifier.create(cpknPageBlob.uploadPagesWithResponse(
            new PageRange().setStart(0).setEnd(PageBlobClient.PAGE_BYTES - 1),
            Flux.just(ByteBuffer.wrap(getRandomByteArray(PageBlobClient.PAGE_BYTES))), null,
            null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void pageBlobPutPageFromURL() {
        String blobName = generateBlobName();
        PageBlobAsyncClient sourceBlob = ccAsync.getBlobAsyncClient(blobName).getPageBlobAsyncClient();
        sourceBlob.create(PageBlobClient.PAGE_BYTES).block();
        sourceBlob.uploadPagesWithResponse(new PageRange().setStart(0).setEnd(PageBlobClient.PAGE_BYTES - 1),
            Flux.just(ByteBuffer.wrap(getRandomByteArray(PageBlobClient.PAGE_BYTES))), null,
            null).block();

        cpknPageBlob.create(PageBlobClient.PAGE_BYTES).block();
        String sas = ccAsync.generateSas(new BlobServiceSasSignatureValues(testResourceNamer.now().plusHours(1),
            new BlobSasPermission().setReadPermission(true)));

        StepVerifier.create(cpknPageBlob.uploadPagesFromUrlWithResponse(
            new PageRange().setStart(0).setEnd(PageBlobClient.PAGE_BYTES - 1), sourceBlob.getBlobUrl() + "?" + sas,
            null, null, null, null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                assertTrue(r.getValue().isServerEncrypted());
                assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void pageBlobPutMultiplePages() {
        cpknPageBlob.create(PageBlobClient.PAGE_BYTES * 2).block();

        StepVerifier.create(cpknPageBlob.uploadPagesWithResponse(new PageRange().setStart(0)
            .setEnd(PageBlobClient.PAGE_BYTES * 2 - 1),
            Flux.just(ByteBuffer.wrap(getRandomByteArray(PageBlobClient.PAGE_BYTES * 2))), null,
            null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                Assertions.assertTrue(r.getValue().isServerEncrypted());
                Assertions.assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void pageBlobClearPage() {
        cpknPageBlob.create(PageBlobClient.PAGE_BYTES * 2).block();
        cpknPageBlob.uploadPagesWithResponse(new PageRange().setStart(0).setEnd(PageBlobClient.PAGE_BYTES - 1),
            Flux.just(ByteBuffer.wrap(getRandomByteArray(PageBlobClient.PAGE_BYTES))), null,
            null).block();

        assertAsyncResponseStatusCode(cpknPageBlob.clearPagesWithResponse(new PageRange().setStart(0)
            .setEnd(PageBlobClient.PAGE_BYTES - 1), null), 201);
    }

    @Test
    public void pageBlobResize() {
        cpknPageBlob.create(PageBlobClient.PAGE_BYTES * 2).block();
        assertAsyncResponseStatusCode(cpknPageBlob.resizeWithResponse(PageBlobClient.PAGE_BYTES * 2,
            null), 200);
    }

    @Test
    public void blockBlobUpload() {
        StepVerifier.create(cpknBlockBlob.uploadWithResponse(DATA.getDefaultFlux(),
            DATA.getDefaultDataSize(), null, null, null, null, null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                Assertions.assertTrue(r.getValue().isServerEncrypted());
                Assertions.assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @Test
    public void blockBlobStageBlock() {
        cpknBlockBlob.upload(DATA.getDefaultFlux(), DATA.getDefaultDataSize()).block();
        StepVerifier.create(cpknBlockBlob.stageBlockWithResponse(getBlockID(), DATA.getDefaultFlux(),
            DATA.getDefaultDataSize(), null, null))
            .assertNext(r -> {
                HttpHeaders headers = r.getHeaders();

                assertResponseStatusCode(r, 201);
                Assertions.assertTrue(Boolean.parseBoolean(headers.getValue(X_MS_REQUEST_SERVER_ENCRYPTED)));
                Assertions.assertEquals(scope1, headers.getValue(X_MS_ENCRYPTION_SCOPE));
            })
            .verifyComplete();
    }

    @Test
    public void blockBlobCommitBlockList() {
        String blockID = getBlockID();
        cpknBlockBlob.stageBlock(blockID, DATA.getDefaultFlux(), DATA.getDefaultDataSize()).block();
        List<String> ids = Collections.singletonList(blockID);

        StepVerifier.create(cpknBlockBlob.commitBlockListWithResponse(ids, null, null, null,
            null))
            .assertNext(r -> {
                assertResponseStatusCode(r, 201);
                Assertions.assertTrue(r.getValue().isServerEncrypted());
                Assertions.assertEquals(scope1, r.getValue().getEncryptionScope());
            })
            .verifyComplete();
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2020-12-06")
    @Test
    public void asyncCopyEncryptionScope() {
        BlobAsyncClient blobSource = ccAsync.getBlobAsyncClient(generateBlobName());
        blobSource.upload(DATA.getDefaultBinaryData()).block();

        String sas = blobSource.generateSas(new BlobServiceSasSignatureValues(testResourceNamer.now().plusDays(1),
            new BlobSasPermission().setTagsPermission(true).setReadPermission(true)));

        cpknBlockBlob.copyFromUrlWithResponse(new BlobCopyFromUrlOptions(blobSource.getBlobUrl() + "?" + sas)).block();

        StepVerifier.create(cpknBlockBlob.getProperties())
            .assertNext(r -> assertEquals(scope1, r.getEncryptionScope()))
            .verifyComplete();
    }

    @Test
    public void serviceClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BlobServiceClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .buildAsyncClient());
    }

    @Test
    public void containerClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BlobContainerClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .buildAsyncClient());
    }

    @Test
    public void blobClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BlobClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .endpoint(ccAsync.getBlobContainerUrl())
            .blobName(generateBlobName())
            .buildAsyncClient());
    }

    @Test
    public void appendBlobClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SpecializedBlobClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .endpoint(ccAsync.getBlobContainerUrl())
            .blobName(generateBlobName())
            .buildAppendBlobAsyncClient());
    }

    @Test
    public void blockBlobClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SpecializedBlobClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .endpoint(ccAsync.getBlobContainerUrl())
            .blobName(generateBlobName())
            .buildBlockBlobAsyncClient());
    }

    @Test
    public void pageBlobClientBuilderCheck() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new SpecializedBlobClientBuilder()
            .encryptionScope(es)
            .customerProvidedKey(new CustomerProvidedKey(getRandomKey()))
            .endpoint(ccAsync.getBlobContainerUrl())
            .blobName(generateBlobName())
            .buildPageBlobAsyncClient());
    }

    //todo isbr getEncryptionScope is protected **
    @Test
    public void getEncryptionScopeClient() {
        String newEncryptionScope = "newtestscope";

        // when: "AppendBlob"
        AppendBlobAsyncClient newCpknAppendBlob = cpknAppendBlob.getEncryptionScopeAsyncClient(newEncryptionScope);
        assertInstanceOf(AppendBlobAsyncClient.class, newCpknAppendBlob);
        assertNotEquals(cpknAppendBlob.getEncryptionScope(), newCpknAppendBlob.getEncryptionScope());

        // when: "BlockBlob"
        BlockBlobAsyncClient newCpknBlockBlob = cpknBlockBlob.getEncryptionScopeAsyncClient(newEncryptionScope);
        assertInstanceOf(BlockBlobAsyncClient.class, newCpknBlockBlob);
        assertNotEquals(cpknBlockBlob.getEncryptionScope(), newCpknBlockBlob.getEncryptionScope());

        // when: "PageBlob"
        PageBlobAsyncClient newCpknPageBlob = cpknPageBlob.getEncryptionScopeAsyncClient(newEncryptionScope);
        assertInstanceOf(PageBlobAsyncClient.class, newCpknPageBlob);
        assertNotEquals(cpknPageBlob.getEncryptionScope(), newCpknPageBlob.getEncryptionScope());

        // when: "BlobClient"
        BlobAsyncClient cpkBlobClient = cpknContainer.getBlobAsyncClient(generateBlobName()); // Inherits container's CPK
        BlobAsyncClient newCpknBlobClient = cpkBlobClient.getEncryptionScopeAsyncClient(newEncryptionScope);
        assertInstanceOf(BlobAsyncClient.class, newCpknBlobClient);
        assertNotEquals(cpkBlobClient.getEncryptionScope(), newCpknBlobClient.getEncryptionScope());

        // when: "BlobClientBase"
        BlobAsyncClientBase newCpknBlobClientBase = ((BlobAsyncClientBase) cpkBlobClient)
            .getEncryptionScopeAsyncClient(newEncryptionScope);
        assertInstanceOf(BlobAsyncClientBase.class, newCpknBlobClientBase);
        assertNotEquals(cpkBlobClient.getEncryptionScope(), newCpknBlobClientBase.getEncryptionScope());
    }
}
