// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.fluent.models.BlobTriggerTypeProperties;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class BlobTriggerTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BlobTriggerTypeProperties model = BinaryData.fromString(
            "{\"folderPath\":\"ixbyedcavvjpjnn\",\"maxConcurrency\":24880351,\"linkedService\":{\"referenceName\":\"fednmqxbauzv\",\"parameters\":{\"g\":\"dataicp\",\"o\":\"datacvmuqx\"}}}")
            .toObject(BlobTriggerTypeProperties.class);
        Assertions.assertEquals("ixbyedcavvjpjnn", model.folderPath());
        Assertions.assertEquals(24880351, model.maxConcurrency());
        Assertions.assertEquals("fednmqxbauzv", model.linkedService().referenceName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BlobTriggerTypeProperties model = new BlobTriggerTypeProperties().withFolderPath("ixbyedcavvjpjnn")
            .withMaxConcurrency(24880351).withLinkedService(new LinkedServiceReference()
                .withReferenceName("fednmqxbauzv").withParameters(mapOf("g", "dataicp", "o", "datacvmuqx")));
        model = BinaryData.fromObject(model).toObject(BlobTriggerTypeProperties.class);
        Assertions.assertEquals("ixbyedcavvjpjnn", model.folderPath());
        Assertions.assertEquals(24880351, model.maxConcurrency());
        Assertions.assertEquals("fednmqxbauzv", model.linkedService().referenceName());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
