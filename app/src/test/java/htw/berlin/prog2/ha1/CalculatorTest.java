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
    @DisplayName("should display result after getting the square root of two")
    void testMultiplication() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 0 by pressing clearkey before the equalskey")
    void testClearDecal() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressClearKey();
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 4")
    void testDotNumber() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display -4")
    void testNegativNumber() {
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

