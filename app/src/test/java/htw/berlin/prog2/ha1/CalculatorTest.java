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
    @DisplayName("The green test. it should show the percentile of the added number")
    void testPercentage(){

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
    @DisplayName("The red Test, which has been bug fixed. it should show an Error after dividing from 0")
    void testDivision(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(5);

        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("The red Test,which has been bug fixed. it should only clear the previous value by clicking Clear Entry")
    void testCleartest(){

        Calculator calc = new Calculator();
       calc.pressDigitKey(1);
       calc.pressDigitKey(8);
       calc.pressBinaryOperationKey("+");
       calc.pressDigitKey(1);
       calc.pressDigitKey(2);
       calc.pressEqualsKey();
       calc.pressBinaryOperationKey("-");
       calc.pressDigitKey(5);
       calc.pressClearKey();
       calc.pressDigitKey(2);
       calc.pressEqualsKey();


        String expected = "28";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

}

