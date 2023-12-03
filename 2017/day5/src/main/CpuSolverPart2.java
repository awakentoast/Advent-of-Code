package main;


public class CpuSolverPart2 {

    int[] instructions = new int[0];

    public int solve(int[] instructions) {
        int steps = 0;
        this.instructions = instructions;
        int nextIndex = 0;

        while (nextIndex < instructions.length) {
            nextIndex = performStep(nextIndex);
            steps++;
        }

        return steps;
    }

    public int performStep(int index) {
        int nextIndex = index + instructions[index];

        int jumpDistance = instructions[index];
        if (jumpDistance >= 3) {
            instructions[index] -= 1;
        } else {
            instructions[index] += 1;
        }

        return nextIndex;
    }
}
