package test;

import main.PassPhraseSolverPart1;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassPhraseSolverPart1Test {

    PassPhraseSolverPart1 passPhraseSolverPart1 = new PassPhraseSolverPart1();

    @Test
    public void part1() {
        int result = 1;
        String[] passphrase = {"aa bb cc dd ee"};
        assertEquals(result, passPhraseSolverPart1.solve(passphrase));

        result = 0;
        passphrase = new String[]{"aa bb cc dd aa"};
        assertEquals(result, passPhraseSolverPart1.solve(passphrase));

        result = 1;
        passphrase = new String[]{"aa bb cc dd aaa"};
        assertEquals(result, passPhraseSolverPart1.solve(passphrase));
    }
}
