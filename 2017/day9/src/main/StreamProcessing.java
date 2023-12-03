package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class StreamProcessing {
    public static void main(String[] args) {
        String input = readInput();

        StreamSolver1 solver = new StreamSolver1();
        int part1 = solver.solve(input);
        System.out.println("Part 1: " + part1);
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}