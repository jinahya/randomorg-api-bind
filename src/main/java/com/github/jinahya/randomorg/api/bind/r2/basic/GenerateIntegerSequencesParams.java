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
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

@Setter
@Getter
public class GenerateIntegerSequencesParams extends AbstractParams {

    // -----------------------------------------------------------------------------------------------------------------
    public static final String PROPERTY_NAME_N = "n";

    public static final int MIN_N = GenerateIntegersParams.MIN_N;

    public static final int MAX_N = 1000;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_LENGTH = 1;

    public static final int MAX_LENGTH = 10000;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_MIN = GenerateIntegersParams.MIN_MIN;

    public static final int MAX_MIN = GenerateIntegersParams.MAX_MIN;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_MAX = MIN_MIN;

    public static final int MAX_MAX = MAX_MIN;

    // -----------------------------------------------------------------------------------------------------------------
    public static final int MIN_BASE = GenerateIntegersParams.MIN_BASE;

    public static final int MAX_BASE = GenerateIntegersParams.MAX_BASE;

    // -----------------------------------------------------------------------------------------------------------------
    public static GenerateIntegerSequencesParams newUniformInstance(
            final int n, final GenerateIntegerSequencesParamsUnit unit) {
        requireNonNull(unit, "unit is null");
        final GenerateIntegerSequencesParams instance = new GenerateIntegerSequencesParams();
        instance.setN(n);
        instance.unit(unit);
        return instance;
    }

    public static GenerateIntegerSequencesParams newMultiformInstance(
            final GenerateIntegerSequencesParamsUnit firstUnit, final GenerateIntegerSequencesParamsUnit secondUnit,
            final GenerateIntegerSequencesParamsUnit... otherUnits) {
        requireNonNull(firstUnit, "firstUnit is null");
        final GenerateIntegerSequencesParams instance = newUniformInstance(1, firstUnit);
        if (secondUnit != null) {
            instance.unit(secondUnit);
            if (otherUnits != null) {
                for (final GenerateIntegerSequencesParamsUnit otherUnit : otherUnits) {
                    instance.unit(otherUnit);
                }
            }
        }
        return instance;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + '{'
               + "n=" + getN()
               + ",units=" + units
               + '}';
    }

    // --------------------------------------------------------------------------------------------------------------- n
    @Positive
    public int getN() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return n;
        }
        return units().size();
    }

    public void setN(final int n) {
        this.n = n;
    }

    // ---------------------------------------------------------------------------------------------------------- length
    @NotNull
    public Object getLength() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return units().get(0).getLength();
        }
        return units().stream().map(GenerateIntegerSequencesParamsUnit::getLength).collect(toList());
    }

    @SuppressWarnings({"unchecked"})
    public void setLength(final Object length) {
        if (length instanceof Number) {
            unit(0);
            units().forEach(u -> u.setLength(((Number) length).intValue()));
            return;
        }
        if (length instanceof Iterable) {
            int index = 0;
            for (final Number l : (Iterable<? extends Number>) length) {
                unit(index++).setLength(l.intValue());
            }
            assert index == units().size();
            return;
        }
        throw new IllegalArgumentException("illegal length: " + length);
    }

    // ------------------------------------------------------------------------------------------------------------- min
    @NotNull
    public Object getMin() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return units().get(0).getMin();
        }
        return units().stream().map(GenerateIntegerSequencesParamsUnit::getMin).collect(toList());
    }

    @SuppressWarnings({"unchecked"})
    public void setMin(final Object min) {
        if (min instanceof Number) {
            unit(0);
            units().forEach(u -> u.setMin(((Number) min).intValue()));
            return;
        }
        if (min instanceof Iterable) {
            int index = 0;
            for (final Number e : (Iterable<? extends Number>) min) {
                unit(index++).setMin(e.intValue());
            }
            assert index == units().size();
            return;
        }
        throw new IllegalArgumentException("illegal min: " + min);
    }

    // ------------------------------------------------------------------------------------------------------------- max
    @NotNull
    public Object getMax() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return units().get(0).getMax();
        }
        return units().stream().map(GenerateIntegerSequencesParamsUnit::getMax).collect(toList());
    }

    @SuppressWarnings({"unchecked"})
    public void setMax(final Object max) {
        if (max instanceof Number) {
            unit(0);
            units().forEach(u -> u.setMax(((Number) max).intValue()));
            return;
        }
        if (max instanceof Iterable) {
            int index = 0;
            for (final Number e : (Iterable<? extends Number>) max) {
                unit(index++).setMax(e.intValue());
            }
            assert index == units().size();
            return;
        }
        throw new IllegalArgumentException("illegal max: " + max);
    }

    // ----------------------------------------------------------------------------------------------------- replacement
    public Object getReplacement() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return units().get(0).getReplacement();
        }
        return units().stream().map(GenerateIntegerSequencesParamsUnit::getReplacement).collect(toList());
    }

    @SuppressWarnings({"unchecked"})
    public void setReplacement(final Object replacement) {
        if (replacement instanceof Boolean) {
            unit(0);
            units().forEach(u -> u.setReplacement((Boolean) replacement));
            return;
        }
        if (replacement instanceof Iterable) {
            int index = 0;
            for (final Boolean e : (Iterable<Boolean>) replacement) {
                unit(index++).setReplacement(e);
            }
            assert index == units().size();
            return;
        }
        throw new IllegalArgumentException("illegal replacement: " + replacement);
    }

    // ------------------------------------------------------------------------------------------------------------ base
    public Object getBase() {
        if (units().isEmpty()) {
            throw new IllegalStateException("empty units");
        }
        if (units().size() == 1) {
            return units().get(0).getBase();
        }
        return units().stream().map(GenerateIntegerSequencesParamsUnit::getBase).collect(toList());
    }

    @SuppressWarnings({"unchecked"})
    public void setBase(final Object base) {
        if (base instanceof Number) {
            unit(0);
            units().forEach(u -> u.setBase(((Number) base).intValue()));
            return;
        }
        if (base instanceof Iterable) {
            int index = 0;
            for (final Number e : (Iterable<? extends Number>) base) {
                unit(index++).setBase(e.intValue());
            }
            assert index == units().size();
            return;
        }
        throw new IllegalArgumentException("illegal base: " + base);
    }

    // ----------------------------------------------------------------------------------------------------------- units
    private GenerateIntegerSequencesParamsUnit unit(final int index) {
        while (units().size() <= index) {
            unit(new GenerateIntegerSequencesParamsUnit());
        }
        return units().get(index);
    }

    private GenerateIntegerSequencesParams unit(final GenerateIntegerSequencesParamsUnit unit) {
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
    @Max(MAX_N)
    @Min(MIN_N)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private int n = MIN_N;

    @Size(min = MIN_N, max = MAX_N)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private transient List<@Valid @NotNull GenerateIntegerSequencesParamsUnit> units;
}
