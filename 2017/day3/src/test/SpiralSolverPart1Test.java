package test;

import main.SpiralSolverPart1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpiralSolverPart1Test {

    SpiralSolverPart1 spiralSolverPart1 = new SpiralSolverPart1();


    @Test
    public void part1() {
        int result = 0;
        assertEquals(result, spiralSolverPart1.solve(1));

        result = 3;
        assertEquals(result, spiralSolverPart1.solve(12));

        result = 2;
        assertEquals(result, spiralSolverPart1.solve(23));

        result = 31;
        assertEquals(result, spiralSolverPart1.solve(1024));
    }

    @Test
    public void stepsFromAxis() {
        assertEquals(0, spiralSolverPart1.calculateStepsFromAxis(1));
        assertEquals(1, spiralSolverPart1.calculateStepsFromAxis(2));
        assertEquals(1, spiralSolverPart1.calculateStepsFromAxis(9));
        assertEquals(2, spiralSolverPart1.calculateStepsFromAxis(10));
        assertEquals(2, spiralSolverPart1.calculateStepsFromAxis(25));
        assertEquals(3, spiralSolverPart1.calculateStepsFromAxis(26));
        assertEquals(3, spiralSolverPart1.calculateStepsFromAxis(49));
    }

    @Test
    public void stepsOnAxis() {
        assertEquals(1, spiralSolverPart1.calculateStepsOnAxis(10, 2));
        assertEquals(0, spiralSolverPart1.calculateStepsOnAxis(1, 0));


        assertEquals(1, spiralSolverPart1.calculateStepsOnAxis(14, 2));

        assertEquals(2, spiralSolverPart1.calculateStepsOnAxis(17, 2));

        assertEquals(2, spiralSolverPart1.calculateStepsOnAxis(21, 2));

        assertEquals(1, spiralSolverPart1.calculateStepsOnAxis(10, 2));

        assertEquals(2, spiralSolverPart1.calculateStepsOnAxis(25, 2));
    }
}
