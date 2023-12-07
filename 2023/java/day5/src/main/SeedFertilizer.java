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
        List<List<List<Long>>> maps = parseInput(input);

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

    private static List<List<List<Long>>> parseInput(String input) {
        String[] inputs = input.split("%n%n");
        List<List<List<Long>>> maps = new ArrayList<>();

        List<Long> seeds = Arrays.stream(inputs[0].split(": ")[1].split(" ")).mapToLong(Long::parseLong).boxed().toList();
        maps.add(List.of(seeds));

        for (int i = 1; i < inputs.length; i++) {
            List<List<Long>> list = new ArrayList<>();
            String[] lines = inputs[i].split("%n");

            for (int j = 1; j < lines.length; j++) {
                list.add(Arrays.stream(lines[j].split(" ")).mapToLong(Long::parseLong).boxed().toList());
            }
            maps.add(list);
        }
        return maps;
    }
}