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

import com.github.jinahya.randomorg.api.bind.r2.AbstractParams;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.util.Base64;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

@Setter
@Getter
public class GenerateBlobsParams extends AbstractParams {

    // --------------------------------------------------------------------------------------------------------------- n
    public static final String PROPERTY_NAME_N = "n";

    public static final int MIN_N = 1;

    public static final int MAX_N = 100;

    // ------------------------------------------------------------------------------------------------------------ size
    public static final String PROPERTY_NAME_SIZE = "size";

    public static final int MIN_SIZE = 1;

    public static final int MAX_SIZE = 1048576;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_FORMAT = "format";

    public static final String PATTERN_REGEXP_FORMAT = "(base64|hex)";

    // -----------------------------------------------------------------------------------------------------------------
    public enum Format {

        BASE64() {
            public byte[] decode(final String encoded) {
                requireNonNull(encoded, "encoded is null");
                return Base64.getDecoder().decode(encoded);
            }
        },

        HEX() {
            public byte[] decode(final String encoded) {
                requireNonNull(encoded, "encoded is null");
                if ((encoded.length() & 0b01) == 0b01) {
                    throw new IllegalArgumentException("wrong encoded.length(" + encoded.length() + ")");
                }
                final int length = encoded.length();
                byte[] decoded = new byte[length >> 1];
                int j = 0;
                for (int i = 0; i < length; i += 2) {
                    decoded[j++] = (byte) ((Character.digit(encoded.charAt(i), 16) << 4)
                                           + Character.digit(encoded.charAt(i + 1), 16));
                }
                return decoded;
            }
        };

        public static Format valueOfJsonValue(final String jsonValue) {
            requireNonNull(jsonValue, "jsonValue is null");
            return valueOf(jsonValue.toUpperCase());
        }

        public String getJsonValue() {
            return name().toLowerCase();
        }

        public abstract byte[] decode(String dataEntry);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AssertTrue
    private boolean isSizeDivisibleBy8() {
        return size % Byte.SIZE == 0;
    }

    // --------------------------------------------------------------------------------------------------------------- n
    // ------------------------------------------------------------------------------------------------------------ size
    @com.owlike.genson.annotation.JsonIgnore
    @jakarta.json.bind.annotation.JsonbTransient
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
    @jakarta.json.bind.annotation.JsonbTransient
    @Transient
    public Format getFormatAsOneOfPredefined() {
        return ofNullable(getFormat()).map(String::toUpperCase).map(Format::valueOf).orElse(null);
    }

    public void setFormatAsOneOfPredefined(final Format formatAsEnum) {
        setFormat(ofNullable(formatAsEnum).map(Enum::name).map(String::toLowerCase).orElse(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_N)
    @Min(MIN_N)
    private int n = MIN_N;

    @Max(GenerateBlobsParams.MAX_SIZE)
    @Min(GenerateBlobsParams.MIN_SIZE)
    private int size = Byte.SIZE;

    @Pattern(regexp = PATTERN_REGEXP_FORMAT)
    private String format = Format.BASE64.getJsonValue();
}
