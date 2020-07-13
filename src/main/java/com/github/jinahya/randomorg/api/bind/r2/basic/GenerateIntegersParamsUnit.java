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

import static java.util.Optional.ofNullable;

public class GenerateIntegersParamsUnit {

    public static final int MIN_MIN = (int) -1.0e+9;

    public static final int MAX_MIN = (int) +1.0e+9;

    public static final int MIN_MAX = MIN_MIN;

    public static final int MAX_MAX = MAX_MIN;

    // -----------------------------------------------------------------------------------------------------------------
    @AssertTrue
    private boolean isMinLessThanOrEqualsToMax() {
        return min <= max;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int getMin() {
        return min;
    }

    public void setMin(final int min) {
        this.min = min;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }

    public Boolean getReplacement() {
        return replacement;
    }

    public void setReplacement(final Boolean replacement) {
        this.replacement = replacement;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Integer getBase() {
        return ofNullable(base).map(Base::getRadix).orElse(null);
    }

    public void setBase(final Integer base) {
        this.base = ofNullable(base).map(Base::valueOfRadix).orElse(null);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_MIN)
    @Min(MIN_MIN)
    private int min = MIN_MIN;

    @Max(MAX_MAX)
    @Min(MIN_MAX)
    private int max = MAX_MAX;

    private Boolean replacement;

    private Base base;
}
