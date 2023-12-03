package test;

import main.SpreadsheetSolver;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChecksumTest {

    SpreadsheetSolver spreadsheetSolver = new SpreadsheetSolver();

    @Test
    public void worksPart1() {
        List<List<Integer>> test = List.of(
                List.of(5, 1, 9, 5)
        );
        int expectedResult = 8;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart1(test));

        test = List.of(
                List.of(7, 5, 3)
        );
        expectedResult = 4;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart1(test));

        test = List.of(
                List.of(2, 4, 6, 8)
        );
        expectedResult = 6;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart1(test));

        test = List.of(
                List.of(5, 1, 9, 5),
                List.of(7, 5, 3),
                List.of(2, 4, 6, 8)
        );
        expectedResult = 18;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart1(test));
    }

    @Test
    public void worksPart2() {
        List<List<Integer>> test = List.of(
                List.of(5, 9, 2, 8)
        );
        int expectedResult = 4;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart2(test));

        test = List.of(
                List.of(9, 4, 7, 3)
        );
        expectedResult = 3;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart2(test));

        test = List.of(
                List.of(3, 8, 6, 5)
        );
        expectedResult = 2;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart2(test));

        test = List.of(
                List.of(5, 9,2,8),
                List.of(9,4,7,3),
                List.of(3,8,6,5)
        );
        expectedResult = 9;
        assertEquals(expectedResult, spreadsheetSolver.checksumPart2(test));
    }


}
