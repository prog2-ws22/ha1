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
    @DisplayName("should display result after multiplying two positive numbers")
    void testMultiplikation(){
    Calculator calc = new Calculator();

    calc.pressDigitKey(9);
    calc.pressBinaryOperationKey("x");
    calc.pressDigitKey(5);
    calc.pressEqualsKey();

    String expected = "45";
    String actual = calc.readScreen();

    assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should display result after clearing the screen during Calculation")
    void testClearingDuringCalculation(){
    Calculator calc = new Calculator();

    calc.pressDigitKey(1);
    calc.pressBinaryOperationKey("+");
    calc.pressDigitKey(1);
    calc.pressClearKey();
    calc.pressDigitKey(2);
    calc.pressEqualsKey();


    String expected = "3";
    String actual = calc.readScreen();

    assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display 'ERROR' after dividing by 0")
    void testDividingByZero(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "ERROR";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }

}

