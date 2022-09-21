// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.kusto.fluent.models.ScriptInner;
import com.azure.resourcemanager.kusto.models.ScriptListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class ScriptListResultTests {
    @Test
    public void testDeserialize() {
        ScriptListResult model =
            BinaryData
                .fromString(
                    "{\"value\":[{\"properties\":{\"scriptUrl\":\"q\",\"scriptUrlSasToken\":\"wpmqt\",\"scriptContent\":\"uoujmkcjhwqy\",\"forceUpdateTag\":\"r\",\"continueOnErrors\":false,\"provisioningState\":\"Running\"},\"id\":\"wgdrjervnaenqp\",\"name\":\"hin\",\"type\":\"oygmift\"},{\"properties\":{\"scriptUrl\":\"d\",\"scriptUrlSasToken\":\"sl\",\"scriptContent\":\"ayqigynduhav\",\"forceUpdateTag\":\"lkthu\",\"continueOnErrors\":false,\"provisioningState\":\"Failed\"},\"id\":\"gycdu\",\"name\":\"ertgccymva\",\"type\":\"l\"}]}")
                .toObject(ScriptListResult.class);
        Assertions.assertEquals("q", model.value().get(0).scriptUrl());
        Assertions.assertEquals("wpmqt", model.value().get(0).scriptUrlSasToken());
        Assertions.assertEquals("uoujmkcjhwqy", model.value().get(0).scriptContent());
        Assertions.assertEquals("r", model.value().get(0).forceUpdateTag());
        Assertions.assertEquals(false, model.value().get(0).continueOnErrors());
    }

    @Test
    public void testSerialize() {
        ScriptListResult model =
            new ScriptListResult()
                .withValue(
                    Arrays
                        .asList(
                            new ScriptInner()
                                .withScriptUrl("q")
                                .withScriptUrlSasToken("wpmqt")
                                .withScriptContent("uoujmkcjhwqy")
                                .withForceUpdateTag("r")
                                .withContinueOnErrors(false),
                            new ScriptInner()
                                .withScriptUrl("d")
                                .withScriptUrlSasToken("sl")
                                .withScriptContent("ayqigynduhav")
                                .withForceUpdateTag("lkthu")
                                .withContinueOnErrors(false)));
        model = BinaryData.fromObject(model).toObject(ScriptListResult.class);
        Assertions.assertEquals("q", model.value().get(0).scriptUrl());
        Assertions.assertEquals("wpmqt", model.value().get(0).scriptUrlSasToken());
        Assertions.assertEquals("uoujmkcjhwqy", model.value().get(0).scriptContent());
        Assertions.assertEquals("r", model.value().get(0).forceUpdateTag());
        Assertions.assertEquals(false, model.value().get(0).continueOnErrors());
    }
}