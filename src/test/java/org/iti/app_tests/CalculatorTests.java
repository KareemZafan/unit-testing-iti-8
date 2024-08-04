package org.iti.app_tests;

import org.iti.app.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTests {
    private static Calculator calculator;

    @BeforeAll
    static void beforeAllTests() {
        calculator = new Calculator();
        System.out.println("this message will appear one time");
    }

    @AfterAll
    static void afterAllTest() {
        System.out.println("After all tests");
    }


    @BeforeEach
    void beforeEachTestCase() {
        System.out.println("This sentence will appear before each test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("This sentence will appear after each test");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    @DisplayName("Feature-123 Addition Functionality")
    void testAddFunctionality(String a, String b, String sum) {
        assertEquals(Double.parseDouble(sum), calculator.add(Double.parseDouble(a), Double.parseDouble(b)));
        System.out.println("ADD");
    }

    @Test
    @Tag("FEB-Regression")
    void testSubtractFunctionality() {
        assertEquals(-31, calculator.sub(2, 33));
        assertEquals(52, calculator.sub(2, -50));
        assertEquals(0, calculator.sub(0, 0));
        assertEquals(31, calculator.sub(-2, -33));
        System.out.println("SUB");

    }

    @Test
   // @Disabled("Not ready yet!")
    void testMultiplyFunctionality() {
        assertEquals(66, calculator.mul(2, 33));
        assertEquals(-100, calculator.mul(2, -50));
        assertEquals(0, calculator.mul(0, 0));
        assertEquals(66, calculator.mul(-2, -33));
        System.out.println("MUL");
    }

    @Test
    @Tag("FEB-Regression")
    void testDivisionFunctionality() {
        assertEquals(2, calculator.div(66, 33));
        assertEquals(-0.04, calculator.div(2, -50));
        assertEquals(-1, calculator.div(-2, 2));

        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.div(2, 0));
        assertEquals("Division By Zero!", ex.getMessage());
        System.out.println("DIV");

    }

    @Test
    //@DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_20)
    void testSquareRootFunctionality() {
        assertEquals(13, calculator.sqrt(169));
        assertEquals(20, calculator.sqrt(400));
        assertEquals(2, calculator.sqrt(4));
        System.out.println("SQRT");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testModulusFunctionality() {
        assertEquals(2, calculator.mod(12, 5));
        assertEquals(4, calculator.mod(18, 7));

        Exception ex = assertThrowsExactly(ArithmeticException.class, () -> calculator.mod(2, 0));
        assertEquals("Division By Zero!", ex.getMessage());
        System.out.println("MOD");


    }

}
