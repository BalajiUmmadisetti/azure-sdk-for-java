// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.security.fluent.models.GovernanceRuleInner;

/** Resource collection API of SecurityConnectorGovernanceRulesOperations. */
public interface SecurityConnectorGovernanceRulesOperations {
    /**
     * Get a specific governanceRule for the requested scope by ruleId.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific governanceRule for the requested scope by ruleId.
     */
    GovernanceRule get(String resourceGroupName, String securityConnectorName, String ruleId);

    /**
     * Get a specific governanceRule for the requested scope by ruleId.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a specific governanceRule for the requested scope by ruleId along with {@link Response}.
     */
    Response<GovernanceRule> getWithResponse(
        String resourceGroupName, String securityConnectorName, String ruleId, Context context);

    /**
     * Creates or update a security GovernanceRule on the given security connector.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @param governanceRule GovernanceRule over a subscription scope.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return security GovernanceRule over a given scope.
     */
    GovernanceRule createOrUpdate(
        String resourceGroupName, String securityConnectorName, String ruleId, GovernanceRuleInner governanceRule);

    /**
     * Creates or update a security GovernanceRule on the given security connector.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @param governanceRule GovernanceRule over a subscription scope.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return security GovernanceRule over a given scope along with {@link Response}.
     */
    Response<GovernanceRule> createOrUpdateWithResponse(
        String resourceGroupName,
        String securityConnectorName,
        String ruleId,
        GovernanceRuleInner governanceRule,
        Context context);

    /**
     * Delete a GovernanceRule over a given scope.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String securityConnectorName, String ruleId);

    /**
     * Delete a GovernanceRule over a given scope.
     *
     * @param resourceGroupName The name of the resource group within the user's subscription. The name is case
     *     insensitive.
     * @param securityConnectorName The security connector name.
     * @param ruleId The security GovernanceRule key - unique key for the standard GovernanceRule.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(
        String resourceGroupName, String securityConnectorName, String ruleId, Context context);
}