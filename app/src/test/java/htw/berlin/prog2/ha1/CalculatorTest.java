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

    //Teilaufgabe 1, Test zum Subtrahieren
    @Test
    @DisplayName("sollte das Ergebnis einer Subtraktion anzeigen")
    void testSubtract() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "33";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2, Test für Kettenaufgaben bei denen Punkt vor Strich beachtet werden sollte
    @Test
    @DisplayName("Punkt vor Strich sollte bei einer Kettenaufgabe beachtet werden.")
    void testKettenaufgabe() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(4);
        calc.pressEqualsKey();

        String expected = "11";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2, Test für 0 als Divisor
    @Test
    @DisplayName("Error sollte als Ergebnis angezeigt werden, wenn durch 0 dividiert wird.")
    void testDivid0() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe 2, Test für Wurzel aus negativer Zahl
    @Test
    @DisplayName("Die Wurzel aus einer negativen Zahl sollte Error auswerfen")
    void testSqrtNegative(){
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}

