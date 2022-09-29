// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devhub.models;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.devhub.fluent.models.WorkflowInner;
import java.util.Map;

/** An immutable client-side representation of Workflow. */
public interface Workflow {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     *
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     *
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     *
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     *
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     *
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the repositoryOwner property: The owner of the repository the workflow is associated with.
     *
     * <p>Repository Owner.
     *
     * @return the repositoryOwner value.
     */
    String repositoryOwner();

    /**
     * Gets the repositoryName property: The name of the repository the workflow is associated with.
     *
     * <p>Repository Name.
     *
     * @return the repositoryName value.
     */
    String repositoryName();

    /**
     * Gets the branchName property: The name of the branch the workflow is associated with.
     *
     * <p>Repository Branch Name.
     *
     * @return the branchName value.
     */
    String branchName();

    /**
     * Gets the dockerfile property: Path to Dockerfile within the repository.
     *
     * <p>Path to the Dockerfile within the repository.
     *
     * @return the dockerfile value.
     */
    String dockerfile();

    /**
     * Gets the dockerBuildContext property: Path to Dockerfile Build Context within the repository.
     *
     * @return the dockerBuildContext value.
     */
    String dockerBuildContext();

    /**
     * Gets the deploymentProperties property: The deploymentProperties property.
     *
     * @return the deploymentProperties value.
     */
    DeploymentProperties deploymentProperties();

    /**
     * Gets the namespace property: The Kubernetes namespace the application is deployed to
     *
     * <p>Kubernetes namespace the application is deployed to.
     *
     * @return the namespace value.
     */
    String namespace();

    /**
     * Gets the acr property: Information on the azure container registry.
     *
     * @return the acr value.
     */
    Acr acr();

    /**
     * Gets the oidcCredentials property: The fields needed for OIDC with GitHub.
     *
     * @return the oidcCredentials value.
     */
    GitHubWorkflowProfileOidcCredentials oidcCredentials();

    /**
     * Gets the aksResourceId property: The Azure Kubernetes Managed Cluster resource.
     *
     * <p>The Azure Kubernetes Cluster Resource the application will be deployed to.
     *
     * @return the aksResourceId value.
     */
    String aksResourceId();

    /**
     * Gets the prUrl property: The URL to the Pull Request submitted against the users repository.
     *
     * @return the prUrl value.
     */
    String prUrl();

    /**
     * Gets the pullNumber property: The number associated with the submitted pull request.
     *
     * @return the pullNumber value.
     */
    Integer pullNumber();

    /**
     * Gets the prStatus property: The status of the Pull Request submitted against the users repository.
     *
     * @return the prStatus value.
     */
    PullRequestStatus prStatus();

    /**
     * Gets the lastWorkflowRun property: The lastWorkflowRun property.
     *
     * @return the lastWorkflowRun value.
     */
    WorkflowRun lastWorkflowRun();

    /**
     * Gets the authStatus property: Determines the type of manifests within the repository.
     *
     * @return the authStatus value.
     */
    ManifestType authStatus();

    /**
     * Gets the region of the resource.
     *
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     *
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     *
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.devhub.fluent.models.WorkflowInner object.
     *
     * @return the inner object.
     */
    WorkflowInner innerModel();

    /** The entirety of the Workflow definition. */
    interface Definition
        extends DefinitionStages.Blank,
            DefinitionStages.WithLocation,
            DefinitionStages.WithResourceGroup,
            DefinitionStages.WithCreate {
    }
    /** The Workflow definition stages. */
    interface DefinitionStages {
        /** The first stage of the Workflow definition. */
        interface Blank extends WithLocation {
        }
        /** The stage of the Workflow definition allowing to specify location. */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             *
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }
        /** The stage of the Workflow definition allowing to specify parent resource. */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             *
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }
        /**
         * The stage of the Workflow definition which contains all the minimum required properties for the resource to
         * be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags,
                DefinitionStages.WithRepositoryOwner,
                DefinitionStages.WithRepositoryName,
                DefinitionStages.WithBranchName,
                DefinitionStages.WithDockerfile,
                DefinitionStages.WithDockerBuildContext,
                DefinitionStages.WithDeploymentProperties,
                DefinitionStages.WithNamespace,
                DefinitionStages.WithAcr,
                DefinitionStages.WithOidcCredentials,
                DefinitionStages.WithAksResourceId,
                DefinitionStages.WithLastWorkflowRun,
                DefinitionStages.WithAuthStatus {
            /**
             * Executes the create request.
             *
             * @return the created resource.
             */
            Workflow create();

            /**
             * Executes the create request.
             *
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            Workflow create(Context context);
        }
        /** The stage of the Workflow definition allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             *
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }
        /** The stage of the Workflow definition allowing to specify repositoryOwner. */
        interface WithRepositoryOwner {
            /**
             * Specifies the repositoryOwner property: The owner of the repository the workflow is associated with.
             *
             * <p>Repository Owner.
             *
             * @param repositoryOwner The owner of the repository the workflow is associated with.
             *     <p>Repository Owner.
             * @return the next definition stage.
             */
            WithCreate withRepositoryOwner(String repositoryOwner);
        }
        /** The stage of the Workflow definition allowing to specify repositoryName. */
        interface WithRepositoryName {
            /**
             * Specifies the repositoryName property: The name of the repository the workflow is associated with.
             *
             * <p>Repository Name.
             *
             * @param repositoryName The name of the repository the workflow is associated with.
             *     <p>Repository Name.
             * @return the next definition stage.
             */
            WithCreate withRepositoryName(String repositoryName);
        }
        /** The stage of the Workflow definition allowing to specify branchName. */
        interface WithBranchName {
            /**
             * Specifies the branchName property: The name of the branch the workflow is associated with.
             *
             * <p>Repository Branch Name.
             *
             * @param branchName The name of the branch the workflow is associated with.
             *     <p>Repository Branch Name.
             * @return the next definition stage.
             */
            WithCreate withBranchName(String branchName);
        }
        /** The stage of the Workflow definition allowing to specify dockerfile. */
        interface WithDockerfile {
            /**
             * Specifies the dockerfile property: Path to Dockerfile within the repository.
             *
             * <p>Path to the Dockerfile within the repository..
             *
             * @param dockerfile Path to Dockerfile within the repository.
             *     <p>Path to the Dockerfile within the repository.
             * @return the next definition stage.
             */
            WithCreate withDockerfile(String dockerfile);
        }
        /** The stage of the Workflow definition allowing to specify dockerBuildContext. */
        interface WithDockerBuildContext {
            /**
             * Specifies the dockerBuildContext property: Path to Dockerfile Build Context within the repository..
             *
             * @param dockerBuildContext Path to Dockerfile Build Context within the repository.
             * @return the next definition stage.
             */
            WithCreate withDockerBuildContext(String dockerBuildContext);
        }
        /** The stage of the Workflow definition allowing to specify deploymentProperties. */
        interface WithDeploymentProperties {
            /**
             * Specifies the deploymentProperties property: The deploymentProperties property..
             *
             * @param deploymentProperties The deploymentProperties property.
             * @return the next definition stage.
             */
            WithCreate withDeploymentProperties(DeploymentProperties deploymentProperties);
        }
        /** The stage of the Workflow definition allowing to specify namespace. */
        interface WithNamespace {
            /**
             * Specifies the namespace property: The Kubernetes namespace the application is deployed to
             *
             * <p>Kubernetes namespace the application is deployed to..
             *
             * @param namespace The Kubernetes namespace the application is deployed to
             *     <p>Kubernetes namespace the application is deployed to.
             * @return the next definition stage.
             */
            WithCreate withNamespace(String namespace);
        }
        /** The stage of the Workflow definition allowing to specify acr. */
        interface WithAcr {
            /**
             * Specifies the acr property: Information on the azure container registry.
             *
             * @param acr Information on the azure container registry.
             * @return the next definition stage.
             */
            WithCreate withAcr(Acr acr);
        }
        /** The stage of the Workflow definition allowing to specify oidcCredentials. */
        interface WithOidcCredentials {
            /**
             * Specifies the oidcCredentials property: The fields needed for OIDC with GitHub..
             *
             * @param oidcCredentials The fields needed for OIDC with GitHub.
             * @return the next definition stage.
             */
            WithCreate withOidcCredentials(GitHubWorkflowProfileOidcCredentials oidcCredentials);
        }
        /** The stage of the Workflow definition allowing to specify aksResourceId. */
        interface WithAksResourceId {
            /**
             * Specifies the aksResourceId property: The Azure Kubernetes Managed Cluster resource.
             *
             * <p>The Azure Kubernetes Cluster Resource the application will be deployed to..
             *
             * @param aksResourceId The Azure Kubernetes Managed Cluster resource.
             *     <p>The Azure Kubernetes Cluster Resource the application will be deployed to.
             * @return the next definition stage.
             */
            WithCreate withAksResourceId(String aksResourceId);
        }
        /** The stage of the Workflow definition allowing to specify lastWorkflowRun. */
        interface WithLastWorkflowRun {
            /**
             * Specifies the lastWorkflowRun property: The lastWorkflowRun property..
             *
             * @param lastWorkflowRun The lastWorkflowRun property.
             * @return the next definition stage.
             */
            WithCreate withLastWorkflowRun(WorkflowRun lastWorkflowRun);
        }
        /** The stage of the Workflow definition allowing to specify authStatus. */
        interface WithAuthStatus {
            /**
             * Specifies the authStatus property: Determines the type of manifests within the repository..
             *
             * @param authStatus Determines the type of manifests within the repository.
             * @return the next definition stage.
             */
            WithCreate withAuthStatus(ManifestType authStatus);
        }
    }
    /**
     * Begins update for the Workflow resource.
     *
     * @return the stage of resource update.
     */
    Workflow.Update update();

    /** The template for Workflow update. */
    interface Update extends UpdateStages.WithTags {
        /**
         * Executes the update request.
         *
         * @return the updated resource.
         */
        Workflow apply();

        /**
         * Executes the update request.
         *
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        Workflow apply(Context context);
    }
    /** The Workflow update stages. */
    interface UpdateStages {
        /** The stage of the Workflow update allowing to specify tags. */
        interface WithTags {
            /**
             * Specifies the tags property: Dictionary of &lt;string&gt;.
             *
             * @param tags Dictionary of &lt;string&gt;.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }
    }
    /**
     * Refreshes the resource to sync with Azure.
     *
     * @return the refreshed resource.
     */
    Workflow refresh();

    /**
     * Refreshes the resource to sync with Azure.
     *
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    Workflow refresh(Context context);
}