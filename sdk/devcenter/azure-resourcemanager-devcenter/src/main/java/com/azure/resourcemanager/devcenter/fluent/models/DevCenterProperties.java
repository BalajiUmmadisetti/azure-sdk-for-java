// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.devcenter.models.Encryption;
import com.azure.resourcemanager.devcenter.models.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Properties of the devcenter. */
@Fluent
public final class DevCenterProperties extends DevCenterUpdateProperties {
    /*
     * The provisioning state of the resource.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * The URI of the Dev Center.
     */
    @JsonProperty(value = "devCenterUri", access = JsonProperty.Access.WRITE_ONLY)
    private String devCenterUri;

    /** Creates an instance of DevCenterProperties class. */
    public DevCenterProperties() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the resource.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the devCenterUri property: The URI of the Dev Center.
     *
     * @return the devCenterUri value.
     */
    public String devCenterUri() {
        return this.devCenterUri;
    }

    /** {@inheritDoc} */
    @Override
    public DevCenterProperties withEncryption(Encryption encryption) {
        super.withEncryption(encryption);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public DevCenterProperties withDisplayName(String displayName) {
        super.withDisplayName(displayName);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
