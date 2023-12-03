package test;

import main.SpiralSolverPart2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpiralSolverPart2Test {

    SpiralSolverPart2 spiralSolverPart2 = new SpiralSolverPart2();

    @Test
    public void part2() {
        int result = 54;
        assertEquals(result, spiralSolverPart2.solve(50));

        result = 57;
        assertEquals(result, spiralSolverPart2.solve(54));

        result = 54;
        assertEquals(result, spiralSolverPart2.solve(11));
    }
}
