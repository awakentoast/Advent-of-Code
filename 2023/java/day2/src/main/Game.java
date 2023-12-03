package main;

public class Game {
    public static final int MAX_RED_CUBES = 12;
    public static final int MAX_GREEN_CUBES = 13;
    public static final int MAX_BLUE_CUBES = 14;

    private int id;
    private int maxAmountOfRedCubes;
    private int maxAmountOfBlueCubes;
    private int maxAmountOfGreenCubes;

    public Game() {
        this.maxAmountOfRedCubes = 0;
        this.maxAmountOfBlueCubes = 0;
        this.maxAmountOfGreenCubes = 0;
    }

    public int productOfAllCubes() {
        return maxAmountOfRedCubes * maxAmountOfGreenCubes * maxAmountOfBlueCubes;
    }

    public boolean isRedOverMax() {
        return this.maxAmountOfRedCubes <= MAX_RED_CUBES;
    }

    public boolean isGreenOverMax() {
        return this.maxAmountOfGreenCubes <= MAX_GREEN_CUBES;
    }

    public boolean isBlueOverMax() {
        return this.maxAmountOfBlueCubes <= MAX_BLUE_CUBES;
    }


    public void setMaxAmountOfRedCubes(int maxAmountOfRedCubes) {
        this.maxAmountOfRedCubes = Math.max(maxAmountOfRedCubes, this.maxAmountOfRedCubes);
    }

    public void setMaxAmountOfBlueCubes(int maxAmountOfBlueCubes) {
        this.maxAmountOfBlueCubes = Math.max(maxAmountOfBlueCubes, this.maxAmountOfBlueCubes);
    }

    public void setMaxAmountOfGreenCubes(int maxAmountOfGreenCubes) {
        this.maxAmountOfGreenCubes = Math.max(maxAmountOfGreenCubes, this.maxAmountOfGreenCubes);
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public int getMaxAmountOfRedCubes() {
        return maxAmountOfRedCubes;
    }

    public int getMaxAmountOfBlueCubes() {
        return maxAmountOfBlueCubes;
    }

    public int getMaxAmountOfGreenCubes() {
        return maxAmountOfGreenCubes;
    }
}
