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

public enum Base {

    BINARY(2),

    OCTAL(8),

    DECIMAL(10) {
        @Override
        public int parse(final Object e) {
            return ((Number) e).intValue();
        }
    },

    HEXADECIMAL(16);

    // -----------------------------------------------------------------------------------------------------------------
    public static Base valueOfRadix(final int radix) {
        for (final Base value : values()) {
            if (value.radix == radix) {
                return value;
            }
        }
        throw new IllegalArgumentException("no value for radix: " + radix);
    }

    // -----------------------------------------------------------------------------------------------------------------
    Base(final int radix) {
        this.radix = radix;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int parse(final Object e) {
        return Integer.parseInt((String) e, radix);
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value of {@code radix} property of this constant.
     *
     * @return the value of {@code radix} property.
     */
    public int getRadix() {
        return radix;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final int radix;
}
