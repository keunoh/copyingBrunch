package com.brunch.kaltz.junittest;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculateTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @Test
    void plusTest() {
        System.out.println("plusTest");
        Calculate calculate = new Calculate(CalculateType.ADD, 10, 20);
        assertNotNull(calculate);
    }

    @Test
    void plusTest2() {
        System.out.println("plusTest");
        Calculate calculate = new Calculate(CalculateType.ADD, 10, 20);
        assertEquals(30, calculate.calculate(),
                () -> "더하기 계신기 이므로 num1과 num2가 더한 값이 나와야 한다.");
    }

    @Test
    void plusTest3() {
        System.out.println("plusTest");
        Calculate calculate = new Calculate(CalculateType.ADD, 10, 20);
        assertTrue(calculate.calculate() == 30, "30이어야만 한다.");
    }

    @Test
    void plusTest4() {
        System.out.println("plusTest");
        Calculate calculate = new Calculate(CalculateType.ADD, 10, 10);

        assertAll(
                () -> assertNotNull(calculate),
                () -> assertEquals(20, calculate.calculate(),
                        () -> "더하기 계산기이므로 더한 값이 나와야 한다."),
                () -> assertTrue(calculate.calculate() == 20, "20이어야 한다.")
        );
    }

    @Test
    void plusTest5() {
        Calculate calculate = new Calculate(CalculateType.ADD, 5, -1);
        assertThat(calculate.calculate())
                .isGreaterThan(0);
    }

    @Test
    @DisplayName("뺄셈을 계산")
    void minus_test() {
        System.out.println("minusTest");
    }
}