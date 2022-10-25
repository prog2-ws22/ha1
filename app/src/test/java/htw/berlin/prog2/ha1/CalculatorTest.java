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
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition1() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "77";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after getting the square root of 5 minus 3")
    void testSquareRoot1() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressUnaryOperationKey("√");
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("√");
        calc.pressEqualsKey();

        String expected = "0.50401717";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositivenew() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

