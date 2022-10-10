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

    //Teilaufgabe 1
    @Test
    @DisplayName("should display result after subtracting two positive numbers")
    void testSubtraction() {
        Calculator calc = new Calculator();
        
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2.1
    @Test
    @DisplayName("should display only one 0 when typing in a 0")
    void testDoubleZero() {
        Calculator calc = new Calculator();
        
        calc.pressDigitKey(0);

        String expected = "0";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2.2
    @Test
    @DisplayName("should display 'Error' when pressing inversion key for a 0")
    void testZeroInversion() {
        Calculator calc = new Calculator();

        calc.pressUnaryOperationKey("1/x");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

//2 Bugfixes schreiben, damit letzten 2 Tests grün werden -> Commit

}

