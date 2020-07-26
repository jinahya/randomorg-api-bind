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
import com.github.jinahya.randomorg.api.bind.r2.Base;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import static java.util.Optional.ofNullable;

@Setter
@Getter
public class GenerateIntegersParams extends AbstractParams {

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_N = 1;

    public static final int MAX_N = 10000; //(int) 1.0e4;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_MIN = -1000000000; //(int) -1.0e+9;

    public static final int MAX_MIN = +1000000000; // (int) +1.0e+9;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_MAX = MIN_MIN;

    public static final int MAX_MAX = MAX_MIN;

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_BASE = "base";

    public static final int MIN_BASE = 2;

    public static final int MAX_BASE = 16;

    // -----------------------------------------------------------------------------------------------------------------
    @AssertTrue
    private boolean isMinLessThanOrEqualsToMax() {
        return min <= max;
    }

    // --------------------------------------------------------------------------------------------------------------- n
    // ------------------------------------------------------------------------------------------------------------- min
    // ------------------------------------------------------------------------------------------------------------- max
    // ----------------------------------------------------------------------------------------------------- replacement
    // ------------------------------------------------------------------------------------------------------------ base
    public Integer getBase() {
        return ofNullable(base).map(Base::getRadix).orElse(null);
    }

    public void setBase(final Integer base) {
        this.base = ofNullable(base).map(Base::valueOfRadix).orElse(null);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_N)
    @Min(MIN_N)
    private int n = MIN_N;

    @Max(MAX_MIN)
    @Min(MIN_MIN)
    private int min = MIN_MIN;

    @Max(MAX_MAX)
    @Min(MIN_MAX)
    private int max = MAX_MAX;

    // -----------------------------------------------------------------------------------------------------------------
    private Boolean replacement;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Base base;
}
