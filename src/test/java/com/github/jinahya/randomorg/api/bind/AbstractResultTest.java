package com.github.jinahya.randomorg.api.bind;

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

import com.github.jinahya.randomorg.api.bind.r2.AbstractResult;
import com.github.jinahya.randomorg.api.bind.r2.AbstractResultRandom;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractResultTest<T extends AbstractResult<U>, U extends AbstractResultRandom<V>, V>
        extends AbstractTest {

    // -----------------------------------------------------------------------------------------------------------------
    protected static void assertCompletionTimeEquals(final OffsetDateTime expected,
                                                     final AbstractResultRandom<?> random) {
        final OffsetDateTime actual = random.getCompletionTimeAsOffsetDateTime();
        assertEquals(expected, actual);
    }

    protected static void assertCompletionTimeEquals(
            final int year, final int month, final int dayOfMonth, final int hour, final int minute, final int second,
            final AbstractResultRandom<?> random) {
        assertCompletionTimeEquals(
                LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atOffset(ZoneOffset.UTC), random);
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected AbstractResultTest(final Class<T> resultClass, final Class<U> randomClass, final Class<V> elementClass) {
        super();
        this.resultClass = requireNonNull(resultClass, "resultClass is null");
        this.randomClass = requireNonNull(randomClass, "randomClass is null");
        this.elementClass = requireNonNull(elementClass, "elementClass is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    protected final Class<T> resultClass;

    protected final Class<U> randomClass;

    protected final Class<V> elementClass;
}
