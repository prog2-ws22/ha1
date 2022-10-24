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

    //Teilaufgabe ha1   1.grüner Test minus 2 positive nummer
    @Test
    @DisplayName("should display result after minus two positive multi-digit numbers")
    void testPositiveMinus() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Teilaufgabe1 ha1 2.grüner Test division 2 positive nummer
    @Test
    @DisplayName("should display result after division two positive multi-digit numbers")
    void testPositiveDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Teilaufgabe2 ha1. 1. roter Test division durch null ,error muss sein.
    @Test
    @DisplayName("should display result after division eine positive mit null multi-digit numbers")
    void testNullDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Teilaufgabe2 ha1 2. roter Test negative square root nummer muss error sein.

    @Test
    @DisplayName("should display result after  the getting square root of negative numbers")
    void testNegativeSquare() {
        Calculator calc = new Calculator();
        calc.pressNegativeKey();

        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");
        calc.pressEqualsKey();

        String expected = "error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


}

