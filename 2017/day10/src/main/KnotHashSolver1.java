package main;

public class KnotHashSolver1 {
    public int solve(int[] steps, int[] knots) {
        int index = 0;
        int skipSize = 0;

        for (int step : steps) {
            knots = performTwist(knots, index, step);
            index += step + skipSize++;
        }

        return knots[0] * knots[1];
    }

    public int[] performTwist(int[] array, int startIndex, int steps) {
        int[] arrayToBeReversed = getSubArrayThatCanWrap(array, startIndex, steps);
        int[] reversedSubArray = reverseArray(arrayToBeReversed);
        int[] reversedArray = combineSubAndOriginalArray(array, reversedSubArray, startIndex, steps);

        return reversedArray;
    }

    public int[] combineSubAndOriginalArray(int[] array, int[] reversedSubArray, int startIndex, int steps) {
        int[] combinedArray = new int[array.length];

        for (int i = 0; i < reversedSubArray.length; i++) {
            int newIndex = (startIndex + i) % array.length;
            combinedArray[newIndex] = reversedSubArray[i];
        }

        for (int i = 0; i < array.length - reversedSubArray.length; i++) {
            int newIndex = (startIndex + steps + i) % array.length;
            combinedArray[newIndex] = array[newIndex];
        }

        return combinedArray;
    }

    public int[] getSubArrayThatCanWrap(int[] values, int startIndex, int steps) {
        int[] subArray = new int[steps];

        for (int i = 0; i < steps; i++) {
            int index = (startIndex + i) % values.length;
            subArray[i] = values[index];
        }

        return subArray;
    }



    public int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[array.length - i - 1] = array[i];
        }
        return reversedArray;
    }
}
