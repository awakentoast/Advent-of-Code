package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Trebuchet {
    public static void main(String[] args) {
        String input = readFile();
        String[] lines = input.split("%n");

        TrebuchetInstructionFixerPart1 trebuchetInstructionFixerPart1 = new TrebuchetInstructionFixerPart1();
        int part1 = trebuchetInstructionFixerPart1.solve(lines);
        System.out.println("Part 1: " + part1);

        TrebuchetInstructionFixerPart2 trebuchetInstructionFixerPart2 = new TrebuchetInstructionFixerPart2();
        int part2 = trebuchetInstructionFixerPart2.solve(lines);
        System.out.println("Part 2: " + part2);
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