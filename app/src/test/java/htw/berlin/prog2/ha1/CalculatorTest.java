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

    @Test
    @DisplayName("should display result after multiplying two positive numbers")
    void testPositiveMultiplication(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(8);
        calc.pressEqualsKey();
        String expected = "56";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display a 0. decimal when pressing dot key right away")
    void testPressDotKey(){
        Calculator calc = new Calculator();
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(1);
        calc.pressDigitKey(8);
        String expected = "0.518";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should only clear screen when clearKey() is used once, but not latestOperation and latestValue")
    void testPressClearKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(6);
        calc.pressEqualsKey();
        calc.pressClearKey();
        calc.pressEqualsKey();


        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

