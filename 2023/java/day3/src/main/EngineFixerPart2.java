package main;

import java.util.ArrayList;
import java.util.List;

public class EngineFixerPart2 {

    EngineFixerPart1 part1 = new EngineFixerPart1();

    public int solve(char[][] array) {
        List<List<Character>> charactersOfAllPartNumbers = new ArrayList<>();
        List<List<int[]>> coordinatesOfAllPartNumbers = new ArrayList<>();
        int arrayLength = array.length;
        int lineLength = array[0].length;

        int answer = 0;

        List<int[]> coordinatesOfDigits = new ArrayList<>();
        List<Character> charactersOfNumber = new ArrayList<>();
        int x;

        for (int y = 0; y < arrayLength; y++) {
            x = 0;
            while (x < lineLength) {
                //System.out.println(x + "x" + " " + y + "y");

                while (part1.isCharacterDigitWithBoundCheck(x, y, array, arrayLength, lineLength)) {
                    coordinatesOfDigits.add(new int[]{x, y});
                    charactersOfNumber.add(array[y][x]);
                    x++;
                }

                if (part1.isPartNumber(coordinatesOfDigits, array, arrayLength, lineLength)) {
                    charactersOfAllPartNumbers.add(new ArrayList<>(charactersOfNumber));
                    coordinatesOfAllPartNumbers.add(new ArrayList<>(coordinatesOfDigits));
                }

                coordinatesOfDigits.clear();
                charactersOfNumber.clear();

                x++;
            }
        }

        for (int y = 0; y < arrayLength; y++) {
            for (x = 0; x < lineLength; x++) {
                if (array[y][x] == '*') {
                    List<List<Character>> adjacentPartNumbers = isAdjacentToThesePartNumbers(x, y, coordinatesOfAllPartNumbers, charactersOfAllPartNumbers, lineLength, arrayLength);
                    if (adjacentPartNumbers.size() == 2) {
                        int tempAnswer = part1.characterListToValue(adjacentPartNumbers.get(0));
                        tempAnswer *= part1.characterListToValue(adjacentPartNumbers.get(1));
                        answer += tempAnswer;
                    }
                }
            }
        }


        return answer;
    }

    private List<List<Character>> isAdjacentToThesePartNumbers(int gearX, int gearY, List<List<int[]>> coordinatesOfAllPartNumbers, List<List<Character>> charactersOfAllPartNumbers, int lineLength, int arrayLength) {
        List<List<Character>> adjacentPartNumbers = new ArrayList<>();
        int index = 0;
        for (List<int[]> coordinatesOfPartNumber : coordinatesOfAllPartNumbers) {
            for (int[] coordinatesOfPartNumberDigit : coordinatesOfPartNumber) {
                if (part1.checkNeighbours(coordinatesOfPartNumberDigit, arrayLength, lineLength, neighbor -> isNeighborADigit(new int[]{gearX, gearY}, neighbor[0], neighbor[1]))) {
                    adjacentPartNumbers.add(charactersOfAllPartNumbers.get(index));
                    break;
                }
            }
            index++;
        }

        return adjacentPartNumbers;
    }

    public boolean isNeighborADigit(int[] coords, int x, int y) {
        return (coords[0] == x && coords[1] == y);
    }
}
