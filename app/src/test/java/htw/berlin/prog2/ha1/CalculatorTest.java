package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display Error after dividing by 0")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();



        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

     }

        /*

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");
        calc.pressClearKey();

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

         */

   /*
   @Test
    @DisplayName("should display result after getting the percental of two")
    void testpercental() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("%");

        String expected = "0.02";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    */










    //TODO hier weitere Tests erstellen

}

