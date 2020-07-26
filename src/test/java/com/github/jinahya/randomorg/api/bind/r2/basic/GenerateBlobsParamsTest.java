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

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
class GenerateBlobsParamsTest extends AbstractParamsTest<GenerateBlobsParams> {

    GenerateBlobsParamsTest() {
        super(GenerateBlobsParams.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateBlobs_params_01(final GenerateBlobsParams params) {
        requireNonNull(params, "params is null");
        log.debug("params: {}", params);
        requireValid(params);
        assertThat(params.getApiKey())
                .isNotNull()
                .isEqualTo("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        assertEquals(1, params.getN());
        assertEquals(1024, params.getSize());
        write(GenerateBlobsParams.class, params, s -> {
            assertFalse(s.contains("sizeInBytes"));
            assertFalse(s.contains("formatAsOneOfPredefined"));
        });
    }

    @Test
    void r_generateBlobs_params_01() throws IOException {
        read(getClass(), "generateBlobs_params_01.json", GenerateBlobsParams.class,
             GenerateBlobsParamsTest::a_generateBlobs_params_01);
    }

    @Test
    void w_generateBlobs_params_01() {
        final GenerateBlobsParams params = new GenerateBlobsParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(1);
        params.setSize(1024);
        a_generateBlobs_params_01(params);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateBlobs_params_02(final GenerateBlobsParams params) {
        requireNonNull(params, "params is null");
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(4, params.getN());
        assertEquals(6144, params.getSize());
        write(GenerateBlobsParams.class, params, s -> {
            assertFalse(s.contains("sizeInBytes"));
            assertFalse(s.contains("formatAsOneOfPredefined"));
        });
    }

    @Test
    void r_generateBlobs_params_02() throws IOException {
        read(getClass(), "generateBlobs_params_02.json", GenerateBlobsParams.class,
             GenerateBlobsParamsTest::a_generateBlobs_params_02);
    }

    @Test
    void w_generateBlobs_params_02() {
        final GenerateBlobsParams params = new GenerateBlobsParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(4);
        params.setSize(6144);
        write(GenerateBlobsParams.class, params, s -> {
            a_generateBlobs_params_02(params);
        });
    }
}
