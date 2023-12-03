package main;

public class SpiralSolverPart1 {

    public int solve(int value) {
        int stepsToLine = calculateStepsFromAxis(value);
        int stepsOnLine = calculateStepsOnAxis(value, stepsToLine);

        return stepsToLine + stepsOnLine;
    }

    public int calculateStepsOnAxis(int value, int stepsToLine) {
        if (value == 1) {
            return 0;
        }
        int interval = stepsToLine * 2 + 1;

        int bottomRightValue = (interval) * (interval);

        //loop trough bottom, left, top, right
        for (int i = 0; i < 4; i++) {
            if (value <= bottomRightValue - i * interval + i && value >= bottomRightValue - (i + 1) * interval + (i + 1)) {
                int middle = bottomRightValue - i * interval + i - interval / 2;
                return Math.abs(value - middle);
            }
        }

        return -1;
    }

    public int calculateStepsFromAxis(int value) {
        if (value == 1) {
            return 0;
        }
        int upperBound = (int) Math.sqrt(value) + 1;

        int steps = 0;
        for (int i = 1; i < upperBound; i += 2) {
            steps++;
            if (value >= i * i && value <= (i + 2) * (i + 2)) {
                return steps;
            }
        }

        return -1;
    }
}
