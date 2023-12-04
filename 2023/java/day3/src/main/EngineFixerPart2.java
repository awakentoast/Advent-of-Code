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
                while (part1.isCharacterDigitWithBoundCheck(x, y, array, lineLength, arrayLength)) {
                    coordinatesOfDigits.add(new int[]{x, y});
                    charactersOfNumber.add(array[y][x]);
                    x++;
                }

                if (part1.checkIfNumberIsAdjacentToSymbol(coordinatesOfDigits, array, arrayLength, lineLength)) {
                    coordinatesOfAllPartNumbers.add(new ArrayList<>(coordinatesOfDigits));
                    charactersOfAllPartNumbers.add(new ArrayList<>(charactersOfNumber));
                }

                coordinatesOfDigits.clear();
                charactersOfNumber.clear();

                x++;
            }
        }

        for (int y = 0; y < arrayLength; y++) {
            for (x = 0; x < lineLength; x++) {
                if (array[y][x] == '*') {
                    List<List<Character>> adjacentPartNumbers = isAdjacentToThesePartNumbers(x, y, coordinatesOfAllPartNumbers, charactersOfAllPartNumbers, array, lineLength, arrayLength);
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

    private List<List<Character>> isAdjacentToThesePartNumbers(int x, int y, List<List<int[]>> coordinatesOfAllPartNumbers, List<List<Character>> charactersOfAllPartNumbers, char[][] array, int lineLength, int arrayLength) {
        List<List<Character>> adjacentPartNumbers = new ArrayList<>();
        int index = 0;
        for (List<int[]> coordinatesOfPartNumber : coordinatesOfAllPartNumbers) {
            for (int[] coordinatesOfPartNumberDigit : coordinatesOfPartNumber) {
                if (checkIfGearIsAdjacentToPartNumberDigit(x, y, coordinatesOfPartNumberDigit, array, arrayLength, lineLength)) {
                    adjacentPartNumbers.add(charactersOfAllPartNumbers.get(index));
                    break;
                }
            }
            index++;
        }

        return adjacentPartNumbers;
    }

    public boolean checkIfGearIsAdjacentToPartNumberDigit(int gearX, int gearY, int[] coordinatesOfPartNumberDigit, char[][] array, int arrayLength, int lineLength) {
        int[] directionsX = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] directionsY = {-1, 0, 1, 1, 1, 0, -1, -1};

        int tempGearX;
        int tempGearY;

        for (int i = 0; i < directionsX.length; i++) {
            tempGearX = gearX + directionsX[i];
            tempGearY = gearY + directionsY[i];

            //check whether the checked character would be outside the array
            if (tempGearY >= 0 && tempGearY < arrayLength && tempGearX >= 0 && tempGearX < lineLength) {
                char charToCheck = array[tempGearY][tempGearX];
                if (coordinatesOfPartNumberDigit[0] == tempGearX && coordinatesOfPartNumberDigit[1] == tempGearY) {
                    return true;
                }
            }
        }


        return false;
    }
}
