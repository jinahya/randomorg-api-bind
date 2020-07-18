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
import com.github.jinahya.randomorg.api.bind.AbstractResultTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateUUIDsResultTest
        extends AbstractResultTest<GenerateUUIDsResult, GenerateUUIDsResult.Random, String> {

    GenerateUUIDsResultTest() {
        super(GenerateUUIDsResult.class, GenerateUUIDsResult.Random.class, String.class);
    }

    @Test
    void read_generateUUIDs_result_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateUUIDs_result_01.json")) {
            final GenerateUUIDsResult result
                    = new ObjectMapper().readValue(resource, GenerateUUIDsResult.class);
            log.debug("result: {}", result);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .containsExactly("47849fd4-b790-492e-8b93-c601a91b662d");
                        assertThat(r.getDataAsUuids())
                                .isNotNull()
                                .containsExactly(UUID.fromString("47849fd4-b790-492e-8b93-c601a91b662d"));
                    })
            ;
            assertCompletionTimeEquals(2013, 2, 11, 16, 42, 7, result.getRandom());
            assertEquals(122, result.getBitsUsed());
            assertEquals(998532, result.getBitsLeft());
            assertEquals(199996, result.getRequestsLeft());
            assertEquals(1000, result.getAdvisoryDelay());
        }
    }
}
