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
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "4";
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
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveMultiplication() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        String expected = "9";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result error after divide a positive number by zero")
    void testPositiveDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after adding one negative and one positive multi-digit numbers")
    void testNegativeAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(-2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

