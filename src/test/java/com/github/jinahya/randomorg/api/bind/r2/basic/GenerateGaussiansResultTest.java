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
import java.math.BigDecimal;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateGaussiansResultTest
        extends AbstractResultTest<GenerateGaussiansResult, GenerateGaussiansResult.Random, BigDecimal> {

    GenerateGaussiansResultTest() {
        super(GenerateGaussiansResult.class, GenerateGaussiansResult.Random.class, BigDecimal.class);
    }

    @Test
    void read_generateGaussians_result_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateGaussians_result_01.json")) {
            final GenerateGaussiansResult result
                    = new ObjectMapper().readValue(resource, GenerateGaussiansResult.class);
            log.debug("result: {}", result);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .containsExactly(BigDecimal.valueOf(0.4025041),
                                                 BigDecimal.valueOf(-1.4918831),
                                                 BigDecimal.valueOf(0.64733849),
                                                 BigDecimal.valueOf(0.5222242)
                                );
                    })
            ;
            assertCompletionTimeEquals(2013, 1, 25, 19, 16, 42, result.getRandom());
            assertEquals(106, result.getBitsUsed());
            assertEquals(199894, result.getBitsLeft());
            assertEquals(5442, result.getRequestsLeft());
            assertEquals(0, result.getAdvisoryDelay());
        }
    }
}