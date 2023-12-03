package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spreadsheet {

    public static void main(String[] args) {
        SpreadsheetSolver spreadsheetSolver = new SpreadsheetSolver();

        String inputString = readInput();
        List<List<Integer>> spreadsheet = parseInput(inputString);

        int result = spreadsheetSolver.checksumPart1(spreadsheet);
        System.out.println(result);

        result = spreadsheetSolver.checksumPart2(spreadsheet);
        System.out.println(result);
    }

    private static List<List<Integer>> parseInput(String inputString) {
        List<List<Integer>> input = new ArrayList<>();

        String[] rows = inputString.split("\n");
        for (String row : rows) {
            String[] values = row.split("\\s+");

            List<Integer> inputRow = new ArrayList<>();
            for (String value : values) {
                inputRow.add(Integer.valueOf(value));
            }
            input.add(inputRow);
        }

        return input;
    }

    private static String readInput() {
        StringBuilder inputString = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputString.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputString.toString();
    }
}