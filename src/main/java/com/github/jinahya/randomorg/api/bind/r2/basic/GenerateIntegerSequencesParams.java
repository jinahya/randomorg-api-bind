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
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class GenerateIntegerSequencesParams {

    public static final int MIN_N = GenerateIntegersParams.MIN_N;

    public static final int MAX_N = 1000;

    // ---------------------------------------------------------------------------------------------------------- apiKey
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(final String apiKey) {
        this.apiKey = apiKey;
    }

    // --------------------------------------------------------------------------------------------------------------- n
    public int getN() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return n;
        }
        return units.size();
    }

    public void setN(final int n) {
        this.n = n;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public Object getLength() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return units.get(0).getLength();
        }
        return units.stream().map(GenerateIntegerSequencesParamsUnit::getLength).collect(toList());
    }

    public Object getMin() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return units.get(0).getMin();
        }
        return units.stream().map(GenerateIntegerSequencesParamsUnit::getMin).collect(toList());
    }

    public Object getMax() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return units.get(0).getMax();
        }
        return units.stream().map(GenerateIntegerSequencesParamsUnit::getMax).collect(toList());
    }

    public Object getReplacement() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return units.get(0).getReplacement();
        }
        return units.stream().map(GenerateIntegerSequencesParamsUnit::getReplacement).collect(toList());
    }

    public Object getBase() {
        if (units == null || units.isEmpty()) {
            throw new IllegalStateException("units are empty");
        }
        if (units.size() == 1) {
            return units.get(0).getBase();
        }
        return units.stream().map(GenerateIntegerSequencesParamsUnit::getBase).collect(toList());
    }

    // ----------------------------------------------------------------------------------------------------------- units
    public GenerateIntegerSequencesParams unit(final GenerateIntegerSequencesParamsUnit unit) {
        requireNonNull(unit, "unit is null");
        units().add(unit);
        return this;
    }

    private List<GenerateIntegerSequencesParamsUnit> units() {
        if (units == null) {
            units = new ArrayList<>();
        }
        return units;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotBlank
    private String apiKey;

    @Max(MAX_N)
    @Min(MIN_N)
    private int n = MIN_N;

    @Size(min = MIN_N, max = MAX_N)
    private List<@Valid @NotNull GenerateIntegerSequencesParamsUnit> units;
}
