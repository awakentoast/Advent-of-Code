package test;

import main.SeedSolverPart1;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SeedSolverPart1Test {

    SeedSolverPart1 seedSolverPart1 = new SeedSolverPart1();
    @Test
    public void test() {
        long value = 81;
        List<Long> source = new ArrayList<>(List.of(18L, 25L, 70L));
        int result = 74;

        assertEquals(result, seedSolverPart1.getValueFromRange(value, source));
    }
}
