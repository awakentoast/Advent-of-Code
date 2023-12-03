package test;

import main.KnotHashSolver1;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnotHashSolver1Test {

    KnotHashSolver1 knotHashSolver1 = new KnotHashSolver1();


    @Test
    public void getSubArrayThatCanWrap() {
        int[] test = {0, 1, 2, 3, 4};
        int[] result = {0,1,2};
        test = knotHashSolver1.getSubArrayThatCanWrap(test, 0, 3);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);

        test = new int[]{2, 1, 0, 3, 4};
        result = new int[]{3, 4, 2, 1};
        test = knotHashSolver1.getSubArrayThatCanWrap(test, 3, 4);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);

        test = new int[]{4, 3, 0, 1, 2};
        result = new int[]{3};
        test = knotHashSolver1.getSubArrayThatCanWrap(test, 1, 1);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);

        test = new int[]{4, 3, 0, 1, 2};
        result = new int[]{3, 0, 1, 2, 4};
        test = knotHashSolver1.getSubArrayThatCanWrap(test, 1, 5);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);
    }

    @Test
    public void reverseArray() {
        int[] test = {0, 1, 2};
        int[] result = {2, 1, 0};
        test = knotHashSolver1.reverseArray(test);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);

        test = new int[]{1};
        result = new int[]{1};
        test = knotHashSolver1.reverseArray(test);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);
    }

    @Test
    public void combineSubAndOriginalArray() {
        int[] test = {0, 1, 2, 3, 4};
        int[] reversedSubArrayTest = {2, 1, 0};
        int[] result = {2, 1, 0, 3, 4};
        int startIndex = 0;
        int steps = 3;
        test = knotHashSolver1.combineSubAndOriginalArray(test, reversedSubArrayTest, startIndex, steps);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);

        test = result;
        reversedSubArrayTest = new int[]{1, 2, 4, 3};
        result = new int[]{4, 3, 0, 1, 2};
        startIndex = 3;
        steps = 4;
        test = knotHashSolver1.combineSubAndOriginalArray(test, reversedSubArrayTest, startIndex, steps);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(result, test);
    }
}
