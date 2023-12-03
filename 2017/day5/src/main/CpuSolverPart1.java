package main;

import java.util.Arrays;

public class CpuSolverPart1 {

    int[] instructions = new int[0];

    public int solve(int[] instructions) {
        int steps = 0;
        this.instructions = instructions;
        System.out.println(Arrays.toString(instructions));

        int nextIndex = 0;

        while (nextIndex < instructions.length) {
            nextIndex = performStep(nextIndex);
            steps++;
        }

        return steps;
    }

    public int performStep(int index) {
        int nextIndex = index + instructions[index];
        instructions[index] += 1;

        return nextIndex;
    }
}
