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

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateIntegersResultTest
        extends AbstractResultTest<GenerateIntegersResult, GenerateIntegersResult.Random, Integer> {

    GenerateIntegersResultTest() {
        super(GenerateIntegersResult.class, GenerateIntegersResult.Random.class, Integer.class);
    }

    @Test
    void read_generateIntegers_result_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateIntegers_result_01.json")) {
            final GenerateIntegersResult result = new ObjectMapper().readValue(resource, GenerateIntegersResult.class);
            log.debug("result: {}", result);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .hasSameElementsAs(asList(1, 5, 4, 6, 6, 4));
                        assertThat(r.getCompletionTime())
                                .isNotNull();
                        assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, r);
                    });
            assertEquals(16, result.getBitsUsed());
            assertEquals(199984, result.getBitsLeft());
            assertEquals(9999, result.getRequestsLeft());
            assertEquals(0, result.getAdvisoryDelay());
            assertThat(result.getAdvisoryDelayAsTemporalAmount()).isNotNull();
        }
    }
}
