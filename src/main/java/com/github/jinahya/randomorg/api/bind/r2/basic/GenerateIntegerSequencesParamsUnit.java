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

import com.github.jinahya.randomorg.api.bind.r2.Base;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.beans.Transient;

import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MAX_BASE;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MAX_LENGTH;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MAX_MAX;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MAX_MIN;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MIN_BASE;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MIN_LENGTH;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MIN_MAX;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateIntegerSequencesParams.MIN_MIN;
import static java.util.Optional.ofNullable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenerateIntegerSequencesParamsUnit {

    @Override
    public String toString() {
        return super.toString() + '{'
               + "length=" + length
               + ",min=" + min
               + ",max=" + max
               + ",replacement=" + replacement
               + ",base=" + base
               + '}';
    }

    // -----------------------------------------------------------------------------------------------------------------
    @AssertTrue
    private boolean isMinLessThanOrEqualsToMax() {
        return min <= max;
    }

    @AssertTrue
    private boolean isBaseOneOfPredefined() {
        if (base == null) {
            return true;
        }
        try {
            Base.valueOfRadix(base);
            return true;
        } catch (final IllegalArgumentException iae) {
            // suppressed
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------------------------- n
    // ------------------------------------------------------------------------------------------------------------- min
    // ------------------------------------------------------------------------------------------------------------- max
    // ----------------------------------------------------------------------------------------------------- replacement
    // ------------------------------------------------------------------------------------------------------------ base
    @com.fasterxml.jackson.annotation.JsonIgnore
    @jakarta.json.bind.annotation.JsonbTransient
    @Transient
    public Base getBaseAsOneOfPredefined() {
        return ofNullable(getBase()).map(Base::valueOfRadix).orElse(null);
    }

    public void setBaseAsOneOfPredefined(final Base baseAsOneOfPredefined) {
        setBase(ofNullable(baseAsOneOfPredefined).map(Base::getRadix).orElse(null));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_LENGTH)
    @Min(MIN_LENGTH)
    private int length;

    @Max(MAX_MIN)
    @Min(MIN_MIN)
    private int min;

    @Max(MAX_MAX)
    @Min(MIN_MAX)
    private int max;

    // -----------------------------------------------------------------------------------------------------------------
    private Boolean replacement;

    @Max(MAX_BASE)
    @Min(MIN_BASE)
    private Integer base;
}
