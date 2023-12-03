package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CubeConundrum {

    public static void main(String[] args) {
        String input = readFile();
        Game[] games = parseInput(input);

        CubeSolverPart1 cubeSolverPart1 = new CubeSolverPart1();
        int part1 = cubeSolverPart1.solve(games);
        System.out.println("Part 1: " + part1);

        CubeSolverPart2 cubeSolverPart2 = new CubeSolverPart2();
        int part2 = cubeSolverPart2.solve(games);
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

    private static Game[] parseInput(String input) {
        String[] lines = input.split("%n");
        Game[] games = new Game[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            Game game = new Game();

            String[] idAndTheTurns = line.split(": ");
            int id = Integer.parseInt(idAndTheTurns[0].split(" ")[1]);
            game.setId(id);

            String[] allTurns = idAndTheTurns[1].split("; ");
            for (String turn : allTurns) {
                String[] pulls = turn.split(", ");

                for (String pull : pulls) {
                    int amount = Integer.parseInt(pull.split(" ")[0]);
                    String color = pull.split(" ")[1];
                    switch (color) {
                        case "red" -> game.setMaxAmountOfRedCubes(amount);
                        case "green" -> game.setMaxAmountOfGreenCubes(amount);
                        case "blue" -> game.setMaxAmountOfBlueCubes(amount);
                        default -> System.out.println("bad");
                    }
                }
            }
            games[i] = game;
        }

        return games;
    }
}