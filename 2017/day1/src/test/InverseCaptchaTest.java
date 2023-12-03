package test;

import main.InverseCaptchaSolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class InverseCaptchaTest {

    private final InverseCaptchaSolver inverseCaptchaSolver = new InverseCaptchaSolver();

    @Test
    void performGoodPart1() {
        int expectedResult = 3;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart1("1122"));

        expectedResult = 4;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart1("1111"));

        expectedResult = 0;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart1("1234"));

        expectedResult = 9;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart1("91212129"));
    }

    @Test
    void performGoodPart2() {
        int expectedResult = 6;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart2("1212"));

        expectedResult = 0;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart2("1221"));

        expectedResult = 4;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart2("123425"));

        expectedResult = 12;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart2("123123"));

        expectedResult = 4;
        assertEquals(expectedResult, inverseCaptchaSolver.captchaSolverPart2("12131415"));
    }
}
