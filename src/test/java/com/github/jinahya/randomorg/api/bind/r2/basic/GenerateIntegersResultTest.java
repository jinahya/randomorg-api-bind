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
import com.github.jinahya.randomorg.api.bind.r2.Base;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Arrays.asList;
import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateIntegersResultTest
        extends AbstractResultTest<GenerateIntegersResult, GenerateIntegersResult.Random, Object> {

    GenerateIntegersResultTest() {
        super(GenerateIntegersResult.class, GenerateIntegersResult.Random.class, Object.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_result_01(final GenerateIntegersResult result) {
        requireNonNull(result, "result is null");
        log.debug("result: {}", result);
        requireValid(result);
        assertThat(result.getRandom())
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getDataAsIntegers(Base.DECIMAL))
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

    @Test
    void r_generateIntegers_result_01() throws IOException {
        read(getClass(), "generateIntegers_result_01.json", GenerateIntegersResult.class,
             GenerateIntegersResultTest::a_generateIntegers_result_01);
    }

    @Test
    void w_generateIntegers_result_01() {
        final GenerateIntegersResult result = new GenerateIntegersResult();
        result.setRandom(new GenerateIntegersResult.Random());
        result.getRandom().setData(asList(1, 5, 4, 6, 6, 4));
        result.getRandom().setCompletionTime("2011-10-10 13:19:12Z");
        result.setBitsUsed(16);
        result.setBitsLeft(199984);
        result.setRequestsLeft(9999);
        result.setAdvisoryDelay(0);
        a_generateIntegers_result_01(result);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_result_02(final GenerateIntegersResult result) {
        requireNonNull(result, "result is null");
        log.debug("result: {}", result);
        requireValid(result);
        assertThat(result.getRandom())
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getDataAsIntegers(Base.DECIMAL))
                            .isNotNull()
                            .containsExactlyElementsOf(asList(
                                    39, 24, 18, 46, 6, 52, 36, 30, 40, 42, 37, 4, 7, 20, 1, 44, 25, 9, 21, 29, 51, 41,
                                    14, 15, 48, 50, 31, 17, 3, 19, 45, 35, 2, 43, 26, 16, 5, 23, 12, 8, 10, 47, 13, 33,
                                    34, 49, 22, 11, 28, 27, 38, 32));
                    assertThat(r.getCompletionTime())
                            .isNotNull();
                    assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, r);
                });
        assertEquals(296, result.getBitsUsed());
        assertEquals(199704, result.getBitsLeft());
        assertEquals(9999, result.getRequestsLeft());
        assertEquals(2000, result.getAdvisoryDelay());
        assertThat(result.getAdvisoryDelayAsTemporalAmount()).isNotNull();
    }

    @Test
    void r_generateIntegers_result_02() throws IOException {
        read(getClass(), "generateIntegers_result_02.json", GenerateIntegersResult.class,
             GenerateIntegersResultTest::a_generateIntegers_result_02);
    }

    @Test
    void w_generateIntegers_result_02() {
        final GenerateIntegersResult result = new GenerateIntegersResult();
        result.setRandom(new GenerateIntegersResult.Random());
        result.getRandom().setData(asList(
                39, 24, 18, 46, 6, 52, 36, 30, 40, 42, 37, 4, 7, 20, 1, 44, 25, 9, 21, 29, 51, 41, 14, 15, 48, 50, 31,
                17, 3, 19, 45, 35, 2, 43, 26, 16, 5, 23, 12, 8, 10, 47, 13, 33, 34, 49, 22, 11, 28, 27, 38, 32));
        result.getRandom().setCompletionTime("2011-10-10 13:19:12Z");
        result.setBitsUsed(296);
        result.setBitsLeft(199704);
        result.setRequestsLeft(9999);
        result.setAdvisoryDelay(2000);
        a_generateIntegers_result_02(result);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_result_03(final GenerateIntegersResult result) {
        requireNonNull(result, "result is null");
        log.debug("result: {}", result);
        requireValid(result);
        assertThat(result.getRandom())
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getDataAsIntegers(Base.HEXADECIMAL))
                            .isNotNull()
                            .containsExactlyElementsOf(asList(
                                    0x90, 0xA6, 0x3E, 0xF7, 0x06));
                    assertThat(r.getCompletionTime())
                            .isNotNull();
                    assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, r);
                });
        assertEquals(4096, result.getBitsUsed());
        assertEquals(195904, result.getBitsLeft());
        assertEquals(9999, result.getRequestsLeft());
        assertEquals(0, result.getAdvisoryDelay());
        assertThat(result.getAdvisoryDelayAsTemporalAmount()).isNotNull();
    }

    @Test
    void r_generateIntegers_result_03() throws IOException {
        read(getClass(), "generateIntegers_result_03.json", GenerateIntegersResult.class,
             GenerateIntegersResultTest::a_generateIntegers_result_03);
    }

    @Test
    void w_generateIntegers_result_03() {
        final GenerateIntegersResult result = new GenerateIntegersResult();
        result.setRandom(new GenerateIntegersResult.Random());
        result.getRandom().setData(asList("90", "a6", "3e", "f7", "06"));
        result.getRandom().setCompletionTime("2011-10-10 13:19:12Z");
        result.setBitsUsed(4096);
        result.setBitsLeft(195904);
        result.setRequestsLeft(9999);
        result.setAdvisoryDelay(0);
        a_generateIntegers_result_03(result);
    }
}
