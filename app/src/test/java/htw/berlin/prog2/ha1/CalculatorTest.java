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
    @Test
    @DisplayName("Sollte zwei zahlen miteinander Multiplizieren")
    void testMultiplizieren(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(8);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(8);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "6400";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("DIe Funktionen Soll Plus und mienus rechnen ")
    void TestPlusMinus() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(5);
        calc.pressDigitKey(5);
        calc.pressEqualsKey();

        String expected = "55";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Diese funktion soll die Wurzel ziehen")
    void Test(){

        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDigitKey(6);
        calc.pressUnaryOperationKey("√");

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);

    }
}

