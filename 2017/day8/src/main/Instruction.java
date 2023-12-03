package main;

public class Instruction {
    private String targetIndex;
    private String mathAction;
    private int amountOfMathAction;
    private String evalIndex;
    private String evalAction;
    private int compareTo;

    public Instruction(String targetIndex, String mathAction, int amountOfMathAction, String evalIndex, String evalAction, int compareTo) {
        this.targetIndex = targetIndex;
        this.mathAction = mathAction;
        this.amountOfMathAction = amountOfMathAction;
        this.evalIndex = evalIndex;
        this.evalAction = evalAction;
        this.compareTo = compareTo;
    }


    public String getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(String targetIndex) {
        this.targetIndex = targetIndex;
    }

    public String getMathAction() {
        return mathAction;
    }

    public void setMathAction(String mathAction) {
        this.mathAction = mathAction;
    }

    public int getAmountOfMathAction() {
        return amountOfMathAction;
    }

    public void setAmountOfMathAction(int amountOfMathAction) {
        this.amountOfMathAction = amountOfMathAction;
    }

    public String getEvalIndex() {
        return evalIndex;
    }

    public void setEvalIndex(String evalIndex) {
        this.evalIndex = evalIndex;
    }

    public String getEvalAction() {
        return evalAction;
    }

    public void setEvalAction(String evalAction) {
        this.evalAction = evalAction;
    }

    public int getCompareTo() {
        return compareTo;
    }

    public void setCompareTo(int compareTo) {
        this.compareTo = compareTo;
    }


}
