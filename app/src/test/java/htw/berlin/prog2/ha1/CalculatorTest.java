package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName("should display the result after multiplying with a negative multi-digit factor")
    void testNegativeMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(4);
        calc.pressNegativeKey();
        calc.pressEqualsKey();

        assertEquals("-78.2", calc.readScreen());
    }

    @Test
    @DisplayName("should display an error message when trying to find the square root of a negative number")
    void testSquareRootOfNegativeNumber() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        assertEquals("Error", calc.readScreen());
    }

    @Test
    @DisplayName("should not perform any calculation when no operation was chosen")
    void testDontPerformCalculationWithoutOperation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressDotKey();
        calc.pressDigitKey(4);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressDigitKey(0);
        calc.pressNegativeKey();

        assertEquals("-9.4000", calc.readScreen());

        calc.pressEqualsKey();

        assertEquals("-9.4", calc.readScreen());
    }
}

