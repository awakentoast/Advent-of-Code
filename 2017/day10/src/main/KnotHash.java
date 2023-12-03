package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class KnotHash {
    public static void main(String[] args) {
        String input = readFile();
        int[] steps = parseInputPart1(input);

        KnotHashSolver1 knotHashSolver1 = new KnotHashSolver1();
        int[] knots = IntStream.range(0, 256).toArray();
        int part1 = knotHashSolver1.solve(steps, knots);
        System.out.println("Part 1: " + part1);

        KnotHashSolver2 knotHashSolver2 = new KnotHashSolver2();
        steps = parseInputPart2(input);
        System.out.println(Arrays.toString(steps));
        String part2 = knotHashSolver2.solve(steps, knots);
        System.out.println("Part 2: " + part2);
        System.out.println(part2.length());
    }

    private static String readFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private static int[] parseInputPart1(String input) {
        String[] valueStrings = input.split(",");
        System.out.println(Arrays.toString(valueStrings));

        return Arrays.stream(valueStrings).mapToInt(Integer::parseInt).toArray();
    }

    private static int[] parseInputPart2(String input) {
        int[] valuesToManuallyAdd = {17, 31, 73, 47, 23};
        int[] values = new int[input.length() + valuesToManuallyAdd.length];

        for (int i = 0; i < input.length(); i++) {
            values[i] = input.charAt(i);
        }

        System.arraycopy(valuesToManuallyAdd, 0, values, input.length(), valuesToManuallyAdd.length);
        return values;
    }
}