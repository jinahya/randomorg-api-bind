package com.github.jinahya.randomorg.api.bind.r2;

/*-
 * #%L
 * randomorg-api-bind
 * %%
 * Copyright (C) 2020 Jinahya, Inc.
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
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

@Setter
@Getter
public abstract class AbstractResultRandom<T> {

    public static final String PROPERTY_NAME_DATA = "data";

    public static final String PROPERTY_NAME_COMPLETION_TIME = "completionTime";

    private static final DateTimeFormatter COMPLETION_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ssX");

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + '{'
               + PROPERTY_NAME_DATA + '=' + data
               + ',' + PROPERTY_NAME_COMPLETION_TIME + '=' + completionTime
               + '}';
    }

    // -------------------------------------------------------------------------------------------------- completionTime
    public TemporalAccessor getCompletionTimeAsTemporalAccessorParsedWith(final DateTimeFormatter formatter) {
        requireNonNull(formatter, "formatter is null");
        return ofNullable(getCompletionTime()).map(formatter::parse).orElse(null);
    }

    @com.owlike.genson.annotation.JsonIgnore
    // TODO: Moshi
    // TODO: Gson
    @com.fasterxml.jackson.annotation.JsonIgnore
    @Transient
    public TemporalAccessor getCompletionTimeAsTemporalAccessor() {
        return getCompletionTimeAsTemporalAccessorParsedWith(COMPLETION_TIME_FORMATTER);
    }

    // -------------------------------------------------------------------------------------------------------------
    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_DATA)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_DATA)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_DATA)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_DATA)
    @NotEmpty
    private List<T> data;

    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_COMPLETION_TIME)
    @com.squareup.moshi.Json(name = PROPERTY_NAME_COMPLETION_TIME)
    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_COMPLETION_TIME)
    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_COMPLETION_TIME)
    @NotBlank
    private String completionTime;
}
