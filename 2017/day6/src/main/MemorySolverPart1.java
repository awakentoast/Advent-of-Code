package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemorySolverPart1 {

    List<int[]> banksCache = new ArrayList<>();

    public int solve(int[] banks) {
        System.out.println(Arrays.toString(banks));
        int cycles = 0;

        int max = getMax(banks);
        int bank = bankOfMax(max, banks);

        while (true) {
            cycles++;

            blockRedistribution(bank, banks);
            System.out.println(Arrays.toString(banks));

            for (int[] banksCheck : banksCache) {
                if (Arrays.equals(banksCheck, banks)) {
                    System.out.println();
                    System.out.println(Arrays.toString(banks));
                    System.out.println(Arrays.toString(banksCheck));
                    return cycles;
                }
            }

            banksCache.add(banks.clone());
            max = getMax(banks);
            bank = bankOfMax(max, banks);
        }
    }

    private void blockRedistribution(int bank, int[] banks) {
        int blocks = banks[bank];
        banks[bank] = 0;
        for (int i = 0; i < blocks; i++) {
            banks[(bank + 1 + i) % banks.length]++;
        }
    }

    private int getMax(int[] banks) {
        return Arrays.stream(banks).max().getAsInt();
    }

    private int bankOfMax(int max, int[] banks) {
        for (int i = 0; i < banks.length; i++) {
            if (banks[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public List<int[]> getBanksCache() {
        return banksCache;
    }
}
