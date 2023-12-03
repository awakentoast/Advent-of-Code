package main;

import java.util.Arrays;

public class KnotHashSolver2 {
    KnotHashSolver1 knotHashSolver1 = new KnotHashSolver1();

    public String solve(int[] steps, int[] knots) {
        int index = 0;
        int skipSize = 0;
        for (int i = 0; i < 64; i++) {
            for (int step : steps) {
                knots = knotHashSolver1.performTwist(knots, index, step);
                index += step + skipSize++;
            }
        }

        int[] denseHash = createDenseHash(knots);

        return knotHashToHexadecimal(denseHash);
    }

    private int[] createDenseHash(int[] knots) {
        int[] knotHash = new int[16];

        for (int i = 0; i < 16; i++) {
            int[] block = Arrays.copyOfRange(knots, i * 16, (i + 1) * 16);
            knotHash[i] = performXor(block);
        }

        return knotHash;
    }

    private int performXor(int[] block) {
        int value = block[0];
        for (int i = 1; i < block.length; i++) {
            value = value ^ block[i];
        }

        return value;
    }

    public String knotHashToHexadecimal(int[] knotHash) {
        StringBuilder hexadecimalString = new StringBuilder();

        for (int hash : knotHash) {
            String hexadecimal = String.format("%02x", hash);
            hexadecimalString.append(hexadecimal);
        }

        return hexadecimalString.toString();
    }
}
