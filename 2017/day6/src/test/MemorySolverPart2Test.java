package test;

import main.MemorySolverPart2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemorySolverPart2Test {

    MemorySolverPart2 memorySolverPart1 = new MemorySolverPart2();

    @Test
    public void part2() {
        int result = 4;
        int[] banks = {0, 2, 7, 0};
        assertEquals(result, memorySolverPart1.solve(banks));
    }
}
