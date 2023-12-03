package main;

import java.io.BufferedReader;
import java.io.FileReader;

public class InverseCaptcha {

    public static void main(String[] args) {
        String input = readInput();

        InverseCaptchaSolver inverseCaptchaSolver = new InverseCaptchaSolver();
        int result = inverseCaptchaSolver.captchaSolverPart1(input);
        System.out.println("Part 1: " + result);

        result = inverseCaptchaSolver.captchaSolverPart2(input);
        System.out.println("Part 2: " + result);
    }

    public static String readInput()  {
        String input;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            input = bufferedReader.readLine();
        } catch (Exception e) {
            input = "";
            e.printStackTrace();
        }
        return input;
    }
}