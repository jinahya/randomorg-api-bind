package com.github.jinahya.randomorg.api.bind.r2.basic;

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

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class GenerateIntegerSequencesParamsUnit extends GenerateIntegersParamsUnit {

    public static final int MIN_LENGTH = 1;

    public static final int MAX_LENGTH = 10000;

    // -----------------------------------------------------------------------------------------------------------------
    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_LENGTH)
    @Min(MIN_LENGTH)
    private int length;
}
