package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
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
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    void testPositiveMultiply(){
        var calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(1);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "100";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    void testClear(){
        var calc = new Calculator();
        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(9);
        calc.pressClearKey();
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    void testDotsInDecimalNumber(){
        var calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressDotKey();
        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);

        String expected = "3.255";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

