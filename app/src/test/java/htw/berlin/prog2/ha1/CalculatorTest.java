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
    //Erster Grüner Test
    @Test
    @DisplayName("should display result after multiplying two positive single-digit numbers")
    void testPositiveMultiplikation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    } //Erster Gründer Test ende

    //Erster Roter test
    @Test
    @DisplayName("should display Error String if a Number is divided by 0")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";    //Fehlermeldung anstatt "error" kommt "Infinity" -> Nicht wie im online Taschenrechner
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    //Erster Roter Test ende

    //Zweiter Roter Test
    @Test
    @DisplayName("should display number without the extra dot at the end")
    void testGetRidOfExtraDot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();


        String expected = "2.2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    } // Ende zweiter Roter Test



}

