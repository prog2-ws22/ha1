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

    /* Teilaufgabe 1*/
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /* Teilaufgabe 2*/
    @Test
    @DisplayName("should display error after dividing by zero")
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

    @Test
    @DisplayName("should display result after pressing two positive numbers for adding, clear the second number and press another number")
    void testClearNumber() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(4);
        calc.pressClearKey();
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

