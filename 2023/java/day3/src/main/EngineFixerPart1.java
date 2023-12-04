package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

                while (isCharacterDigitWithBoundCheck(x, y, array, arrayLength, lineLength)) {
                    coordinatesOfDigits.add(new int[]{x, y});
                    charactersOfNumber.add(array[y][x]);
                    x++;
                }

                if (isPartNumber(coordinatesOfDigits, array, arrayLength, lineLength)) {
                    System.out.println("a");
                    answer+= characterListToValue(charactersOfNumber);
                }

                coordinatesOfDigits.clear();
                charactersOfNumber.clear();

                x++;
            }
        }

        return answer;
    }

    public boolean isPartNumber(List<int[]> coordinatesOfDigits, char[][] array, int arrayLength, int lineLength) {
        for (int[] coordinateOfDigit : coordinatesOfDigits) {
            if (checkNeighbours(coordinateOfDigit, arrayLength, lineLength, neighbor -> isASymbol(neighbor[0], neighbor[1], array))) {
                return true;
            }
        }

        return false;
    }

    public Boolean isASymbol(int x, int y, char[][] array) {
        char charToCheck = array[y][x];
        return !Character.isDigit(charToCheck) && charToCheck != '.';
    }

    public boolean isCharacterDigitWithBoundCheck(int x, int y, char[][] array, int arrayLength, int lineLength) {
        if (!isInBound(x,y,arrayLength,lineLength)) {
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




    public boolean checkNeighbours(int[] coordinates, int arrayLength, int lineLength, Predicate<int[]> predicate) {
        int[] directionsX = {1, 1, 1, 0, -1, -1, -1, 0};
        int[] directionsY = {-1, 0, 1, 1, 1, 0, -1, -1};

        int x;
        int y;

        for (int i = 0; i < directionsX.length; i++) {
            x = coordinates[0] + directionsX[i];
            y = coordinates[1] + directionsY[i];

            if (isInBound(x, y, arrayLength, lineLength)) {
                if (predicate.test(new int[]{x,y})) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isInBound(int x, int y, int arrayLength, int lineLength) {
        return (y >= 0 && y < arrayLength && x >= 0 && x < lineLength);
    }
}
