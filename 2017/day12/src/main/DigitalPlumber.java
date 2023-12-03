package main;

import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class DigitalPlumber {
    public static void main(String[] args) {
        String inputData = readFile();
        Map<Integer, Set<Integer>> programs = parseInput(inputData);

        PlumberSolver1 plumberSolver1 = new PlumberSolver1();
        int part1 = plumberSolver1.solve(programs);
        System.out.println("Part 1: " + part1);

        PlumberSolver2 plumberSolver2 = new PlumberSolver2();
        int part2 = plumberSolver2.solve(programs);
        System.out.println("Part 2: " + part2);

    }

    private static Map<Integer, Set<Integer>> parseInput(String inputData) {
        Map<Integer, Set<Integer>> map = new TreeMap<>();

        for (String program : inputData.split("\n")) {
            String[] programSplit = program.split(" <-> ");
            int id = Integer.parseInt(programSplit[0]);
            Set<Integer> integers = Arrays.stream(programSplit[1].split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
            map.put(id, integers);
        }
        return map;
    }

    private static String readFile() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}