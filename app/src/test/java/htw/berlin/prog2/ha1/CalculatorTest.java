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
    @Test // 1. grüner Test
    @DisplayName("should display result after mutiplying two positive numbers")
    void testMultiplying() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();

        String expected = "12";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test // 1. roter Test
    @DisplayName("should change value everytime clicking = in a row after mutiplying, without changing the input ")
    void testEquals() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        calc.pressEqualsKey();

        String expected = "64";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test // 2. roter Test
    @DisplayName("should display Error instead of NaN")
    void testMultiplyingMinus() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

