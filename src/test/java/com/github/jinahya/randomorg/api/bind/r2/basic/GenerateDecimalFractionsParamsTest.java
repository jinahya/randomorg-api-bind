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

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class GenerateDecimalFractionsParamsTest {

    @Test
    void read_generateDecimalFractions_params_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateDecimalFractions_params_01.json")) {
            final GenerateDecimalFractionsParams params
                    = new ObjectMapper().readValue(resource, GenerateDecimalFractionsParams.class);
            log.debug("params: {}", params);
            requireValid(params);
            assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
            assertEquals(10, params.getN());
            assertEquals(8, params.getDecimalPlaces());
            assertTrue(params.getReplacement());
        }
    }
}
