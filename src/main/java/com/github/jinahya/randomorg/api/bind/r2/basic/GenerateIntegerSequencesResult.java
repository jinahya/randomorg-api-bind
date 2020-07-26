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
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public class GenerateIntegerSequencesResult extends AbstractResult<GenerateIntegerSequencesResult.Random> {

    public static class Random extends AbstractResultRandom<List<Object>> {

//        public List<List<Integer>> getDataAsIntegerSequences(final Base base) {
//            return ofNullable(getData())
//            if (data == null) {
//                return null;
//            }
//            return IntStream.range(0, data.size())
//                    .mapToObj(i -> {
//                        final List<Object> l = data.get(i);
//                        final Base b = ofNullable(radixFunction.apply(i)).map(Base::valueOfRadix).orElse(null);
//                        return l.stream().map(e -> b == null ? (Integer) e : b.parse((String) e)).collect(toList());
//                    })
//                    .collect(toList());
//        }
    }
}
