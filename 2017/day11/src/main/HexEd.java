package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class HexEd {
    public static void main(String[] args) {
        String data = readInput();
        String[] input = parseInput(data);

        HexEdSolver1 hexEdSolver1 = new HexEdSolver1();
        int part1 = hexEdSolver1.solve(input);
        System.out.println("Part 1: " + part1);

        HexEdSolver2 hexEdSolver2 = new HexEdSolver2();
        int part2 = hexEdSolver2.solve(input);
        System.out.println("Part 2: " + part2);
    }

    private static String[] parseInput(String data) {
        return data.split(",");
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }



}