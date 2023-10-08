package com.gmonnet.yatzy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyTest {

    @ParameterizedTest(name = "chance should return {5}")
    @CsvSource({
        "2, 3, 4, 5, 1, 15",
        "3, 3, 4, 5, 1, 16"
    })
    void test_chance(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).chance());
    }

    @ParameterizedTest(name = "yatzy should return {5}")
    @CsvSource({
        "4, 4, 4, 4, 4, 50",
        "6, 6, 6, 6, 6, 50",
        "6, 6, 6, 6, 3, 0"
    })
    void test_yatzy(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).yatzy());
    }

    @ParameterizedTest(name = "ones should return {5}")
    @CsvSource({
        "1, 2, 3, 4, 5, 1",
        "1, 2, 1, 4, 5, 2",
        "6, 2, 2, 4, 5, 0",
        "1, 2, 1, 1, 1, 4"
    })
    void test_ones(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).ones());
    }

    @ParameterizedTest(name = "twos should return {5}")
    @CsvSource({
        "1, 2, 3, 2, 6, 4",
        "2, 2, 2, 2, 2, 10"
    })
    void test_twos(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).twos());
    }


    @ParameterizedTest(name = "threes should return {5}")
    @CsvSource({
        "1, 2, 3, 2, 3, 6",
        "2, 3, 3, 3, 3, 12"
    })
    void test_threes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).threes());
    }


    @ParameterizedTest(name = "fours should return {5}")
    @CsvSource({
        "4, 4, 4, 5, 5, 12",
        "4, 4, 5, 5, 5, 8",
        "4, 5, 5, 5, 5, 4"
    })
    void test_fours(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fours());
    }


    @ParameterizedTest(name = "fives should return {5}")
    @CsvSource({
        "4, 4, 4, 5, 5, 10",
        "4, 4, 5, 5, 5, 15",
        "4, 5, 5, 5, 5, 20"
    })
    void test_fives(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fives());
    }


    @ParameterizedTest(name = "sixes should return {5}")
    @CsvSource({
        "4, 4, 4, 5, 5, 0",
        "4, 4, 6, 5, 5, 6",
        "6, 5, 6, 6, 5, 18"
    })
    void test_sixes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).sixes());
    }


    @ParameterizedTest(name = "scorePair should return {5}")
    @CsvSource({
        "3, 4, 3, 5, 6,  6",
        "5, 3, 3, 3, 5, 10",
        "5, 3, 6, 6, 5, 12"
    })
    void test_scorePair(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).scorePair());
    }

    @ParameterizedTest(name = "twoPair should return {5}")
    @CsvSource({
        "3, 3, 5, 4, 5, 16",
        "3, 3, 5, 5, 5, 16"
    })
    void test_twoPair(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).twoPair());
    }


    @ParameterizedTest(name = "threeOfAKind should return {5}")
    @CsvSource({
        "3, 3, 3, 4, 5, 9",
        "5, 3, 5, 4, 5, 15",
        "3, 3, 3, 3, 5, 9"
    })
    void test_threeOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).threeOfAKind());
    }

    @ParameterizedTest(name = "fourOfAKind should return {5}")
    @CsvSource({
        "3, 3, 3, 3, 5, 12",
        "5, 5, 5, 4, 5, 20",
        "3, 3, 3, 3, 3, 12"
    })
    void test_fourOfAKind(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fourOfAKind());
    }


    @ParameterizedTest(name = "smallStraight should return {5}")
    @CsvSource({
        "1, 2, 3, 4, 5, 15",
        "2, 3, 4, 5, 1, 15",
        "1, 2, 2, 4, 5, 0"
    })
    void test_smallStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).smallStraight());
    }


    @ParameterizedTest(name = "largeStraight should return {5}")
    @CsvSource({
        "6, 2, 3, 4, 5, 20",
        "2, 3, 4, 5, 6, 20",
        "1, 2, 2, 4, 5, 0"
    })
    void test_largeStraight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).largeStraight());
    }


    @ParameterizedTest(name = "fullHouse should return {5}")
    @CsvSource({
        "6, 2, 2, 2, 6, 18",
        "2, 3, 4, 5, 6, 0"
    })
    void test_fullHouse(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy(d1, d2, d3, d4, d5).fullHouse());
    }
}
