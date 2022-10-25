package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
// Zusammenarbeit mit Ägidius Hasslauer
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
    @DisplayName("should display result after dividing two positive digit numbers")
    void testDivision() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //@Test
    //@DisplayName("should display negative digit number")
    //void printNegativeNumbers() {
    //Calculator calc = new Calculator();

      //  calc.pressNegativeKey();
      //  calc.pressDigitKey(4);
      //  calc.pressEqualsKey();

       // String expected = "-4";
        // String actual = calc.readScreen();

        //assertEquals(expected, actual);
    //}

    @Test
    @DisplayName("should display an error because dividing with zero is not possible")
    void testDivisionWithZero() {
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
    @DisplayName("should display an error because of logical error")
    void testSquareRootOfNegativeNumber() {
        Calculator calc = new Calculator();

        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }

}






