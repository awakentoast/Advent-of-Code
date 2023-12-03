package test;

import main.CpuSolverPart1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CpuSolverPart1Test {

    CpuSolverPart1 cpuSolverPart1= new CpuSolverPart1();

    @Test
    public void part1() {
        int result = 10;
        int[] instructions = {0, 3, 0, 1, -3};
        assertEquals(result, cpuSolverPart1.solve(instructions));
    }
}
