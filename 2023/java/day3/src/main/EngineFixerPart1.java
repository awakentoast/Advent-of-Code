package main;

import java.util.ArrayList;
import java.util.List;

public class EngineFixerPart1 {


    public int solve(char[][] array) {
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

                while (isCharacterDigitWithBoundCheck(x, y, array, lineLength, arrayLength)) {
                    coordinatesOfDigits.add(new int[]{x, y});
                    charactersOfNumber.add(array[y][x]);
                    x++;
                }

                if (checkIfNumberIsAdjacentToSymbol(coordinatesOfDigits, array, arrayLength, lineLength)) {
                    answer += characterListToValue(charactersOfNumber);
                }

                coordinatesOfDigits.clear();
                charactersOfNumber.clear();

                x++;
            }
        }

        return answer;
    }

    public boolean isCharacterDigitWithBoundCheck(int x, int y, char[][] array, int lineLength, int arrayLength) {
        if (x >= lineLength || y >= arrayLength) {
            return false;
        }

        return Character.isDigit(array[y][x]);
    }


    public int characterListToValue(List<Character> charactersOfNumber) {
        StringBuilder valueString = new StringBuilder();
        for (char character : charactersOfNumber) {
            valueString.append(character);
        }
        return Integer.parseInt(valueString.toString());
    }

    public boolean checkIfNumberIsAdjacentToSymbol(List<int[]> coordinatesOfDigits, char[][] array, int arrayLength, int lineLength) {
        int[] directionsX = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] directionsY = {-1, 0, 1, 1, 1, 0, -1, -1};

        int x;
        int y;
        for (int[] coordinates : coordinatesOfDigits) {
            for (int i = 0; i < directionsX.length; i++) {
                x = coordinates[0] + directionsX[i];
                y = coordinates[1] + directionsY[i];

                //check whether the checked character would be outside the array
                if (y >= 0 && y < arrayLength && x >= 0 && x < lineLength) {
                    char charToCheck = array[y][x];
                    if (!Character.isDigit(charToCheck) && charToCheck != '.') {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
