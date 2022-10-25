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
    @DisplayName("should display result after subtract two positive multi-digit numbers")
    void testMinus() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "0";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after multiply two positive multi-digit numbers")
    void testMultiplication(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        String expected = "6";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("should display result after divide two positive multi-digit numbers")
    void testDivision(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        String expected = "2";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result 20% from 48")
    void testPercent(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressDigitKey(8);
        calc.pressUnaryOperationKey("%");
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();
        String expected = "9.6";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Divion with 0")
    void testClearAll(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("Clear screen")
    void testClearDisplay(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressDigitKey(2);
        calc.pressClearKey();
        calc.pressDigitKey(4);
        calc.pressEqualsKey();
        String expected = "100";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

}

