package com.github.jinahya.randomorg.api.bind.r2;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.beans.Transient;
import java.time.Duration;
import java.time.temporal.TemporalAmount;

@Setter
@Getter
public abstract class AbstractResult<T> {

    public static final String PROPERTY_NAME_RANDOM = "random";

    public static final String PROPERTY_NAME_BITS_USED = "bitsUsed";

    public static final String PROPERTY_NAME_BITS_LEFT = "bitsLeft";

    public static final String PROPERTY_NAME_REQUESTS_LEFT = "requestsLeft";

    public static final String PROPERTY_NAME_ADVISORY_DELAY = "advisoryDelay";

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + '{'
               + PROPERTY_NAME_RANDOM + '=' + random
               + ',' + PROPERTY_NAME_BITS_USED + '=' + bitsUsed
               + ',' + PROPERTY_NAME_BITS_LEFT + '=' + bitsLeft
               + ',' + PROPERTY_NAME_REQUESTS_LEFT + '=' + requestsLeft
               + ',' + PROPERTY_NAME_ADVISORY_DELAY + '=' + advisoryDelay
               + '}';
    }

    // --------------------------------------------------------------------------------------------------- advisoryDelay
    @com.fasterxml.jackson.annotation.JsonIgnore
    @jakarta.json.bind.annotation.JsonbTransient
    @Transient
    public TemporalAmount getAdvisoryDelayAsTemporalAmount() {
        return Duration.ofMillis(getAdvisoryDelay());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    private T random;

    @Positive
    private int bitsUsed;

    @PositiveOrZero
    private long bitsLeft;

    @PositiveOrZero
    private int requestsLeft;

    @PositiveOrZero
    private long advisoryDelay;
}
