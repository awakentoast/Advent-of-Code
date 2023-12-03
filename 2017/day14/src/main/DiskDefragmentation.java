package main;

public class DiskDefragmentation {
    public static void main(String[] args) {
        String input = "jzgqcdpd";
        KnotHash1 knotHash1 = new KnotHash1();
        int part1 = knotHash1.solve(input);
        System.out.println("Part 1: " + part1);

        KnotHash2 knotHash2 = new KnotHash2();
        int part2 = knotHash2.solve(input);
        System.out.println("Part 2: " + part2);
    }
}