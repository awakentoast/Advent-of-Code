package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeedFertilizer {
    public static void main(String[] args) {
        String input = readInput();
        long[][][] maps = parseInput(input);

        long start = System.currentTimeMillis();
        SeedSolverPart1 seedSolverPart1 = new SeedSolverPart1();
        long part1 = seedSolverPart1.solve(maps);
        System.out.println("Part 1: " + part1);
        long finish = System.currentTimeMillis();
        long elapsedTime = finish - start;
        System.out.println("Elapsed time: " + elapsedTime);
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("%n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    private static long[][][] parseInput(String input) {
        String[] inputs = input.split("%n%n");
        long[][][] maps = new long[inputs.length][][];

        long[][] seeds = new long[][]{Arrays.stream(inputs[0].split(": ")[1].split(" ")).mapToLong(Long::parseLong).toArray()};
        maps[0] = seeds;

        for (int i = 1; i < inputs.length; i++) {
            String[] lines = inputs[i].split("%n");
            long[][] list = new long[lines.length - 1][];

            for (int j = 1; j < lines.length; j++) {
                list[j - 1] = Arrays.stream(lines[j].split(" ")).mapToLong(Long::parseLong).toArray();
            }
            maps[i] = list;
        }
        return maps;
    }
}