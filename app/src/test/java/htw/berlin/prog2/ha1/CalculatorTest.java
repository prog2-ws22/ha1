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
    @DisplayName("should display result after subtracting a number from another number")
    void testSubstraction() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "10";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should only display one Dot")
    void testOneDotOnScreen() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();

        String expected = "2.2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("should clear the screen first, if latestvalue is not zero")
    void testClearScreenIfValueStored() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressDigitKey(0);
        calc.pressClearKey();
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "200";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    /** Not implemented yet
     * @Test
     @DisplayName("should switch between positive and negative")
     void testPositiveNegative() {
     Calculator calc = new Calculator();

     calc.pressDigitKey(1);
     calc.pressDigitKey(0);
     calc.pressBinaryOperationKey("x");
     calc.pressDigitKey(1);
     calc.pressDigitKey(0);
     calc.pressEqualsKey();
     calc.pressNegativeKey();


     String expected = "-100";
     String actual = calc.readScreen();

     assertEquals(expected, actual);
     }*/

    /** Not implemented yet
     * @Test
     @DisplayName("should display result after pressing multiplier the second time")
     void testMultiplication() {
     Calculator calc = new Calculator();

     calc.pressDigitKey(1);
     calc.pressDigitKey(0);
     calc.pressBinaryOperationKey("x");
     calc.pressDigitKey(1);
     calc.pressDigitKey(0);
     calc.pressBinaryOperationKey("x");

     String expected = "100";
     String actual = calc.readScreen();

     assertEquals(expected, actual);
     }
     **/

    /** Not implemented yet
     * @Test
     @DisplayName("should add Dot and Digitkey after the initial 0")
     void testNumberAfterDot() {

     Calculator calc = new Calculator();

     calc.pressDotKey();
     calc.pressDigitKey(1);

     String expected = "0.1";
     String actual = calc.readScreen();

     assertEquals(expected, actual);
     }*/




}