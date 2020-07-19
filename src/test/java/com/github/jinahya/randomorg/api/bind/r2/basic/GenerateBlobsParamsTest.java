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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.jinahya.randomorg.api.bind.AbstractParamsTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readGenson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readGson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readJackson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readJsonb;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readMoshi;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeGenson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeGson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeJackson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeJsonb;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeMoshi;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Slf4j
class GenerateBlobsParamsTest extends AbstractParamsTest<GenerateBlobsParams> {

    GenerateBlobsParamsTest() {
        super(GenerateBlobsParams.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private void a_generateBlobs_params_01(final GenerateBlobsParams params) throws JsonProcessingException {
        requireNonNull(params, "params is null");
        log.debug("params: {}", params);
        requireValid(params);
        assertEquals("6b1e65b9-4186-45c2-8981-b77a9842c4f0", params.getApiKey());
        assertEquals(1, params.getN());
        assertEquals(1024, params.getSize());
        {
            final String jsonb = writeJsonb(params);
            log.debug("jsonb: {}", jsonb);
            assertFalse(jsonb.contains("sizeInBytes"));
            assertFalse(jsonb.contains("formatAsOneOfPredefined"));
        }
        {
            final String jackson = writeJackson(params);
            log.debug("jackson: {}", jackson);
            assertFalse(jackson.contains("sizeInBytes"));
            assertFalse(jackson.contains("formatAsOneOfPredefined"));
        }
        {
            final String gson = writeGson(params);
            log.debug("gson: {}", gson);
            assertFalse(gson.contains("sizeInBytes"));
            assertFalse(gson.contains("formatAsOneOfPredefined"));
        }
        {
            final String moshi = writeMoshi(GenerateBlobsParams.class, params);
            log.debug("moshi: {}", moshi);
            assertFalse(moshi.contains("sizeInBytes"));
            assertFalse(moshi.contains("formatAsOneOfPredefined"));
        }
        {
            final String genson = writeGenson(params);
            log.debug("genson: {}", genson);
            // TODO: Check https://github.com/owlike/genson/issues/158
            assertFalse(genson.contains("sizeInBytes"));
            assertFalse(genson.contains("formatAsOneOfPredefined"));
        }
    }

    @Test
    void r_generateBlobs_params_01() throws IOException {
        {
            try (InputStream resource = getClass().getResourceAsStream("generateBlobs_params_01.json")) {
                final GenerateBlobsParams params = readJackson(resource, GenerateBlobsParams.class);
                a_generateBlobs_params_01(params);
            }
        }
        {
            try (InputStream resource = getClass().getResourceAsStream("generateBlobs_params_01.json")) {
                final GenerateBlobsParams params = readJsonb(resource, GenerateBlobsParams.class);
                a_generateBlobs_params_01(params);
            }
        }
        {
            try (InputStream resource = getClass().getResourceAsStream("generateBlobs_params_01.json")) {
                final GenerateBlobsParams params = readGson(resource, GenerateBlobsParams.class);
                a_generateBlobs_params_01(params);
            }
        }
        {
            try (InputStream resource = getClass().getResourceAsStream("generateBlobs_params_01.json")) {
                final GenerateBlobsParams params = readMoshi(resource, GenerateBlobsParams.class);
                a_generateBlobs_params_01(params);
            }
        }
        {
            try (InputStream resource = getClass().getResourceAsStream("generateBlobs_params_01.json")) {
                final GenerateBlobsParams params = readGenson(resource, GenerateBlobsParams.class);
                a_generateBlobs_params_01(params);
            }
        }
    }

    @Test
    void w_generateBlobs_params_01() throws IOException {
        final GenerateBlobsParams params = new GenerateBlobsParams();
        params.setApiKey("6b1e65b9-4186-45c2-8981-b77a9842c4f0");
        params.setN(1);
        params.setSize(1024);
        a_generateBlobs_params_01(params);
    }
}
