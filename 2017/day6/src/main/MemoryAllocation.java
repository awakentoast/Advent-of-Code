package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class MemoryAllocation {

    public static void main(String[] args) {
        String input = readInput();
        int[] numbers = parseInput(input);

        MemorySolverPart1 memorySolverPart1 = new MemorySolverPart1();
        int part1 = memorySolverPart1.solve(numbers.clone());
        System.out.println("Part 1: " + part1);

        MemorySolverPart2 memorySolverPart2 = new MemorySolverPart2();
        int part2 = memorySolverPart2.solve(numbers);
        System.out.println("Part 2: " + part2);
    }

    private static String readInput() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static int[] parseInput(String input) {
        String[] numbers = input.split("\\s+");
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
    }

}