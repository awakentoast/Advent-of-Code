package main;

import java.util.Arrays;
import java.util.List;

public class MemorySolverPart2 {

    MemorySolverPart1 memorySolverPart1 = new MemorySolverPart1();


    public int solve(int[] banks) {
        memorySolverPart1.solve(banks);
        List<int[]> banksCache = memorySolverPart1.getBanksCache();

        int count = 0;
        for (int i = banksCache.size() - 1; i >= 0; i--) {
            count += 1;
            if (Arrays.equals(banksCache.get(i), banks)) {
                return count;
            }
        }
        return -1;
    }
}
