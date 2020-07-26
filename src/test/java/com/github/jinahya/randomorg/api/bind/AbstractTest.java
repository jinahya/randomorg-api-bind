package com.github.jinahya.randomorg.api.bind;

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

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readJackson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.readJsonb;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeJackson;
import static com.github.jinahya.randomorg.api.bind.JsonTestUtils.writeJsonb;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
abstract class AbstractTest {

    protected static <T> void read(final Class<?> clazz, final String name, final Class<T> type,
                                   final Consumer<? super T> consumer)
            throws IOException {
        try (InputStream resource = clazz.getResourceAsStream(name)) {
            assertNotNull(resource);
            final T params = readJsonb(resource, type);
            consumer.accept(params);
        }
        try (InputStream resource = clazz.getResourceAsStream(name)) {
            assertNotNull(resource);
            final T params = readJackson(resource, type);
            consumer.accept(params);
        }
//        try (InputStream resource = clazz.getResourceAsStream(name)) {
//            final T params = readGson(resource, type);
//            consumer.accept(params);
//        }
//        try (InputStream resource = clazz.getResourceAsStream(name)) {
//            final T params = readMoshi(resource, type);
//            consumer.accept(params);
//        }
//        try (InputStream resource = clazz.getResourceAsStream(name)) {
//            final T params = readGenson(resource, type);
//            consumer.accept(params);
//        }
    }

    protected static <T> void write(final Class<T> type, final T value, final Consumer<? super String> consumer) {
        requireNonNull(value, "value is null");
        requireNonNull(consumer, "consumer is null");
        requireValid(value);
        {
            final String string = writeJsonb(value);
            consumer.accept(string);
        }
        {
            final String string = writeJackson(value);
            consumer.accept(string);
        }
//        {
//            final String string = writeGson(value);
//            consumer.accept(string);
//        }
//        {
//            final String string = writeMoshi(type, value);
//            consumer.accept(string);
//        }
//        {
//            final String string = writeGenson(value);
//            consumer.accept(string);
//        }
    }
}
