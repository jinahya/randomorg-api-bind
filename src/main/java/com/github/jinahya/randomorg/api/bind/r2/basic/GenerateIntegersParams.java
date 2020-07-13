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

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GenerateIntegersParams {

    public static final int MIN_N = 1;

    public static final int MAX_N = (int) 1.0e4;

    // ---------------------------------------------------------------------------------------------------------- apiKey
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    // --------------------------------------------------------------------------------------------------------------- n
    public int getN() {
        return n;
    }

    public void setN(final int n) {
        this.n = n;
    }

    // ------------------------------------------------------------------------------------------------------------- min
    public int getMin() {
        return unit.getMin();
    }

    public void setMin(final int min) {
        unit().setMin(min);
    }

    // ------------------------------------------------------------------------------------------------------------- max
    public int getMax() {
        return unit.getMax();
    }

    public void setMax(final int max) {
        unit().setMax(max);
    }

    // ----------------------------------------------------------------------------------------------------- replacement
    public Boolean getReplacement() {
        return unit().getReplacement();
    }

    public void setReplacement(final Boolean replacement) {
        unit().setReplacement(replacement);
    }

    // ------------------------------------------------------------------------------------------------------------ base
    public Integer getBase() {
        return unit().getBase();
    }

    public void setBase(final Integer base) {
        unit().setBase(base);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private GenerateIntegersParamsUnit unit() {
        if (unit == null) {
            unit = new GenerateIntegersParamsUnit();
        }
        return unit;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String apiKey;

    @Max(MAX_N)
    @Min(MIN_N)
    private int n = MIN_N;

    @Valid
    @NotNull
    private GenerateIntegersParamsUnit unit;
}
