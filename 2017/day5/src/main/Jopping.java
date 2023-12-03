package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Jopping {
    public static void main(String[] args) {
        String inputString = readInput();
       int[] input = parseInput(inputString);

        CpuSolverPart1 cpuSolverPart1 = new CpuSolverPart1();
        int part1 = cpuSolverPart1.solve(input.clone());
        System.out.println("Part 1: " + part1);

        CpuSolverPart2 cpuSolverPart2 = new CpuSolverPart2();
        int part2 = cpuSolverPart2.solve(input);
        System.out.println("Part 2: " + part2);
    }

    private static String readInput() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private static int[] parseInput(String input) {
        String[] inputList = input.split("\n");


        return Stream.of(inputList).mapToInt(Integer::parseInt).toArray();
    }
}
