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
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readJackson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateBlobsResultTest
        extends AbstractResultTest<GenerateBlobsResult, GenerateBlobsResult.Random, String> {

    GenerateBlobsResultTest() {
        super(GenerateBlobsResult.class, GenerateBlobsResult.Random.class, String.class);
    }

    @Test
    void read_generateBlobs_result_01() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateBlobs_result_01.json")) {
            final GenerateBlobsResult result
                    = new ObjectMapper().readValue(resource, GenerateBlobsResult.class);
            log.debug("result: {}", result);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .containsExactly("aNB8L3hY3kWYXgTUQxGVB5nj" +
                                                 "Me2e0l3LCjkDCN1u12kPBPrs" +
                                                 "DcWMLTCDlB60kRhAlGbvPqoB" +
                                                 "Hhjg6ZbOM4LfD3T9/wfhvnqJ" +
                                                 "1FTraamW2IAUnyKxz27fgcPw" +
                                                 "1So6ToIBL0fGQLpMQDF2/nEm" +
                                                 "NmFRNa9s6sQ+400IGA+ZeaOAgjE=");
                        assertThat(r.getDataAsDecodedBinaries(GenerateBlobsParams.Format.BASE64))
                                .isNotNull()
                                .hasSize(1)
                                .satisfies(l -> {
                                    assertThat(l.get(0)).hasSize(1024 >> 3);
                                });
                    })
            ;
            assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, result.getRandom());
            assertEquals(1024, result.getBitsUsed());
            assertEquals(198976, result.getBitsLeft());
            assertEquals(9999, result.getRequestsLeft());
            assertEquals(0, result.getAdvisoryDelay());
        }
    }

    @Test
    void read_generateBlobs_result_02() throws IOException {
        try (InputStream resource = getClass().getResourceAsStream("generateBlobs_result_02.json")) {
            final GenerateBlobsResult result = readJackson(resource, GenerateBlobsResult.class);
            requireValid(result);
            assertThat(result.getRandom())
                    .isNotNull()
                    .satisfies(r -> {
                        assertThat(r.getData())
                                .isNotNull()
                                .hasSize(4)
                                .allSatisfy(e -> {
                                    assertThat(e).isNotNull().hasSize(6144 >> 3 << 1);
                                    final byte[] parsed = GenerateBlobsParams.Format.HEX.decode(e);
                                    assertThat(parsed).isNotNull().hasSize(6144 >> 3);
                                });
                    });
            assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, result.getRandom());
            assertEquals(24576, result.getBitsUsed());
            assertEquals(175424, result.getBitsLeft());
            assertEquals(9999, result.getRequestsLeft());
            assertEquals(0, result.getAdvisoryDelay());
        }
    }
}
