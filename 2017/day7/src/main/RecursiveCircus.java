package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecursiveCircus {
    public static void main(String[] args) {
        String inputString = readInput();
        List<Node> input = makeTree(inputString);

        TowerSolverPart1 towerSolverPart1 = new TowerSolverPart1();
        String part1 = towerSolverPart1.solve(input);
        System.out.println("Part 1: " + part1);

        TowerSolverPart2 towerSolverPart2 = new TowerSolverPart2();
        int part2 = towerSolverPart2.solve(input);
        System.out.println("Part 2: " + part2);
    }

    private static List<Node> makeTree(String inputString) {
        String[] inputs = inputString.split("\n");

        List<Node> nodes = new ArrayList<>();
        for (String input : inputs) {
            Tower tower = new Tower(input);
            Node node = new Node(tower);
            nodes.add(node);
        }

        for (String input : inputs) {
            if (input.contains("->")) {
                String[] inputParts = input.split("->");
                String name = inputParts[0].split(" ")[0];
                Node parentNode = Node.getNodeTowerByName(name, nodes);

                String[] childrenStrings = inputParts[1].split(", ");

                for (String childTowerString : childrenStrings) {
                    Node childTower = Node.getNodeTowerByName(childTowerString.strip(), nodes);
                    parentNode.addChild(childTower);
                }
            }
        }

        return nodes;
    }

    private static String readInput() {
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