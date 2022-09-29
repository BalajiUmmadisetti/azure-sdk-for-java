// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.implementation;

import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.securityinsights.fluent.models.FileImportInner;
import com.azure.resourcemanager.securityinsights.models.FileImport;
import com.azure.resourcemanager.securityinsights.models.FileImportContentType;
import com.azure.resourcemanager.securityinsights.models.FileImportState;
import com.azure.resourcemanager.securityinsights.models.FileMetadata;
import com.azure.resourcemanager.securityinsights.models.IngestionMode;
import com.azure.resourcemanager.securityinsights.models.ValidationError;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

public final class FileImportImpl implements FileImport, FileImport.Definition {
    private FileImportInner innerObject;

    private final com.azure.resourcemanager.securityinsights.SecurityInsightsManager serviceManager;

    FileImportImpl(
        FileImportInner innerObject,
        com.azure.resourcemanager.securityinsights.SecurityInsightsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public IngestionMode ingestionMode() {
        return this.innerModel().ingestionMode();
    }

    public FileImportContentType contentType() {
        return this.innerModel().contentType();
    }

    public OffsetDateTime createdTimeUtc() {
        return this.innerModel().createdTimeUtc();
    }

    public FileMetadata errorFile() {
        return this.innerModel().errorFile();
    }

    public List<ValidationError> errorsPreview() {
        List<ValidationError> inner = this.innerModel().errorsPreview();
        if (inner != null) {
            return Collections.unmodifiableList(inner);
        } else {
            return Collections.emptyList();
        }
    }

    public FileMetadata importFile() {
        return this.innerModel().importFile();
    }

    public Integer ingestedRecordCount() {
        return this.innerModel().ingestedRecordCount();
    }

    public String source() {
        return this.innerModel().source();
    }

    public FileImportState state() {
        return this.innerModel().state();
    }

    public Integer totalRecordCount() {
        return this.innerModel().totalRecordCount();
    }

    public Integer validRecordCount() {
        return this.innerModel().validRecordCount();
    }

    public OffsetDateTime filesValidUntilTimeUtc() {
        return this.innerModel().filesValidUntilTimeUtc();
    }

    public OffsetDateTime importValidUntilTimeUtc() {
        return this.innerModel().importValidUntilTimeUtc();
    }

    public FileImportInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.securityinsights.SecurityInsightsManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String workspaceName;

    private String fileImportId;

    public FileImportImpl withExistingWorkspace(String resourceGroupName, String workspaceName) {
        this.resourceGroupName = resourceGroupName;
        this.workspaceName = workspaceName;
        return this;
    }

    public FileImport create() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getFileImports()
                .createWithResponse(resourceGroupName, workspaceName, fileImportId, this.innerModel(), Context.NONE)
                .getValue();
        return this;
    }

    public FileImport create(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getFileImports()
                .createWithResponse(resourceGroupName, workspaceName, fileImportId, this.innerModel(), context)
                .getValue();
        return this;
    }

    FileImportImpl(String name, com.azure.resourcemanager.securityinsights.SecurityInsightsManager serviceManager) {
        this.innerObject = new FileImportInner();
        this.serviceManager = serviceManager;
        this.fileImportId = name;
    }

    public FileImport refresh() {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getFileImports()
                .getWithResponse(resourceGroupName, workspaceName, fileImportId, Context.NONE)
                .getValue();
        return this;
    }

    public FileImport refresh(Context context) {
        this.innerObject =
            serviceManager
                .serviceClient()
                .getFileImports()
                .getWithResponse(resourceGroupName, workspaceName, fileImportId, context)
                .getValue();
        return this;
    }

    public FileImportImpl withIngestionMode(IngestionMode ingestionMode) {
        this.innerModel().withIngestionMode(ingestionMode);
        return this;
    }

    public FileImportImpl withContentType(FileImportContentType contentType) {
        this.innerModel().withContentType(contentType);
        return this;
    }

    public FileImportImpl withImportFile(FileMetadata importFile) {
        this.innerModel().withImportFile(importFile);
        return this;
    }

    public FileImportImpl withSource(String source) {
        this.innerModel().withSource(source);
        return this;
    }
}