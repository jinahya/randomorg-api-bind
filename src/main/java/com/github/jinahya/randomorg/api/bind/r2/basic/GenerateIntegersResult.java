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

import com.github.jinahya.randomorg.api.bind.r2.AbstractResult;
import com.github.jinahya.randomorg.api.bind.r2.AbstractResultRandom;
import com.github.jinahya.randomorg.api.bind.r2.Base;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class GenerateIntegersResult extends AbstractResult<GenerateIntegersResult.Random> {

    public static class Random extends AbstractResultRandom<Object> {

        @Override
        public String toString() {
            return super.toString() + '{'
                   + '}';
        }

        public List<Integer> getDataAsIntegers(final Base base) {
            requireNonNull(base, "base is null");
            return ofNullable(getData())
                    .map(l -> l.stream().map(base::parse).collect(toList()))
                    .orElse(null);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + '{'
               + '}';
    }
}
