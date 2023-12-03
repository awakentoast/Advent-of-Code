package main;

import java.util.Arrays;

public class CubeSolverPart2 {

    public int solve(Game[] games) {
        return Arrays.stream(games)
                .map(Game::productOfAllCubes)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
