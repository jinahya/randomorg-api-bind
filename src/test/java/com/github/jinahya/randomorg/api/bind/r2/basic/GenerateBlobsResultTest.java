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
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.github.jinahya.randomorg.api.bind.BeanValidationTests.requireValid;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class GenerateBlobsResultTest
        extends AbstractResultTest<GenerateBlobsResult, GenerateBlobsResult.Random, String> {

    GenerateBlobsResultTest() {
        super(GenerateBlobsResult.class, GenerateBlobsResult.Random.class, String.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateBlobs_result_01(final GenerateBlobsResult result) {
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
        assertEquals(198976L, result.getBitsLeft());
        assertEquals(9999, result.getRequestsLeft());
        assertEquals(0, result.getAdvisoryDelay());
        write(GenerateBlobsResult.class, result, s -> {
        });
    }

    @Test
    void r_generateBlobs_result_01() throws IOException {
        read(getClass(), "generateBlobs_result_01.json", GenerateBlobsResult.class,
             GenerateBlobsResultTest::a_generateBlobs_result_01);
    }

    @Test
    void w_generateBlobs_result_01() {
        final GenerateBlobsResult result = new GenerateBlobsResult();
        result.setRandom(new GenerateBlobsResult.Random());
        result.getRandom().setData(singletonList(
                "aNB8L3hY3kWYXgTUQxGVB5njMe2e0l3LCjkDCN1u12kPBPrsDcWMLTCDlB60kRhAlGbvPqoBHhjg6ZbOM4LfD3T9/wfhvnqJ1FTraamW2IAUnyKxz27fgcPw1So6ToIBL0fGQLpMQDF2/nEmNmFRNa9s6sQ+400IGA+ZeaOAgjE="
        ));
        result.getRandom().setCompletionTime("2011-10-10 13:19:12Z");
        result.setBitsUsed(1024);
        result.setBitsLeft(198976L);
        result.setRequestsLeft(9999);
        result.setAdvisoryDelay(0);
        a_generateBlobs_result_01(result);
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static void a_generateBlobs_result_02(final GenerateBlobsResult result) {
        requireNonNull(result, "result is null");
        assertThat(result.getRandom())
                .isNotNull()
                .satisfies(r -> {
                    assertThat(r.getData())
                            .isNotNull()
                            .hasSize(4)
                            .containsExactly(
                                    "3c9290ab56e2134b054ddc32fd2ccda09329ba13bc708a97e2bb773c02d45aecb9e031f17d7aadbdee377bdbdd32a42008bdee1ac715db82421da704cb2a9a64871be744404dd3ec7f6f396bd294134b7732078a4158dc79f6814f58813544b419e6dfb626977d14cfa5b4e3f335f26e266a84fc2dd84aa8dbd3dddc50626c10a56fb18831e9d886dac5eb775f560b70c265df981b7c63f99b26f86679fae0896845cfdc529ea51cd55c43adcf4d9ab238b0cbdfa879124cb2d5fc2aca9e313eaba745219d964160ce6f24464f8f0ef47446b700f79101714d009aba41c695ac4901dfdb554672b0718d87a8317931ecbd87164889784e2cb052ae792f1d607b2ed169ce0b9fa71ecbf369130bae3e0fe7ba7c7049ae105eb4efb7038645be4c2b9e8f43669aefc4b8e265ebbc350eee3c935c27f0ab46676e858309a4f49c480c62462829dbb5ea351d26b99cd7ca3c89d944a7132505ddc794e45c4828377a8eb5b877a3a1bee48991447c2dcf8d04765ed144e0fabd771f49a11204e82772bdbc0d61bf7935b2b757abb8091beefea165e458a3af108472d0650106f715c77e05cf353b28670f878c620fa5bc7707b745aacad29ac5cf28ff07bfbf0600bce4f41c26569d555c1bc606e678c34bcfa55b3ad3f503a2e95aa560abbe0939bee660cb49260c7f7811f820c0b406f476a7b13f3627bbdb898a83044da28be830d978ac5fdc69f48fcb1db21f525e020940c4e407a83f4ff736577345d9564b48e4f32e827a746cb0818e91c97e9f24d852265ecaedb367321cad60ac170f8f5cc388cd63a77881ade844e08d9e74d457842d64d2e1b47ffdfd784b3a0c2a70a325fe14a2966fa3ccabef5ce651f5b3fd99e2c6ecfb7ef6d14f2a508c515e29cc12f9c47a4a9b3503a27bddf8b1da8373102e13ff0a59ae42a9e0e258adc55886140c1492426dd22b9e2b78d46075b0c14154d6a05b4ecb7939c92409e1134fa7f943bbe64845541d9464414e3bc8f3612d3adabec7f405e7e8b7a2afb9a981b608775225e3abe3e22009ecf5dc254cbf416100ebf417f9004a991f5d966fbdb4",
                                    "6dcf36d75f1b627abb95146515450453cd5383df876146574e0aa31f5f65418064c00561bfe0dae7d22262145f400bb12e79b96f591c62ff99b6ff429c7f2c18851386604969775d8d4c864665d812a5a7eb6c3ded1048611672900050f0ec7df0abd583258b85c0abcc191e8f712593b17e044b8522e444dac88f59ea52acaab0f41a7237bf49aef39986f620bf8a033d3ebadb481c8c1b7de4d310933da67c2e4414118b8730ca99dbf232602a2fa38b29ebe0f560c16a8d7fe98f8a7ed86e6b5a21b9e4e804474f2d1c7c23b0d2a8edd36601757c339114a3e447860323a6de139648d4ede17d45d67fcb1194b888da90daf4faebad21bf7f1a3f5ed3dafc813a6c0795d2a12a121c55ca91358bb68ef1f2eaa1445fc9486e1e249874078b67b486c78d96c9d6853594f51de17dca2eb6615ecb9190eb6072f4b56de8209b75053894981339223e03c9fd3655b9af3113c08819057060c59456da9b374a671533d9a1fd0fad17fc9ebb90a0813d6c17728fd1d100a913fe0934c252d2e8bcecff411b2eeb2dcecd8d639c646715dae3aa0344387d5f0022d72309dd504867f8fd1b12afa077c0bf12719b336a57ea369a9dbc1505dbdcd2457ad48ff14ed871a64ae409782dd6d1a526e5bb650247c661a606cfc68438fe09939efea1992d96dd2640881c79397bc4d65cfc91e4adb9f57cd6175f9f1f3b102aa1f5a4bee0c7e75264089d0f112ac847808908c38eee391e7d0ea57cbd12282c6ec1acd660f244955888e1403a3220310e78da4bd7e1285e83c69a8b7eb79a67e9b03ac5ae95fabd88345315cd76467040f0385c8432614cc89b2a8d7852549f3ccc5b8983a38efe11041d493bd395e5d15e3d35c409e7f2a9fd63d70b0f0baf01f0ccb7e81a621ab1fd2df3e0459e5321655a2eafeacea1179f41add34ad43bbc2a95318eda137f9f02e751672a8f1c040c108d90aa7f39d20c33ae39774b75ffdde5ce27cbc07090e38af2ac3277ee5ba080f0d9bfb5adbef7cf57253105b83554fcfc266d6fe540fffa7da60ec688ff2892861edc05e427e9eee26ef72406ba5eccd299",
                                    "f75eb6eb3e2aff30104aac1ffd5cffbc322889770963f3dff7ad2261b8f43bf5e1a029df958627cbc060dc850926b5e060807c8d9ba00d34d61025c11c171bb71ab2f1c28fac2f019da1a2844de78d7b6f5f91b4f188bf1389097839ab559f6f1baff54d3afebd50485fd8de4b207c903dde80fe8d460dc9b0eb16d58659e571fdc8a035da15a470ebb7a56fd223ff608a91093d91e54bd0a8f4ee019d120d1008504298b304d24848188ea964e68244ee4229a5192f23e84edb19d1672f371d431ae3a332e9db184b1d459227c5ef1685b56117ac76676fb2c182da230cbb1ba29699e411a026ea689898c9d8f4b9b4cbed0bbb74b9533ea1122c865aba8c14a6a13c0cb60f60860afb3f8793fcd46eec495d3940817c40ab18d37ce0b6775c2d3d11f13742fabf90a265cf70a9ccc01858ced37297f0ffdc4827d86477352e1ce214ba861c0b65eafeb63cf2eb87768878395486b32e941d86f7e51770813d0c3a42833dd8cd4d2644776aa773d9453550b0687a8dfae2071c46ce942f687f9496286e5138f936d8c8da04dc1e7ad56e2f73634168b21abecaa60f5744026115bad5fdd159ff0cae94daa91366b75bbbf5c8b33f5cbc41529ba036f3217fb181701a7e4b34e0977f6fa28047f59d4975e3b850c21d4e0d82c0d5ce8236712009576de9811a5b84d540d65a3151336db52fef05cd9ca9f895f212149050ac42918f160f73cc535a2888ec09b14a44e1d50b79037dcfa355f7cc470aac7d1fe354c369afd798e95b54481347609f5f6c5ef2181b90712b20578fca13a1996b9c76156dc352190f123d65db9a43eff61c1d4be5b735ef1c67ad7a33fd23c820e87437bda12442d851e45c3ad296dd2fb76e2e9a90df48087aa687ee6d6077f87ac8fa71beb3d2aeb1692a71674d7a591d7e4329920030fcf629123464f6e2e27fbb0038541d6460e2487fdf04bcba19181550d9db6b1f596fccd0a61df94d505b025f725fe9ac4d073d438c9d27f8b500b3dcb1a45789cb5b3bc081895ce6f4a9252fb39fddd6f2da441eaeb47b8198e5497a21d56be7726e43811200d19cc956",
                                    "46f3ca09de243b3bf44113829ca9f4a719d882a31878ed130f04d3799c1b85a6ef9ed01f51a66c6fd354ede0140ac49375afcd7cb45b6fe0681a86a762388de71be787a411f479f08adb86e7a624eba426e44d2a311bc8596ee4bc91158837742bd7a7c0861cea5dc2599e1aae6f543a19795be71c3a43e4784e3cba6dc421b312ff8a31a1267a094d7b021191be71620980be6f001aaa7f5331f72eacb97a4e49bd680ad174da2d5bff64642a26fb61ca261dfc2aeb8b2ce12bd9afe113d4a48accd16d397621b2ab89119d2646e82e52a59c628bdbdc554a18d5e02a6b411960237270134424e470298f8bdabd4cc7582c3d3fd585ed7eb71d19f269968d681d076c19e563d258e47698e246a4935f180f5675eecc307e5384a26c4d4ff5bb105e087aa6496ef6cf2737c88f33486ddca695ff5a0451b25458f904664ee140ce7fdce97a9e5ab28ab32eb586478d7fba8a84c667ba1e62a0365633a878b1c9f9601c37df5afb7ff22aa98217501e7ed4fe95f9ddc03b682782379a9c5655d6dcafc384fd4201f727bf56d8b17efd86ce80d1f104b3d966b1e5d083cba04aa814629bad4d434a3673db107c79107c70ef6d10b608919f442f88a81fd47dca6181f95100727f4260df76ce9d5b3b4be834f8d2b191f8e9e00de49dd0764c003e85465d2362f001289eef63c376931e3955f14629f41e0fa738010baec1dba7b11da8521c2dcdcb2f789bef281a61514e3febae5909a0a5afc237cf00502f88bb5e1080f54df463d2ac457d55cc2f97e3d7540452abda74ac5b122c5bf3e6c2bd06d6b640ae8eac5a32bc88361d0d4e784980926bfb817ae62aaaba892a3f9f039d9b26450e3160725ee2fe375afd64a1be965523dde42c180e2d4b4477603f88d821e44f2ff5a43d57f826893fc8885919c5cf416279c3708efceb6d334b408c524d7b0bd6da38db109482ab33686de2608689a81b516b3b3bd852b2af509bbab588c7d61517988d6b11b3b3bcb5f3088ad666b98551de4ba8a1df633571f98ba856e39df803c891a6df2ddc86f1f58c4b8ee6281f627aee768a440fa7606a74"
                            )
                            .allSatisfy(e -> {
                                assertThat(e).isNotNull().hasSize(6144 >> 3 << 1);
                                final byte[] parsed = GenerateBlobsParams.Format.HEX.decode(e);
                                assertThat(parsed).isNotNull().hasSize(6144 >> 3);
                            });
                })
        ;
        assertCompletionTimeEquals(2011, 10, 10, 13, 19, 12, result.getRandom());
        assertEquals(24576, result.getBitsUsed());
        assertEquals(175424L, result.getBitsLeft());
        assertEquals(9999, result.getRequestsLeft());
        assertEquals(0, result.getAdvisoryDelay());
    }

    @Test
    void r_generateBlobs_result_02() throws IOException {
        read(getClass(), "generateBlobs_result_02.json", GenerateBlobsResult.class,
             GenerateBlobsResultTest::a_generateBlobs_result_02);
    }

    @Test
    void w_generateBlobs_result_02() {
        final GenerateBlobsResult result = new GenerateBlobsResult();
        result.setRandom(new GenerateBlobsResult.Random());
        result.getRandom().setData(asList(
                "3c9290ab56e2134b054ddc32fd2ccda09329ba13bc708a97e2bb773c02d45aecb9e031f17d7aadbdee377bdbdd32a42008bdee1ac715db82421da704cb2a9a64871be744404dd3ec7f6f396bd294134b7732078a4158dc79f6814f58813544b419e6dfb626977d14cfa5b4e3f335f26e266a84fc2dd84aa8dbd3dddc50626c10a56fb18831e9d886dac5eb775f560b70c265df981b7c63f99b26f86679fae0896845cfdc529ea51cd55c43adcf4d9ab238b0cbdfa879124cb2d5fc2aca9e313eaba745219d964160ce6f24464f8f0ef47446b700f79101714d009aba41c695ac4901dfdb554672b0718d87a8317931ecbd87164889784e2cb052ae792f1d607b2ed169ce0b9fa71ecbf369130bae3e0fe7ba7c7049ae105eb4efb7038645be4c2b9e8f43669aefc4b8e265ebbc350eee3c935c27f0ab46676e858309a4f49c480c62462829dbb5ea351d26b99cd7ca3c89d944a7132505ddc794e45c4828377a8eb5b877a3a1bee48991447c2dcf8d04765ed144e0fabd771f49a11204e82772bdbc0d61bf7935b2b757abb8091beefea165e458a3af108472d0650106f715c77e05cf353b28670f878c620fa5bc7707b745aacad29ac5cf28ff07bfbf0600bce4f41c26569d555c1bc606e678c34bcfa55b3ad3f503a2e95aa560abbe0939bee660cb49260c7f7811f820c0b406f476a7b13f3627bbdb898a83044da28be830d978ac5fdc69f48fcb1db21f525e020940c4e407a83f4ff736577345d9564b48e4f32e827a746cb0818e91c97e9f24d852265ecaedb367321cad60ac170f8f5cc388cd63a77881ade844e08d9e74d457842d64d2e1b47ffdfd784b3a0c2a70a325fe14a2966fa3ccabef5ce651f5b3fd99e2c6ecfb7ef6d14f2a508c515e29cc12f9c47a4a9b3503a27bddf8b1da8373102e13ff0a59ae42a9e0e258adc55886140c1492426dd22b9e2b78d46075b0c14154d6a05b4ecb7939c92409e1134fa7f943bbe64845541d9464414e3bc8f3612d3adabec7f405e7e8b7a2afb9a981b608775225e3abe3e22009ecf5dc254cbf416100ebf417f9004a991f5d966fbdb4",
                "6dcf36d75f1b627abb95146515450453cd5383df876146574e0aa31f5f65418064c00561bfe0dae7d22262145f400bb12e79b96f591c62ff99b6ff429c7f2c18851386604969775d8d4c864665d812a5a7eb6c3ded1048611672900050f0ec7df0abd583258b85c0abcc191e8f712593b17e044b8522e444dac88f59ea52acaab0f41a7237bf49aef39986f620bf8a033d3ebadb481c8c1b7de4d310933da67c2e4414118b8730ca99dbf232602a2fa38b29ebe0f560c16a8d7fe98f8a7ed86e6b5a21b9e4e804474f2d1c7c23b0d2a8edd36601757c339114a3e447860323a6de139648d4ede17d45d67fcb1194b888da90daf4faebad21bf7f1a3f5ed3dafc813a6c0795d2a12a121c55ca91358bb68ef1f2eaa1445fc9486e1e249874078b67b486c78d96c9d6853594f51de17dca2eb6615ecb9190eb6072f4b56de8209b75053894981339223e03c9fd3655b9af3113c08819057060c59456da9b374a671533d9a1fd0fad17fc9ebb90a0813d6c17728fd1d100a913fe0934c252d2e8bcecff411b2eeb2dcecd8d639c646715dae3aa0344387d5f0022d72309dd504867f8fd1b12afa077c0bf12719b336a57ea369a9dbc1505dbdcd2457ad48ff14ed871a64ae409782dd6d1a526e5bb650247c661a606cfc68438fe09939efea1992d96dd2640881c79397bc4d65cfc91e4adb9f57cd6175f9f1f3b102aa1f5a4bee0c7e75264089d0f112ac847808908c38eee391e7d0ea57cbd12282c6ec1acd660f244955888e1403a3220310e78da4bd7e1285e83c69a8b7eb79a67e9b03ac5ae95fabd88345315cd76467040f0385c8432614cc89b2a8d7852549f3ccc5b8983a38efe11041d493bd395e5d15e3d35c409e7f2a9fd63d70b0f0baf01f0ccb7e81a621ab1fd2df3e0459e5321655a2eafeacea1179f41add34ad43bbc2a95318eda137f9f02e751672a8f1c040c108d90aa7f39d20c33ae39774b75ffdde5ce27cbc07090e38af2ac3277ee5ba080f0d9bfb5adbef7cf57253105b83554fcfc266d6fe540fffa7da60ec688ff2892861edc05e427e9eee26ef72406ba5eccd299",
                "f75eb6eb3e2aff30104aac1ffd5cffbc322889770963f3dff7ad2261b8f43bf5e1a029df958627cbc060dc850926b5e060807c8d9ba00d34d61025c11c171bb71ab2f1c28fac2f019da1a2844de78d7b6f5f91b4f188bf1389097839ab559f6f1baff54d3afebd50485fd8de4b207c903dde80fe8d460dc9b0eb16d58659e571fdc8a035da15a470ebb7a56fd223ff608a91093d91e54bd0a8f4ee019d120d1008504298b304d24848188ea964e68244ee4229a5192f23e84edb19d1672f371d431ae3a332e9db184b1d459227c5ef1685b56117ac76676fb2c182da230cbb1ba29699e411a026ea689898c9d8f4b9b4cbed0bbb74b9533ea1122c865aba8c14a6a13c0cb60f60860afb3f8793fcd46eec495d3940817c40ab18d37ce0b6775c2d3d11f13742fabf90a265cf70a9ccc01858ced37297f0ffdc4827d86477352e1ce214ba861c0b65eafeb63cf2eb87768878395486b32e941d86f7e51770813d0c3a42833dd8cd4d2644776aa773d9453550b0687a8dfae2071c46ce942f687f9496286e5138f936d8c8da04dc1e7ad56e2f73634168b21abecaa60f5744026115bad5fdd159ff0cae94daa91366b75bbbf5c8b33f5cbc41529ba036f3217fb181701a7e4b34e0977f6fa28047f59d4975e3b850c21d4e0d82c0d5ce8236712009576de9811a5b84d540d65a3151336db52fef05cd9ca9f895f212149050ac42918f160f73cc535a2888ec09b14a44e1d50b79037dcfa355f7cc470aac7d1fe354c369afd798e95b54481347609f5f6c5ef2181b90712b20578fca13a1996b9c76156dc352190f123d65db9a43eff61c1d4be5b735ef1c67ad7a33fd23c820e87437bda12442d851e45c3ad296dd2fb76e2e9a90df48087aa687ee6d6077f87ac8fa71beb3d2aeb1692a71674d7a591d7e4329920030fcf629123464f6e2e27fbb0038541d6460e2487fdf04bcba19181550d9db6b1f596fccd0a61df94d505b025f725fe9ac4d073d438c9d27f8b500b3dcb1a45789cb5b3bc081895ce6f4a9252fb39fddd6f2da441eaeb47b8198e5497a21d56be7726e43811200d19cc956",
                "46f3ca09de243b3bf44113829ca9f4a719d882a31878ed130f04d3799c1b85a6ef9ed01f51a66c6fd354ede0140ac49375afcd7cb45b6fe0681a86a762388de71be787a411f479f08adb86e7a624eba426e44d2a311bc8596ee4bc91158837742bd7a7c0861cea5dc2599e1aae6f543a19795be71c3a43e4784e3cba6dc421b312ff8a31a1267a094d7b021191be71620980be6f001aaa7f5331f72eacb97a4e49bd680ad174da2d5bff64642a26fb61ca261dfc2aeb8b2ce12bd9afe113d4a48accd16d397621b2ab89119d2646e82e52a59c628bdbdc554a18d5e02a6b411960237270134424e470298f8bdabd4cc7582c3d3fd585ed7eb71d19f269968d681d076c19e563d258e47698e246a4935f180f5675eecc307e5384a26c4d4ff5bb105e087aa6496ef6cf2737c88f33486ddca695ff5a0451b25458f904664ee140ce7fdce97a9e5ab28ab32eb586478d7fba8a84c667ba1e62a0365633a878b1c9f9601c37df5afb7ff22aa98217501e7ed4fe95f9ddc03b682782379a9c5655d6dcafc384fd4201f727bf56d8b17efd86ce80d1f104b3d966b1e5d083cba04aa814629bad4d434a3673db107c79107c70ef6d10b608919f442f88a81fd47dca6181f95100727f4260df76ce9d5b3b4be834f8d2b191f8e9e00de49dd0764c003e85465d2362f001289eef63c376931e3955f14629f41e0fa738010baec1dba7b11da8521c2dcdcb2f789bef281a61514e3febae5909a0a5afc237cf00502f88bb5e1080f54df463d2ac457d55cc2f97e3d7540452abda74ac5b122c5bf3e6c2bd06d6b640ae8eac5a32bc88361d0d4e784980926bfb817ae62aaaba892a3f9f039d9b26450e3160725ee2fe375afd64a1be965523dde42c180e2d4b4477603f88d821e44f2ff5a43d57f826893fc8885919c5cf416279c3708efceb6d334b408c524d7b0bd6da38db109482ab33686de2608689a81b516b3b3bd852b2af509bbab588c7d61517988d6b11b3b3bcb5f3088ad666b98551de4ba8a1df633571f98ba856e39df803c891a6df2ddc86f1f58c4b8ee6281f627aee768a440fa7606a74"
        ));
        result.getRandom().setCompletionTime("2011-10-10 13:19:12Z");
        result.setBitsUsed(24576);
        result.setBitsLeft(175424L);
        result.setRequestsLeft(9999);
        result.setAdvisoryDelay(0);
        a_generateBlobs_result_02(result);
    }
}
