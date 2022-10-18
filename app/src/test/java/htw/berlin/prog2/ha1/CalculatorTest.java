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


    // GREEN TEST
    @Test
    @DisplayName("should display result after adding a positive number to a result")

    void testAddAfterDisplayingResult(){

        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        String expected = "10";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }
    // RED TEST
    @Test
    @DisplayName("should display result after multiplying a negative number and a positive number")

    void testMultiplyNegativeNumber(){

        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "-4";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }
    //RED TEST
    @Test
    @DisplayName("should display result after adding a negative and a positive number")

    void testAddNegativeNumber(){

    Calculator calc = new Calculator();

    calc.pressBinaryOperationKey("-");
    calc.pressDigitKey(4);
    calc.pressBinaryOperationKey("+");
    calc.pressDigitKey(7);
    calc.pressEqualsKey();

    String expected = "3";
    String actual = calc.readScreen();
    assertEquals(expected, actual);

    }


    //TODO hier weitere Tests erstellen
}

