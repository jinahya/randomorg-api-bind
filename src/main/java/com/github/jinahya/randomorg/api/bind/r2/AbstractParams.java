package com.github.jinahya.randomorg.api.bind.r2;

/*-
 * #%L
 * jsonrpc-bind-jackson
 * %%
 * Copyright (C) 2019 - 2020 Jinahya, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class AbstractParams {

    private static final String PROPERTY_NAME_API_KEY = "apiKey";

    @Override
    public String toString() {
        return super.toString() + '{'
               + PROPERTY_NAME_API_KEY + '=' + apiKey
               + '}';
    }

    // ---------------------------------------------------------------------------------------------------------- apiKey

    // -----------------------------------------------------------------------------------------------------------------
    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_API_KEY)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_API_KEY)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_API_KEY)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_API_KEY)
    @NotBlank
    private String apiKey;
}
