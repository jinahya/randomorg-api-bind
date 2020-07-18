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
class GenerateDecimalFractionsResultTest
        extends AbstractResultTest<GenerateDecimalFractionsResult, GenerateDecimalFractionsResult.Random, BigDecimal> {

    GenerateDecimalFractionsResultTest() {
        super(GenerateDecimalFractionsResult.class, GenerateDecimalFractionsResult.Random.class, BigDecimal.class);
    }

    @Test
    void read_generateDecimalFractions_result_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateDecimalFractions_result_01.json")) {
            final GenerateDecimalFractionsResult result
                    = new ObjectMapper().readValue(resource, GenerateDecimalFractionsResult.class);
            log.debug("result: {}", result);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .containsExactly(BigDecimal.valueOf(0.0753205),
                                                 BigDecimal.valueOf(0.59823072),
                                                 BigDecimal.valueOf(0.46109946),
                                                 BigDecimal.valueOf(0.28453638),
                                                 BigDecimal.valueOf(0.92390558),
                                                 BigDecimal.valueOf(0.53087566),
                                                 BigDecimal.valueOf(0.48139983),
                                                 BigDecimal.valueOf(0.06829921),
                                                 BigDecimal.valueOf(0.1878),
                                                 BigDecimal.valueOf(0.10107864)
                                );
                    })
            ;
            assertCompletionTimeEquals(2013, 1, 25, 19, 16, 42, result.getRandom());
            assertEquals(266, result.getBitsUsed());
            assertEquals(199734, result.getBitsLeft());
            assertEquals(8463, result.getRequestsLeft());
            assertEquals(0, result.getAdvisoryDelay());
        }
    }
}
