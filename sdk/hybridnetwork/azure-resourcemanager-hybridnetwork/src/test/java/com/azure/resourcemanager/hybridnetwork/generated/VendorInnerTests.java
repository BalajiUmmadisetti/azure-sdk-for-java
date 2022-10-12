// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridnetwork.fluent.models.VendorInner;
import org.junit.jupiter.api.Test;

public final class VendorInnerTests {
    @Test
    public void testDeserialize() {
        VendorInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"provisioningState\":\"Canceled\",\"skus\":[{\"id\":\"odmgl\"},{\"id\":\"gpbkwtmut\"},{\"id\":\"qktapspwgcuert\"}]},\"id\":\"kdosvqw\",\"name\":\"bmdg\",\"type\":\"bjf\"}")
                .toObject(VendorInner.class);
    }

    @Test
    public void testSerialize() {
        VendorInner model = new VendorInner();
        model = BinaryData.fromObject(model).toObject(VendorInner.class);
    }
}