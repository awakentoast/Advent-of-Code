package main;

import java.util.function.IntUnaryOperator;

public class TrebuchetInstructionFixerPart1 {


    public int solve(String[] lines) {
        int answer = 0;
        for (String line : lines) {
            String numbers = "";
            char firstOccurredCharacter = traverseLine(0, line, x -> x + 1);
            numbers += String.valueOf(firstOccurredCharacter);

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
            char charInString = line.charAt(index);
            character = checkIfCharIsANumber(charInString);
            index = operator.applyAsInt(index);
        } while (character == '0');

        return character;
    }



    public char checkIfCharIsANumber(char currentChar) {
        if (Character.isDigit(currentChar)) {
            return currentChar;
        }

        return '0';
    }
}
