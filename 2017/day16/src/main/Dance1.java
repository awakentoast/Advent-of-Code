package main;

public class Dance1 {

    public char[] solve(int[][] instructions, char[] chars) {
        for (int[] instruction : instructions) {
            chars = performAction(instruction, chars);
        }

        return chars;
    }

    public char[] performAction(int[] instruction, char[] chars) {
        switch (instruction[0]) {
            case 0 -> {
                int length = chars.length;
                int amount = instruction[1];

                char[] temp = new char[length];
                System.arraycopy(chars, 0, temp, amount, length - amount);
                System.arraycopy(chars, length - amount, temp, 0, amount);
                return temp;
            }

            case 1 -> {
                int pos1 = instruction[1];
                int pos2 = instruction[2];

                char temp = chars[pos1];
                chars[pos1] = chars[pos2];
                chars[pos2] = temp;
            }

            case 2 -> {
                int a = instruction[1];
                int b = instruction[2];
                int pos1 = 0;
                int pos2 = 0;

                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == a) {
                        pos1 = i;
                    } else if (chars[i] == b) {
                        pos2 = i;
                    }
                }

                char temp = chars[pos1];
                chars[pos1] = chars[pos2];
                chars[pos2] = temp;
            }
        }

        return chars;
    }
}
