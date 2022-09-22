// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.PricingInner;
import com.azure.resourcemanager.security.models.PricingTier;

/** Samples for Pricings Update. */
public final class PricingsUpdateSamples {
    /*
     * x-ms-original-file: specification/security/resource-manager/Microsoft.Security/stable/2022-03-01/examples/Pricings/PutPricingByName_example.json
     */
    /**
     * Sample code: Update pricing on subscription.
     *
     * @param manager Entry point to SecurityManager.
     */
    public static void updatePricingOnSubscription(com.azure.resourcemanager.security.SecurityManager manager) {
        manager
            .pricings()
            .updateWithResponse(
                "VirtualMachines",
                new PricingInner().withPricingTier(PricingTier.STANDARD).withSubPlan("P2"),
                Context.NONE);
    }
}