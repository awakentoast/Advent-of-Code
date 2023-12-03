package test;

import main.HexEdSolver1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HexEdSolver1Test {

    HexEdSolver1 hexEdSolver1 = new HexEdSolver1();

    @Test
    public void solve() {
        int result = 3;
        String[] directions = {"ne", "ne", "ne"};
        assertEquals(result, hexEdSolver1.solve(directions));

        result = 0;
        directions = new String[]{"ne", "ne", "sw", "sw"};
        assertEquals(result, hexEdSolver1.solve(directions));

        result = 2;
        directions = new String[]{"ne", "ne", "s", "s"};
        assertEquals(result, hexEdSolver1.solve(directions));

        result = 3;
        directions = new String[]{"se", "sw", "se", "sw", "sw"};
        assertEquals(result, hexEdSolver1.solve(directions));

        result = 3;
        directions = new String[]{"se", "sw", "se", "sw", "sw"};
        assertEquals(result, hexEdSolver1.solve(directions));
    }

    @Test
    public void problemChild() {
        int result = 10;
        int vertical = 0;
        int ascending = 0;
        int descending = -10;
        assertEquals(result, hexEdSolver1.movePointDescending(vertical, ascending, descending, hexEdSolver1.movePointVerticalAndAscending(vertical, ascending)));

        result = 5;
        vertical = 0;
        ascending = 0;
        descending = -5;
        assertEquals(result, hexEdSolver1.movePointDescending(vertical, ascending, descending, hexEdSolver1.movePointVerticalAndAscending(vertical, ascending)));

        result = 1;
        vertical = -1;
        ascending = 1;
        descending = -1;
        assertEquals(result, hexEdSolver1.movePointDescending(vertical, ascending, descending, hexEdSolver1.movePointVerticalAndAscending(vertical, ascending)));
    }


}
