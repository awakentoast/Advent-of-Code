package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class HighEntropyPassphrase {
    public static void main(String[] args) {
        String[] input = getInput();
        PassPhraseSolverPart1 passPhraseSolverPart1 = new PassPhraseSolverPart1();
        int part1 = passPhraseSolverPart1.solve(input);
        System.out.println("Part 1: " + part1);

        PassPhraseSolverPart2 passPhraseSolverPart2 = new PassPhraseSolverPart2();
        int part2 = passPhraseSolverPart2.solve(input);
        System.out.println("Part 2: " + part2);
    }

    private static String readInput() {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    private static String[] getInput() {
        return readInput().split("\n");
    }
}