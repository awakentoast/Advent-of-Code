package main;

public class DuelingGenerators {
    public static void main(String[] args) {
        String[] input = {  "Generator A starts with 873", "Generator B starts with 583"};
        Generator generatorA = new Generator(16807, 873);
        Generator generatorB = new Generator(48271, 583);
        Judge1 judge1 = new Judge1();
        int part1 = judge1.solve(generatorA, generatorB);
        System.out.println("Part 1: " + part1);

        generatorA = new Generator(16807, 873);
        generatorB = new Generator(48271, 583);
        Judge2 judge2 = new Judge2();
        int part2 = judge2.solve(generatorA, generatorB);
        System.out.println("Part 2: " + part2);

    }
}