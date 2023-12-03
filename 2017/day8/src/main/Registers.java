package main;

import java.io.FileReader;
import java.util.*;

public class Registers {
    public static void main(String[] args) {
        String inputString = readFile("input.txt");
        List<Instruction> input = parseInput(inputString);
        Map<String, Integer> registerMap = makeRegisterMap(input);

        InstructionSolver1 solver = new InstructionSolver1();
        int part1 = solver.solve(input, registerMap);
        System.out.println("Part 1: " + part1);

        InstructionSolver2 solver2 = new InstructionSolver2();
        int part2 = solver2.solve(input, registerMap);
        System.out.println("Part 2: " + part2);
    }

    private static Map<String, Integer> makeRegisterMap(List<Instruction> input) {
        Map<String, Integer> register = new HashMap<>();

        int index = 0;
        for (Instruction instruction : input) {
            String targetIndex = instruction.getTargetIndex();
            if (!register.containsKey(targetIndex)) {
                System.out.println(index);

                register.put(targetIndex, index);
                index++;
            }
        }

        return register;
    }

    private static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        try(java.io.BufferedReader br = new java.io.BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static List<Instruction> parseInput(String input) {
        String[] inputStrings = input.split(System.lineSeparator());

        List<Instruction> instructions = new ArrayList<>();
        Instruction instruction;
        for (String line : inputStrings) {
            String[] values = line.split(" ");

            String targetIndex = values[0];
            String action = values[1];
            int amountOfAction = Integer.parseInt(values[2]);
            String evalIndex = values[4];
            String evalAction = values[5];
            int compareTo = Integer.parseInt(values[6]);
            instruction = new Instruction(targetIndex, action, amountOfAction, evalIndex, evalAction, compareTo);
            System.out.println(instruction);
            instructions.add(instruction);
        }

        return instructions;
    }
}