package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.channels.CancelledKeyException;

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
    @DisplayName("should display the result after subtracting two positive multi-digit numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);

        calc.pressBinaryOperationKey("-");

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "15";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display the result after subtracting a negative from a positive one-digit number")
    void testSubtractNegative() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("-");
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "6";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 'Error' after dividing by zero")
    void testDivideByZero() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

