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

import com.github.jinahya.randomorg.api.bind.AbstractResultTest;

import java.util.List;

class GenerateIntegerSequenceResultTest
        extends AbstractResultTest<GenerateIntegerSequencesResult, GenerateIntegerSequencesResult.Random, List<Object>> {

    @SuppressWarnings({"unchecked"})
    GenerateIntegerSequenceResultTest() {
        super(GenerateIntegerSequencesResult.class, GenerateIntegerSequencesResult.Random.class,
              (Class<List<Object>>) (Class<?>) List.class);
    }
}
