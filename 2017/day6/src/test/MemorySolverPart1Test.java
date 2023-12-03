package test;

import main.MemorySolverPart1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemorySolverPart1Test {

    MemorySolverPart1 memorySolverPart1 = new MemorySolverPart1();

    @Test
    public void part1() {
        int result = 5;
        int[] banks = {0, 2, 7, 0};
        assertEquals(result, memorySolverPart1.solve(banks));
    }
}
