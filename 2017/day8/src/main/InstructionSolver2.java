package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class InstructionSolver2 {

    InstructionSolver1 instructionSolver1 = new InstructionSolver1();
    public int solve(List<Instruction> instructions, Map<String, Integer> registerMap) {
        List<Integer> register = new ArrayList<>(Collections.nCopies(registerMap.size(), 0));

        int max = 0;
        for (Instruction instruction : instructions) {
            instructionSolver1.performAction(register, registerMap, instruction);
            int tempMax = register.stream().max(Integer::compareTo).get();
            if ( tempMax> max) {
                max = tempMax;
            }
        }

        return max;
    }
}
