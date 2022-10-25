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

    //Green Test
    @Test
    @DisplayName("only registers one dot for a number, even if dot is entered multiple time in a row")
    void testPressDotMultipleTimes(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDotKey();
        calc.pressDotKey();
        calc.pressDotKey();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "5.3";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("negative Key should turn a positive Value negative and vice versa")
    void testNegatveKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();
        calc.pressNegativeKey();
        String expected = "2";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

//Red Tests
    @Test
    @DisplayName("'='-Key should be able to start operations multiple times in a row")
    void testMultipleEqualsOperations(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        calc.pressEqualsKey();
        String expected = "8";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
        //bei mehrfachem drücken der '=' Taste nach einer Rechenoperation, wird fälschlicherweise der erste Wert mehrfach angewendet und nicht wie vorgesehen, der Zweite.
    }
    @Test
    @DisplayName("calculating the correckt result, if the first entered value is negative")

    void testNegativeStartingValue(){

        Calculator calc = new Calculator();

        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "1";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
        //ignoriert vorgestelltes Minus vor dem ersten Wert
    }

    //was Red, but is fixed now:
    @Test
    @DisplayName("root of a negative value should return 'Error'")
    void testNegativeRoot(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(9);
        calc.pressEqualsKey();
        calc.pressUnaryOperationKey("√");
        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
        // was giving 'NaN' instead of 'Error' => is fixed now
    }

    @Test
    @DisplayName("should check if C / clear function only cleares the last pressed key")
    void testClearKey(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressClearKey();
        calc.pressDigitKey(1);
        calc.pressEqualsKey();

        String expected = "6";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
        //Vorher: zwischengespeicherte Werte werden nicht beibehalten, sondern immer auch sofort gelöscht
        //=> nun werden latestOperation & latestValue nur noch gelöscht, wenn screen vorher schon mittelts drücken der Clear Taste auf 0 gesetzt wurde
    }

    @Test
    @DisplayName("should display Error after dividing by the number zero")
    void testDivisionByZero(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
        //Vorher: bei geteilt durch 0 wird nicht mit "ERROR" behandelt und es wird "Infinity" angezeigt
        // => wurde behoben
    }
}

