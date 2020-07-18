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
import com.github.jinahya.randomorg.api.bind.AbstractParamsTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateUUIDsParamsTest extends AbstractParamsTest<GenerateUUIDsParams> {

    GenerateUUIDsParamsTest() {
        super(GenerateUUIDsParams.class);
    }

    @Test
    void read_generateUUIDs_params_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateUUIDs_params_01.json")) {
            final GenerateUUIDsParams params
                    = new ObjectMapper().readValue(resource, GenerateUUIDsParams.class);
            log.debug("params: {}", params);
            requireValid(params);
            assertEquals("00000000-0000-0000-0000-000000000000", params.getApiKey());
            assertEquals(1, params.getN());
        }
    }
}
