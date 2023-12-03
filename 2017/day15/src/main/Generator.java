package main;

public class Generator {
    long factor;
    long value;

    public Generator(long factor, long value) {
        this.factor = factor;
        this.value = value;
    }

    public void calculateNextValue() {
        value *= factor;
        value = value % 2147483647;
    }

    public void calculateNextValuePart2(int multipleOf) {
        boolean keepGoing = true;
        while (keepGoing) {
            calculateNextValue();
            if (value % multipleOf == 0) {
                keepGoing = false;
            }
        }
    }
}
