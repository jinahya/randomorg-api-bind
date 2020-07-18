package com.github.jinahya.randomorg.api.bind.r2.basic;

/*-
 * #%L
 * jsonrpc-bind-jackson
 * %%
 * Copyright (C) 2019 - 2020 Jinahya, Inc.
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

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateStringsParams.MAX_LENGTH;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateStringsParams.MIN_LENGTH;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateStringsParams.SIZE_MAX_CHARACTERS;
import static com.github.jinahya.randomorg.api.bind.r2.basic.GenerateStringsParams.SIZE_MIN_CHARACTERS;

@Setter
@Getter
public class GenerateStringsParamsUnit {

    // ---------------------------------------------------------------------------------------------------------- length
    // ------------------------------------------------------------------------------------------------------ characters

    // -----------------------------------------------------------------------------------------------------------------
    @Max(MAX_LENGTH)
    @Min(MIN_LENGTH)
    private int length = MIN_LENGTH;

    @Size(min = SIZE_MIN_CHARACTERS, max = SIZE_MAX_CHARACTERS)
    @NotBlank
    private String characters;

    // -----------------------------------------------------------------------------------------------------------------
    private Boolean replacement;
}