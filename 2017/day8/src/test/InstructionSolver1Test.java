package test;

import main.Instruction;
import main.InstructionSolver1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionSolver1Test {
    InstructionSolver1 instructionSolver1 = new InstructionSolver1();
    List<Instruction> instructions = new ArrayList<>();
    Map<String, Integer> registerMap = new HashMap<>(Map.ofEntries(
            entry("a", 0),
            entry("b", 1),
            entry("c", 2)
    ));

    @BeforeEach
    public void init(){
        instructions.add(new Instruction("b", "inc", 5, "a", ">", 1));
        instructions.add(new Instruction("a", "inc", 1, "b", "<", 5));
        instructions.add(new Instruction("c", "dec", -10, "a", ">=", 1));
        instructions.add(new Instruction("c", "inc", -20, "c", "==", 10));
        instructions.add(new Instruction("c", "inc", 10000, "c", "!=", 0));
        instructions.add(new Instruction("c", "inc", 10000, "c", "<=", 20000));
    }

    @Test
    public void part1() {
        int result = 1;
        assertEquals(result, instructionSolver1.solve(instructions, registerMap));
    }
}
