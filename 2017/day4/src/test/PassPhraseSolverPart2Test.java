package test;

import main.PassPhraseSolverPart2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassPhraseSolverPart2Test {

    PassPhraseSolverPart2 passPhraseSolverPart2 = new PassPhraseSolverPart2();

    @Test
    public void part2() {
        int result = 1;
        String[] passphrase = {"abcde fghij"};
        assertEquals(result, passPhraseSolverPart2.solve(passphrase));

        result = 0;
        passphrase = new String[]{"abcde xyz ecdab"};
        assertEquals(result, passPhraseSolverPart2.solve(passphrase));

        result = 1;
        passphrase = new String[]{"a ab abc abd abf abj"};
        assertEquals(result, passPhraseSolverPart2.solve(passphrase));

        result = 1;
        passphrase = new String[]{"iiii oiii ooii oooi oooo"};
        assertEquals(result, passPhraseSolverPart2.solve(passphrase));

        result = 0;
        passphrase = new String[]{"oiii ioii iioi iiio"};
        assertEquals(result, passPhraseSolverPart2.solve(passphrase));
    }
}
