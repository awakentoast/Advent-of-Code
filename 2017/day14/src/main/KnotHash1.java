package main;

import java.util.Arrays;

public class KnotHash1 {
    public int solve(String input) {
        int amount = 0;
        String[] strings = new String[128];
        for (int i = 0; i < 1; i++) {
            String hash = input + "-" + i;
            strings[i] = getHexadecimals(hash);
        }

        System.out.println(Arrays.toString(strings));

        return amount;
    }

    private String getHexadecimals(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            System.out.println(a);
            if (Character.digit(a, 16) >= 0) {
                System.out.println("through");

                int num = Integer.parseInt(String.valueOf(a), 16);
                String binary = Integer.toBinaryString(num);
                String leadingZerosBinary = String.format("%4s", binary).replace(" ", "0");
                output.append(leadingZerosBinary);
                System.out.println();
            }
        }

        return output.toString();
    }
}
