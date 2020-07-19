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

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.time.Duration;
import java.time.temporal.TemporalAmount;

@Setter
@Getter
public abstract class AbstractResult<T> {

    public static final String PROPERTY_NAME_RANDOM = "random";

    public static final String PROPERTY_NAME_BITS_USED = "bitsUsed";

    public static final String PROPERTY_NAME_BITS_LEFT = "bitsLeft";

    public static final String PROPERTY_NAME_REQUESTS_LEFT = "requestsLeft";

    public static final String PROPERTY_NAME_ADVISORY_DELAY = "advisoryDelay";

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + '{'
               + PROPERTY_NAME_RANDOM + '=' + random
               + ',' + PROPERTY_NAME_BITS_USED + '=' + bitsUsed
               + ',' + PROPERTY_NAME_BITS_LEFT + '=' + bitsLeft
               + ',' + PROPERTY_NAME_REQUESTS_LEFT + '=' + requestsLeft
               + ',' + PROPERTY_NAME_ADVISORY_DELAY + '=' + advisoryDelay
               + '}';
    }

    // --------------------------------------------------------------------------------------------------- advisoryDelay
    @com.owlike.genson.annotation.JsonIgnore
    // TODO: Moshi
    // TODO: Gson
    @com.fasterxml.jackson.annotation.JsonIgnore
    @Transient
    public TemporalAmount getAdvisoryDelayAsTemporalAmount() {
        return Duration.ofMillis(getAdvisoryDelay());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_RANDOM)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_RANDOM)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_RANDOM)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_RANDOM)
    @Valid
    @NotNull
    private T random;

    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_BITS_USED)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_BITS_USED)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_BITS_USED)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_BITS_USED)
    @Positive
    private int bitsUsed;

    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_BITS_LEFT)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_BITS_LEFT)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_BITS_LEFT)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_BITS_LEFT)
    @PositiveOrZero
    private int bitsLeft;

    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_REQUESTS_LEFT)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_REQUESTS_LEFT)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_REQUESTS_LEFT)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_REQUESTS_LEFT)
    @PositiveOrZero
    private int requestsLeft;

    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_ADVISORY_DELAY)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_ADVISORY_DELAY)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_ADVISORY_DELAY)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_ADVISORY_DELAY)
    @PositiveOrZero
    private long advisoryDelay;
}
