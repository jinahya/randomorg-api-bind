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

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateGaussiansParams.MAX_SIGNIFICANT_DIGITS;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateGaussiansParams.MIN_MEAN;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateGaussiansParams.MIN_SIGNIFICANT_DIGITS;

@Setter
@Getter
public class GenerateGaussiansParamsUnit {

    // ------------------------------------------------------------------------------------------------------------ mean
    // ----------------------------------------------------------------------------------------------- standardDeviation
    // ----------------------------------------------------------------------------------------------- significantDigits

    // -----------------------------------------------------------------------------------------------------------------
    @Digits(integer = 7, fraction = 1)
    @DecimalMax(value = "+1000000.0", inclusive = true)
    @DecimalMin(value = "-1000000.0", inclusive = true)
    @NotNull
    private BigDecimal mean = MIN_MEAN;

    @Digits(integer = 7, fraction = 1)
    @DecimalMax(value = "+1000000.0", inclusive = true)
    @DecimalMin(value = "-1000000.0", inclusive = true)
    private BigDecimal standardDeviation;

    @Max(MAX_SIGNIFICANT_DIGITS)
    @Min(MIN_SIGNIFICANT_DIGITS)
    private int significantDigits;
}
