package test;

import main.CpuSolverPart2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CpuSolverPart2Test {

    CpuSolverPart2 cpuSolverPart2 = new CpuSolverPart2();

    @Test
    public void part2() {
        int result = 10;
        int[] instructions = {0, 3, 0, 1, -3};
        assertEquals(result, cpuSolverPart2.solve(instructions));
    }
}
