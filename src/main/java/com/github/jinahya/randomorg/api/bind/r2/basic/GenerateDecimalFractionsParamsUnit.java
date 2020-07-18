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

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateDecimalFractionsParams.MAX_DECIMAL_PLACES;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateDecimalFractionsParams.MIN_DECIMAL_PLACES;

@Setter
@Getter
public class GenerateDecimalFractionsParamsUnit {

    // --------------------------------------------------------------------------------------------------- decimalPlaces
    // ----------------------------------------------------------------------------------------------------- replacement

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_DECIMAL_PLACES)
    @Min(MIN_DECIMAL_PLACES)
    private int decimalPlaces = MIN_DECIMAL_PLACES;

    private Boolean replacement;
}
