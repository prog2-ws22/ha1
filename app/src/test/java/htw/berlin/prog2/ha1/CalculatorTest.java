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
    @DisplayName("should display the result with negative sign after division of a positive multi-digit number with an positiv one-digit decimal number")
    void testNegativeKey() {

        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        calc.pressNegativeKey();


        String expected = "-9.6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display the result of two multiplied one-digit number´s, but the second one-digit had been cleared and replaced by another one-digit number")
    //Abweichung zu beschriebener Funktionalität pressClearKey() und Online-Taschenrechner: keine Zwischenspeicherung von Werten//
    void testClearKey () {

        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressClearKey();
        calc.pressDigitKey(8);
        calc.pressEqualsKey();

        String expected = ("40");
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("should display Error after division with 0")
    //Abweichung zu beschriebener Funktionalität pressEqualsKey() und Online-Taschenrechner: Division mit 0 zeigt nicht Error an//
    void testDivisionWithZero () {

        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

