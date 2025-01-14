// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.analytics.purview.datamap.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * An instance of an entity - like hive_table, hive_database.
 */
@Fluent
public final class AtlasEntityHeader {
    /*
     * The attributes of the struct.
     */
    @Generated
    @JsonProperty(value = "attributes")
    private Map<String, Object> attributes;

    /*
     * The name of the type.
     */
    @Generated
    @JsonProperty(value = "typeName")
    private String typeName;

    /*
     * ETag for concurrency control.
     */
    @Generated
    @JsonProperty(value = "lastModifiedTS")
    private String lastModifiedTS;

    /*
     * An array of classification names.
     */
    @Generated
    @JsonProperty(value = "classificationNames")
    private List<String> classificationNames;

    /*
     * An array of classifications.
     */
    @Generated
    @JsonProperty(value = "classifications")
    private List<AtlasClassification> classifications;

    /*
     * The display text.
     */
    @Generated
    @JsonProperty(value = "displayText")
    private String displayText;

    /*
     * The GUID of the record.
     */
    @Generated
    @JsonProperty(value = "guid")
    private String guid;

    /*
     * Whether it is a shell entity
     */
    @Generated
    @JsonProperty(value = "isIncomplete")
    private Boolean isIncomplete;

    /*
     * labels
     */
    @Generated
    @JsonProperty(value = "labels")
    private List<String> labels;

    /*
     * An array of meanings.
     */
    @Generated
    @JsonProperty(value = "meaningNames")
    private List<String> meaningNames;

    /*
     * An array of term assignment headers.
     */
    @Generated
    @JsonProperty(value = "meanings")
    private List<AtlasTermAssignmentHeader> meanings;

    /*
     * Status of the entity - can be active or deleted. Deleted entities are not
     * removed.
     */
    @Generated
    @JsonProperty(value = "status")
    private EntityStatus status;

    /**
     * Creates an instance of AtlasEntityHeader class.
     */
    @Generated
    public AtlasEntityHeader() {
    }

    /**
     * Get the attributes property: The attributes of the struct.
     * 
     * @return the attributes value.
     */
    @Generated
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    /**
     * Set the attributes property: The attributes of the struct.
     * 
     * @param attributes the attributes value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Get the typeName property: The name of the type.
     * 
     * @return the typeName value.
     */
    @Generated
    public String getTypeName() {
        return this.typeName;
    }

    /**
     * Set the typeName property: The name of the type.
     * 
     * @param typeName the typeName value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    /**
     * Get the lastModifiedTS property: ETag for concurrency control.
     * 
     * @return the lastModifiedTS value.
     */
    @Generated
    public String getLastModifiedTS() {
        return this.lastModifiedTS;
    }

    /**
     * Set the lastModifiedTS property: ETag for concurrency control.
     * 
     * @param lastModifiedTS the lastModifiedTS value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setLastModifiedTS(String lastModifiedTS) {
        this.lastModifiedTS = lastModifiedTS;
        return this;
    }

    /**
     * Get the classificationNames property: An array of classification names.
     * 
     * @return the classificationNames value.
     */
    @Generated
    public List<String> getClassificationNames() {
        return this.classificationNames;
    }

    /**
     * Set the classificationNames property: An array of classification names.
     * 
     * @param classificationNames the classificationNames value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setClassificationNames(List<String> classificationNames) {
        this.classificationNames = classificationNames;
        return this;
    }

    /**
     * Get the classifications property: An array of classifications.
     * 
     * @return the classifications value.
     */
    @Generated
    public List<AtlasClassification> getClassifications() {
        return this.classifications;
    }

    /**
     * Set the classifications property: An array of classifications.
     * 
     * @param classifications the classifications value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setClassifications(List<AtlasClassification> classifications) {
        this.classifications = classifications;
        return this;
    }

    /**
     * Get the displayText property: The display text.
     * 
     * @return the displayText value.
     */
    @Generated
    public String getDisplayText() {
        return this.displayText;
    }

    /**
     * Set the displayText property: The display text.
     * 
     * @param displayText the displayText value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setDisplayText(String displayText) {
        this.displayText = displayText;
        return this;
    }

    /**
     * Get the guid property: The GUID of the record.
     * 
     * @return the guid value.
     */
    @Generated
    public String getGuid() {
        return this.guid;
    }

    /**
     * Set the guid property: The GUID of the record.
     * 
     * @param guid the guid value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setGuid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get the isIncomplete property: Whether it is a shell entity.
     * 
     * @return the isIncomplete value.
     */
    @Generated
    public Boolean isIncomplete() {
        return this.isIncomplete;
    }

    /**
     * Set the isIncomplete property: Whether it is a shell entity.
     * 
     * @param isIncomplete the isIncomplete value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setIsIncomplete(Boolean isIncomplete) {
        this.isIncomplete = isIncomplete;
        return this;
    }

    /**
     * Get the labels property: labels.
     * 
     * @return the labels value.
     */
    @Generated
    public List<String> getLabels() {
        return this.labels;
    }

    /**
     * Set the labels property: labels.
     * 
     * @param labels the labels value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    /**
     * Get the meaningNames property: An array of meanings.
     * 
     * @return the meaningNames value.
     */
    @Generated
    public List<String> getMeaningNames() {
        return this.meaningNames;
    }

    /**
     * Set the meaningNames property: An array of meanings.
     * 
     * @param meaningNames the meaningNames value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setMeaningNames(List<String> meaningNames) {
        this.meaningNames = meaningNames;
        return this;
    }

    /**
     * Get the meanings property: An array of term assignment headers.
     * 
     * @return the meanings value.
     */
    @Generated
    public List<AtlasTermAssignmentHeader> getMeanings() {
        return this.meanings;
    }

    /**
     * Set the meanings property: An array of term assignment headers.
     * 
     * @param meanings the meanings value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setMeanings(List<AtlasTermAssignmentHeader> meanings) {
        this.meanings = meanings;
        return this;
    }

    /**
     * Get the status property: Status of the entity - can be active or deleted. Deleted entities are not
     * removed.
     * 
     * @return the status value.
     */
    @Generated
    public EntityStatus getStatus() {
        return this.status;
    }

    /**
     * Set the status property: Status of the entity - can be active or deleted. Deleted entities are not
     * removed.
     * 
     * @param status the status value to set.
     * @return the AtlasEntityHeader object itself.
     */
    @Generated
    public AtlasEntityHeader setStatus(EntityStatus status) {
        this.status = status;
        return this;
    }
}
