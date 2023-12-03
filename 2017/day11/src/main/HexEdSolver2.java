package main;

import java.util.Arrays;

public class HexEdSolver2 {

    HexEdSolver1 hexEdSolver1 = new HexEdSolver1();

    public int solve(String[] directions) {
        int[] coordinate = {0, 0, 0};
        int maxSteps = 0;

        for (String direction : directions) {
            coordinate = hexEdSolver1.step(direction, coordinate[0], coordinate[1], coordinate[2]);
            System.out.println(Arrays.toString(coordinate));
            int layerAfterVerticalAndAscending = hexEdSolver1.movePointVerticalAndAscending(coordinate[0], coordinate[1]);
            int steps = hexEdSolver1.movePointDescending(coordinate[0], coordinate[1], coordinate[2], layerAfterVerticalAndAscending);
            if (steps > maxSteps) {
                maxSteps = steps;
            }
        }

        return maxSteps;
    }
}
