package main;

import java.util.Arrays;

public class CubeSolverPart1 {
    public int solve(Game[] games) {
        return Arrays.stream(games)
                .filter(Game::isRedOverMax)
                .filter(Game::isGreenOverMax)
                .filter(Game::isBlueOverMax)
                .map(Game::getId)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
