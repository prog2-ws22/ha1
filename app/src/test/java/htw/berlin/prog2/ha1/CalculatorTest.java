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
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "45";
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
    @DisplayName("Test")
    void testPrecentage(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressUnaryOperationKey("%");

        String expected = "2.5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test")
    void testabstraction(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);

        calc.pressUnaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test")
    void testabstractionnegative(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(-2);
        calc.pressUnaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-1";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}

