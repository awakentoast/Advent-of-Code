package main;

import java.util.*;

public class InstructionSolver1 {

    public int solve(List<Instruction> instructions, Map<String, Integer> registerMap) {
        List<Integer> register = new ArrayList<>(Collections.nCopies(registerMap.size(), 0));

        int max = 0;
        for (Instruction instruction : instructions) {
            performAction(register, registerMap, instruction);
        }

        return register.stream().max(Integer::compareTo).get();
    }


    public void performAction(List<Integer> register, Map<String, Integer> registerMap, Instruction instruction) {
        int indexOfTarget = registerMap.get(instruction.getTargetIndex());
        int valueOfTarget = register.get(indexOfTarget);

        String action = instruction.getMathAction();
        int valueOfAction = instruction.getAmountOfMathAction();

        int evalValueIndex = registerMap.get(instruction.getEvalIndex());
        int evalValue = register.get(evalValueIndex);
        int compareTo =instruction.getCompareTo();


        switch (instruction.getEvalAction()) {
            case ">" -> {
                if (evalValue > compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            case "<" -> {
                if (evalValue < compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            case ">=" -> {
                if (evalValue >= compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            case "<=" -> {
                if (evalValue <= compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            case "==" -> {
                if (evalValue == compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            case "!=" -> {
                if (evalValue != compareTo) {
                    register.set(indexOfTarget, performMathAction(action, valueOfTarget, valueOfAction));
                }
            }
            default -> throw new IllegalArgumentException();
        }
    }

    public Integer performMathAction(String action, int target, int changeValue) {
        switch (action) {
            case "inc" -> {
                return target + changeValue;
            }
            case "dec" -> {
                return target - changeValue;
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
