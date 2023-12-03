package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PacketScanners {
    public static void main(String[] args) {
        String input = readInput();
        List<Layer> layers = parseInput(input);
        List<Layer> layers2 = parseInput(input);

        Packet1 p1 = new Packet1();
        int part1 = p1.solve(layers);
        System.out.println("Part 1: " + part1);

        Packet2 p2 = new Packet2();
        int part2 = p2.solve(layers2);
        System.out.println("Part 2: " + part2);
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    private static List<Layer> parseInput(String input) {
        String[] layerStrings = input.split("\n");
        List<Layer> layers = new ArrayList<>(layerStrings.length);

        int range;
        int depth;
        int previousRange = 0;
        for (String layerString : layerStrings) {
            String[] layersValues = layerString.split(": ");
            depth = Integer.parseInt(layersValues[0]);

            //fills the depths which are not in input
            if (depth - 1 > previousRange) {
                for (int i = previousRange + 1; i < depth; i++) {
                    layers.add(new Layer(i, 0));
                }
            }
            previousRange = depth;

            range = Integer.parseInt(layersValues[1]);
            layers.add(new Layer(depth, range));
        }

        System.out.println(layers);
        return layers;
    }
}

