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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.owlike.genson.Genson;
import com.squareup.moshi.Moshi;
import jakarta.json.bind.JsonbBuilder;
import okio.Okio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonTestUtils {

    // -----------------------------------------------------------------------------------------------------------------
    public static <T> T readJsonb(final InputStream stream, final Class<T> clazz) {
        return JsonbBuilder.create().fromJson(stream, clazz);
    }

    public static <T> T readJackson(final InputStream stream, final Class<T> clazz) throws IOException {
        return new ObjectMapper().readValue(stream, clazz);
    }

    public static <T> T readGson(final InputStream stream, final Class<T> clazz) {
        return new Gson().fromJson(new InputStreamReader(stream), clazz);
    }

    public static <T> T readMoshi(final InputStream stream, final Class<T> clazz) throws IOException {
        return new Moshi.Builder().build().adapter(clazz).fromJson(Okio.buffer(Okio.source(stream)));
    }

    public static <T> T readGenson(final InputStream stream, final Class<T> clazz) {
        return new Genson().deserialize(stream, clazz);
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static String writeJsonb(final Object value) {
        return JsonbBuilder.create().toJson(value);
    }

    public static String writeJackson(final Object value) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(value);
    }

    public static String writeGson(final Object value) {
        return new Gson().toJson(value);
    }

    public static <T> String writeMoshi(final Class<T> clazz, final T value) {
        return new Moshi.Builder().build().adapter(clazz).toJson(value);
    }

    public static String writeGenson(final Object value) {
        return new Genson().serialize(value);
    }
}
