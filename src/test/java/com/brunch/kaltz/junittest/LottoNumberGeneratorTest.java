package com.brunch.kaltz.junittest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        // when
        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then
        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 1000;

        // when
        final List<Integer> lottoNumber = lottoNumberGenerator.generate(price);

        // then
        assertThat(lottoNumber.stream().allMatch(v -> v >= 1 && v <= 45)).isTrue();
    }

    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberInvalidMoneyTest() {
        // given
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int price = 2000;

        // when
        final RuntimeException exception =
                assertThrows(RuntimeException.class,
                        () -> lottoNumberGenerator.generate(price));
        // then
        assertThat(exception.getMessage()).isEqualTo("올바른 금액이 아닙니다.");
    }
}