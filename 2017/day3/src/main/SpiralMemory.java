package main;

public class SpiralMemory {

    public static void main(String[] args) {
        SpiralSolverPart1 spiralSolverPart1 = new SpiralSolverPart1();
        int result = spiralSolverPart1.solve(312051);
        System.out.println("Part 1 " + result);

        SpiralSolverPart2 spiralSolverPart2 = new SpiralSolverPart2();
        result = spiralSolverPart2.solve(312051);
        System.out.println("Part 2 " + result);

    }
}