package org.iti.app_tests;

import org.iti.app.StringManipulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringManipulationTests {
    private StringManipulation strManipulation;

    private static Stream<String> provideData() {
        return Stream.of("iti", "madam", "level", "racecar", "noon", "mom", "civic"
        );
    }

    @BeforeEach
    void setUp() {
        strManipulation = new StringManipulation();
    }

    @Test
    @Tag("FEB-Regression")
    @Timeout(unit = TimeUnit.MINUTES, value = 1)
    void testReversingString() {
        assertEquals("iti", strManipulation.reverseString("iti"));
        assertEquals("meerak", strManipulation.reverseString("kareem"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"iti", "madam", "level", "racecar", "noon", "mom", "civic"})
    @Tag("FEB-Regression")
    void tesPalindromeStrings1(String input) {
        assertTrue(strManipulation.isPalindrome(input));
    }

    @ParameterizedTest
    @MethodSource("provideData")
    @Tag("FEB-Regression")
    void tesPalindromeStrings2(String a) {
        assertTrue(strManipulation.isPalindrome(a));
    }


}
