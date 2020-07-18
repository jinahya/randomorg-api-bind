package com.github.jinahya.randomorg.api.bind.r2;

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

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

@Setter
@Getter
public abstract class AbstractResultRandom<T> {

    private static final DateTimeFormatter COMPLETION_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX");

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + "{"
               + "data=" + data
               + ",completionTime=" + completionTime
               + "}";
    }

    // -------------------------------------------------------------------------------------------------- completionTime
    public TemporalAccessor getCompletionTimeAsTemporalAccessorParsedWith(final DateTimeFormatter formatter) {
        requireNonNull(formatter, "formatter is null");
        return ofNullable(getCompletionTime()).map(formatter::parse).orElse(null);
    }

    public TemporalAccessor getCompletionTimeAsTemporalAccessor() {
        return getCompletionTimeAsTemporalAccessorParsedWith(COMPLETION_TIME_FORMATTER);
    }

    // -------------------------------------------------------------------------------------------------------------
    @NotEmpty
    private List<T> data;

    @NotBlank
    private String completionTime;
}
