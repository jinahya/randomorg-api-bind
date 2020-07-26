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

import com.github.jinahya.randomorg.api.bind.AbstractParamsTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@Slf4j
class GenerateIntegerSequencesParamsTest extends AbstractParamsTest<GenerateIntegerSequencesParams> {

    GenerateIntegerSequencesParamsTest() {
        super(GenerateIntegerSequencesParams.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegerSequences_params_01(final GenerateIntegerSequencesParams params) {
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

    @Test
    void r_generateIntegerSequences_params_01() throws IOException {
        read(getClass(), "generateIntegerSequences_params_01.json", GenerateIntegerSequencesParams.class,
             GenerateIntegerSequencesParamsTest::a_generateIntegerSequences_params_01);
    }

    @Test
    void w_generateIntegerSequences_params_01() {
        {
            final GenerateIntegerSequencesParams params = new GenerateIntegerSequencesParams();
            params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
            params.setN(2);
            params.setLength(asList(5, 1));
            params.setMin(asList(1, 1));
            params.setMax(asList(69, 26));
            params.setReplacement(asList(false, false));
            params.setBase(asList(10, 10));
            a_generateIntegerSequences_params_01(params);
        }
        {
            final GenerateIntegerSequencesParams params = GenerateIntegerSequencesParams.newMultiformInstance(
                    GenerateIntegerSequencesParamsUnit.builder()
                            .length(5)
                            .min(1)
                            .max(69)
                            .replacement(false)
                            .base(10)
                            .build(),
                    GenerateIntegerSequencesParamsUnit.builder()
                            .length(1)
                            .min(1)
                            .max(26)
                            .replacement(false)
                            .base(10)
                            .build()
            );
            params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
            a_generateIntegerSequences_params_01(params);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegerSequences_params_02(final GenerateIntegerSequencesParams params) {
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(8, params.getN());
        assertEquals(52, params.getLength());
        assertEquals(1, params.getMin());
        assertEquals(52, params.getMax());
        assertFalse((Boolean) params.getReplacement());
        assertEquals(10, params.getBase());
    }

    @Test
    void r_generateIntegerSequences_params_02() throws IOException {
        read(getClass(), "generateIntegerSequences_params_02.json", GenerateIntegerSequencesParams.class,
             GenerateIntegerSequencesParamsTest::a_generateIntegerSequences_params_02);
    }

    @Test
    void w_generateIntegerSequences_params_02() {
        {
            final GenerateIntegerSequencesParams params = new GenerateIntegerSequencesParams();
            params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
            params.setN(8);
            params.setLength(singletonList(52));
            params.setMin(singletonList(1));
            params.setMax(singletonList(52));
            params.setReplacement(singletonList(false));
            params.setBase(singletonList(10));
            a_generateIntegerSequences_params_02(params);
        }
        {
            final GenerateIntegerSequencesParams params = GenerateIntegerSequencesParams.newUniformInstance(
                    8,
                    GenerateIntegerSequencesParamsUnit.builder()
                            .length(52)
                            .min(1)
                            .max(52)
                            .replacement(false)
                            .base(10)
                            .build()
            );
            params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
            a_generateIntegerSequences_params_02(params);
        }
    }
}
