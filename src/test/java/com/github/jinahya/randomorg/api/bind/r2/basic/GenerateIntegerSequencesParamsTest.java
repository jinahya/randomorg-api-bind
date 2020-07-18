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

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Slf4j
class GenerateIntegerSequencesParamsTest {

    @Test
    void read_generateIntegers_params_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateIntegerSequences_params_01.json")) {
            final GenerateIntegerSequencesParams params
                    = new ObjectMapper().readValue(resource, GenerateIntegerSequencesParams.class);
            log.debug("params: {}", params);
            requireValid(params);
            assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
            assertEquals(2, params.getN());
            assertIterableEquals(asList(5, 1), (List<?>) params.getLength());
            assertIterableEquals(asList(1, 1), (List<?>) params.getMin());
            assertIterableEquals(asList(69, 26), (List<?>) params.getMax());
            assertIterableEquals(asList(false, false), (List<?>) params.getReplacement());
            assertIterableEquals(asList(10, 10), (List<?>) params.getBase());
        }
    }
}
