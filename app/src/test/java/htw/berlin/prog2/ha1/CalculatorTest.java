package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro Online-Calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display first value after clear entry") //Mistake clearkey deletes entire entry or shows Error
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressClearKey();
        calc.pressEqualsKey();


        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /*
    @Test
    @DisplayName("should display Error after dividing by 0") //Mistake Division 0
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();



        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

     }
     */

/*
    @Test
    @DisplayName("should display result after getting the square root of two") // direkt grün
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");
        calc.pressEqualsKey();


        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
*/


        //TODO hier weitere Tests erstellen

    }

