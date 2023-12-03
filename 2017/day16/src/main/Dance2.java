package main;

public class Dance2 {

    Dance1 dance1 = new Dance1();

    public char[] solve(int[][] instructions, char[] chars) {
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 100_000 == 0) {
                System.out.println(i);
            }
            for (int[] instruction : instructions) {
                dance1.performAction(instruction, chars);
            }
        }

        return chars;
    }
}
