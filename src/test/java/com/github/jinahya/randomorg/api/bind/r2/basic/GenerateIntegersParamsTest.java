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
import com.github.jinahya.randomorg.api.bind.r2.Base;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateIntegersParamsTest extends AbstractParamsTest<GenerateIntegersParams> {

    GenerateIntegersParamsTest() {
        super(GenerateIntegersParams.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_params_01(final GenerateIntegersParams params) {
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(6, params.getN());
        assertEquals(1, params.getMin());
        assertEquals(6, params.getMax());
        assertThat(params.getReplacement()).isNotNull().isTrue();
        assertThat(params.getBase()).isNull();
        write(GenerateIntegersParams.class, params, v -> {
            log.debug("{}", v);
        });
    }

    @Test
    void r_generateIntegers_params_01() throws IOException {
        read(getClass(), "generateIntegers_params_01.json", GenerateIntegersParams.class,
             GenerateIntegersParamsTest::a_generateIntegers_params_01);
    }

    @Test
    void w_generateIntegers_params_01() {
        final GenerateIntegersParams params = new GenerateIntegersParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(6);
        params.setMin(1);
        params.setMax(6);
        params.setReplacement(true);
        a_generateIntegers_params_01(params);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_params_02(final GenerateIntegersParams params) {
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(52, params.getN());
        assertEquals(1, params.getMin());
        assertEquals(52, params.getMax());
        assertEquals(false, params.getReplacement());
        write(GenerateIntegersParams.class, params, v -> {
        });
    }

    @Test
    void r_generateIntegers_params_02() throws IOException {
        read(getClass(), "generateIntegers_params_02.json", GenerateIntegersParams.class,
             GenerateIntegersParamsTest::a_generateIntegers_params_02);
    }

    @Test
    void w_generateIntegers_params_02() {
        final GenerateIntegersParams params = new GenerateIntegersParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(52);
        params.setMin(1);
        params.setMax(52);
        params.setReplacement(false);
        a_generateIntegers_params_02(params);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateIntegers_params_03(final GenerateIntegersParams params) {
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(512, params.getN());
        assertEquals(0, params.getMin());
        assertEquals(255, params.getMax());
        assertThat(params.getReplacement()).isNull();
        assertThat(params.getBase()).isNotNull().isEqualTo(Base.HEXADECIMAL.getRadix());
        write(GenerateIntegersParams.class, params, v -> {
        });
    }

    @Test
    void r_generateIntegers_params_03() throws IOException {
        read(getClass(), "generateIntegers_params_03.json", GenerateIntegersParams.class,
             GenerateIntegersParamsTest::a_generateIntegers_params_03);
    }

    @Test
    void w_generateIntegers_params_03() {
        final GenerateIntegersParams params = new GenerateIntegersParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(512);
        params.setMin(0);
        params.setMax(255);
        params.setBase(Base.HEXADECIMAL.getRadix());
        a_generateIntegers_params_03(params);
    }
}
