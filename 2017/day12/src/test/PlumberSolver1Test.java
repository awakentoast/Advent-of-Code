package test;

import main.PlumberSolver1;
import main.PlumberSolver2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlumberSolver1Test {

    PlumberSolver1 plumberSolver1 = new PlumberSolver1();
    PlumberSolver2 plumberSolver2 = new PlumberSolver2();

    Map<Integer, Set<Integer>> programs = new HashMap<>();

    @BeforeEach
    public void init() {
        Set<Integer> set = new HashSet<>();
        programs.put(0, new HashSet<>(List.of(2)));
        programs.put(1, new HashSet<>(List.of(1)));
        programs.put(2, new HashSet<>(List.of(0, 3, 4)));
        programs.put(3, new HashSet<>(List.of(2, 4)));
        programs.put(4, new HashSet<>(List.of(2, 3, 6)));
        programs.put(5, new HashSet<>(List.of(6)));
        programs.put(6, new HashSet<>(List.of(4, 5)));
    }


    @Test
    public void part1() {
        plumberSolver1.solve(programs);
    }

    @Test
    public void part2() {
        int result = 2;
        assertEquals(result, plumberSolver2.solve(programs));
    }
}
