package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GearRatios {
    public static void main(String[] args) {
        String input = readFile();
        char[][] array = parseInput(input);

        EngineFixerPart1 engineFixerPart1 = new EngineFixerPart1();
        int part1 = engineFixerPart1.solve(array);
        System.out.println("Part 1: " + part1);

        EngineFixerPart2 engineFixerPart2 = new EngineFixerPart2();
        int part2 = engineFixerPart2.solve(array);
        System.out.println("Part 2: " + part2);
    }

    private static char[][] parseInput(String input) {
        String[] lines = input.split("%n");
        char[][] array = new char[lines.length][lines[0].length()];

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[0].length(); x++) {
                array[y][x] = lines[y].charAt(x);
            }
        }

        return array;
    }

    private static String readFile() {
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
}