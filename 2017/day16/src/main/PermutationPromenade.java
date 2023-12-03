package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class PermutationPromenade {
    public static void main(String[] args) {
        String input = readInput();
        int[][] instructions = parseInput(input);


        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};

        Dance1 dance1 = new Dance1();
        chars = dance1.solve(instructions, chars);

        StringBuilder part1 = new StringBuilder();
        for (char c : chars) {
            part1.append(c);
        }
        System.out.println("Part 1: " + part1);

        Dance2 dance2 = new Dance2();
        chars = dance2.solve(instructions, chars);

        StringBuilder part2 = new StringBuilder();
        for (char c : chars) {
            part2.append(c);
        }
        System.out.println("Part 2: " + part2);

    }

    private static String readInput() {
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader =  new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static int[][] parseInput(String input) {
        String[] strings = input.split(",");

        int[][] ints = new int[strings.length][3];

        int index = 0;
        for (String instruction : strings) {
            int[] values = new int[3];
            char a = instruction.charAt(0);

            if (a == 's') {
                values[1] = Integer.parseInt(instruction.substring(1));
            } else {
                if (a == 'x') {
                    String[] value = instruction.substring(1).split("/");
                    values[0] = 1;
                    values[1] = Integer.parseInt(value[0]);
                    values[2] = Integer.parseInt(value[1]);
                } else {
                    values[0] = 2;
                    values[1] = instruction.charAt(1);
                    values[2] = instruction.charAt(3);
                }
            }

            ints[index++] = values;
        }

        return ints;
    }
}