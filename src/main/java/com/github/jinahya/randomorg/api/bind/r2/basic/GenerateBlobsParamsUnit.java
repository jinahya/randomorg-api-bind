package com.github.jinahya.randomorg.api.bind.r2.basic;

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

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;

import static java.util.Optional.ofNullable;

@Setter
@Getter
class GenerateBlobsParamsUnit {

    public static final String PROPERTY_NAME_SIZE = "size";

    public static final String PROPERTY_NAME_FORMAT = "format";

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + '{'
               + PROPERTY_NAME_SIZE + '=' + size
               + ',' + PROPERTY_NAME_FORMAT + '=' + format
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AssertTrue
    private boolean isSizeDivisibleBy8() {
        return size % Byte.SIZE == 0;
    }

    @AssertTrue
    private boolean isFormatOneOfPredefined() {
        if (format == null) {
            return true;
        }
        try {
            GenerateBlobsParams.Format.valueOf(format.toUpperCase());
            return true;
        } catch (final IllegalArgumentException iae) {
            iae.printStackTrace();
            return false;
        }
    }

    // ------------------------------------------------------------------------------------------------------------ size
    @com.owlike.genson.annotation.JsonIgnore
    // TODO: Moshi
    // TODO: Gson
    @com.fasterxml.jackson.annotation.JsonIgnore
    @Transient
    public int getSizeInBytes() {
        return getSize() >> 3;
    }

    public void setSizeInBytes(final int sizeInBytes) {
        if (sizeInBytes <= 0) {
            throw new IllegalArgumentException("sizeInBytes(" + sizeInBytes + ") <= 0");
        }
        setSize(sizeInBytes << 3);
    }

    // ---------------------------------------------------------------------------------------------------------- format
    @com.owlike.genson.annotation.JsonIgnore
    // TODO: Moshi
    // TODO: Gson
    @com.fasterxml.jackson.annotation.JsonIgnore
    @Transient
    public GenerateBlobsParams.Format getFormatAsOneOfPredefined() {
        return ofNullable(getFormat()).map(String::toUpperCase).map(GenerateBlobsParams.Format::valueOf).orElse(null);
    }

    public void setFormatAsOneOfPredefined(final GenerateBlobsParams.Format formatAsEnum) {
        setFormat(ofNullable(formatAsEnum).map(Enum::name).map(String::toLowerCase).orElse(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
//    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_SIZE)
//    @com.squareup.moshi.Json(name = PROPERTY_NAME_SIZE)
//    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_SIZE)
//    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_SIZE)
    @Max(GenerateBlobsParams.MAX_SIZE)
    @Min(GenerateBlobsParams.MIN_SIZE)
    private int size = Byte.SIZE;

    //    @com.owlike.genson.annotation.JsonProperty(PROPERTY_NAME_FORMAT)
//    @com.squareup.moshi.Json(name = PROPERTY_NAME_FORMAT)
//    @com.google.gson.annotations.SerializedName(PROPERTY_NAME_FORMAT)
//    @com.fasterxml.jackson.annotation.JsonProperty(PROPERTY_NAME_FORMAT)
    @Pattern(regexp = "(base64|hex)")
    private String format = GenerateBlobsParams.Format.BASE64.getJsonValue();
}
