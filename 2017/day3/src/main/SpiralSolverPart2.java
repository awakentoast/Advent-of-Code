package main;

import java.util.ArrayList;
import java.util.List;

public class SpiralSolverPart2 {

    SpiralSolverPart1 spiralSolverPart1 = new SpiralSolverPart1();

    List<Integer> spiral = new ArrayList<>();
    int cornersTurnedAll = 0;
    int stepOnLine = 0;

    public int getSpiralValue(int step) {
        return spiral.get(step - 1);
    }

    public int solve(int value) {
        cornersTurnedAll = 0;
        stepOnLine = 0;
        spiral = new ArrayList<>(List.of(1, 1, 2, 4, 5, 10, 11, 23, 25));
        int step = 9;
        int generatedValue = 25;

        while (generatedValue <= value) {
            step++;
            generatedValue = generateNextValue(step);
            spiral.add(generatedValue);
        }

        System.out.println(spiral);
        return generatedValue;
    }

    public int generateNextValue(int step) {
        int nextValue = 0;
        int layerOfSpiral = spiralSolverPart1.calculateStepsFromAxis(step);
        int lengthOfLine = layerOfSpiral * 2;
        int cornersTurned = cornersTurnedAll % 4;
        int offsetInsideStep = 9 + 2 * cornersTurnedAll;

        nextValue += getSpiralValue(step - 1); //previous value
        stepOnLine++;

        //first value of the new layer
        if (cornersTurned == 0 && stepOnLine == 1) {
            int stepOfCornerAdjacentInsideCorner = step - 8 * (layerOfSpiral - 1);
            nextValue += getSpiralValue(stepOfCornerAdjacentInsideCorner);

            return nextValue;
        }

        //second value of the new layer
        if (cornersTurned == 0 && stepOnLine == 2 || stepOnLine == 1) {
            int stepOfInsideMinusOne = step - 2;
            int stepOfInsideAdjacent = step - offsetInsideStep;
            int stepOfInsidePlusOne = step - offsetInsideStep + 1;

            nextValue += getSpiralValue(stepOfInsideMinusOne);
            nextValue += getSpiralValue(stepOfInsideAdjacent);
            nextValue += getSpiralValue(stepOfInsidePlusOne);

            return nextValue;
        }

        //second to last value on the line last corner
        if (stepOnLine == lengthOfLine - 1 && cornersTurned == 3) {
            int stepOfInsideMinusOne = step - offsetInsideStep - 1;
            int stepOfInsideAdjacent = step - offsetInsideStep;
            int stepOfInsidePlusOne = step - offsetInsideStep + 1;

            nextValue += getSpiralValue(stepOfInsideMinusOne);
            nextValue += getSpiralValue(stepOfInsideAdjacent);
            nextValue += getSpiralValue(stepOfInsidePlusOne);

            return nextValue;
        }

        //second to last value on the line
        if (stepOnLine == lengthOfLine - 1) {
            int stepOfInsideMinusOne = step - offsetInsideStep - 1;
            int stepOfInsideAdjacent = step - offsetInsideStep;

            nextValue += getSpiralValue(stepOfInsideMinusOne);
            nextValue += getSpiralValue(stepOfInsideAdjacent);

            return nextValue;
        }

        //corner of the spiral
        if (stepOnLine == lengthOfLine) {
            int cornerOffset = 10 + cornersTurnedAll * 2;
            int stepOfAdjacentInsideCorner = step - cornerOffset;
            nextValue += getSpiralValue(stepOfAdjacentInsideCorner);

            //last corner of the spiral
            if (cornersTurned == 3) {
                int stepOfAbove = step - (7 + 8 * (layerOfSpiral - 1));
                nextValue += getSpiralValue(stepOfAbove);
            }

            stepOnLine = 0;
            cornersTurnedAll += 1;

            return nextValue;
        }

        int stepOfInsideMinusOne = step - offsetInsideStep - 1;
        int stepOfInsideAdjacent = step - offsetInsideStep;
        int stepOfInsidePlusOne = step - offsetInsideStep + 1;

        nextValue += getSpiralValue(stepOfInsideMinusOne);
        nextValue += getSpiralValue(stepOfInsideAdjacent);
        nextValue += getSpiralValue(stepOfInsidePlusOne);
        return nextValue;
    }
}
