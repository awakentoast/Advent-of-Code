package main;

import java.util.function.IntUnaryOperator;

public class TrebuchetInstructionFixerPart2 {

    int solve(String[] lines) {
        int answer = 0;
        for (String line : lines) {
            String numbers = "";
            //from 0 till the end of string
            char firstOccurredCharacter = traverseLine(0, line, x -> x + 1);
            numbers += String.valueOf(firstOccurredCharacter);

            //from end of the string to 0
            char lastOccurredCharacter = traverseLine(line.length() - 1, line, x -> x - 1);
            numbers += String.valueOf(lastOccurredCharacter);

            answer += Integer.parseInt(numbers);
        }

        return answer;
    }

    public char traverseLine(int startIndex, String line, IntUnaryOperator operator) {
        int index = startIndex;
        char character;
        do {
            character = checkIfIndexContainsANumber(index, line);
            index = operator.applyAsInt(index);
        } while (character == '0');

        return character;
    }

    private char checkIfIndexContainsANumber(int index, String  line) {
        char currentChar = line.charAt(index);
        if (Character.isDigit(currentChar)) {
            return currentChar;
        }

        int indexAsNumberStringValue = isThisIndexANumberString(index, line);
        if (indexAsNumberStringValue >= 0) {
            return Character.forDigit(indexAsNumberStringValue, 10);
        }

        return '0';
    }


    public int isThisIndexANumberString(int index, String line) {
        String[] numbersAsString = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] numberOfChars = {3, 3, 5, 4, 4, 3, 5, 5, 4};
        int maxLength = line.length() - 1;

        for (int i = 0; i < 9; i++) {
            //we do -1 because the number of chars doesn't include the char at the current index in the count.
            int maxIndex = index + numberOfChars[i] - 1;
            if (maxIndex <= maxLength) {
                String substring = line.substring(index, index + numberOfChars[i]);
                if (substring.equals(numbersAsString[i])) {
                    return i + 1;
                }
            }
        }

        return -1;
    }
}