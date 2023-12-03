package main;

import java.util.ArrayList;
import java.util.List;

public class StreamSolver1 {

    public int solve(String stream) {
        stream = cleanupString(stream);
        System.out.println(stream);

        int answer = computeValueOfStream(stream.substring(1, stream.length()));

        return answer;
    }


    public int computeValueOfStream(String stream) {
        int points = 0;
        int previousLeftBrackets = 0;
        int amountOfRightBrackets = 0;
        boolean searchingForPair = true;

        for (int index = 0; index < stream.length(); index++) {
            if (stream.charAt(index) == '{') {
                amountOfRightBrackets++;
                while (searchingForPair) {
                    index++;
                    if (stream.charAt(index) == '{') {
                        previousLeftBrackets++;
                    } else if (stream.charAt(index) == '}') {
                        amountOfRightBrackets++;
                    }

                    if (amountOfRightBrackets == previousLeftBrackets) {
                        searchingForPair = false;
                        amountOfRightBrackets = 0;
                        previousLeftBrackets = 0;

                        if (stream.charAt(index + 1) == ',') {
                            String group = findGroup(stream.substring(index));
                            points += computeValueOfStream(group);
                        }
                    }
                }
            }
        }

        return points;
    }


    public String findGroup(String stream) {
        return "";
    }


    public String cleanupString(String stream) {
        stream = removeGarbage(stream);
        stream = removeUnnecessaryCommas(stream);
        return stream;
    }


    public String removeGarbage(String stream) {
        char sign;
        int offset = 0;
        for (int i = 0; i < stream.length(); i++) {
            int index = i - offset;
            sign = stream.charAt(index);

            if (sign == '<') {
                String tempString = removeNextGarbageString(stream, index + 1);
                stream = tempString;
                offset = stream.length() - tempString.length();
            }
        }

        return stream;
    }


    public String removeNextGarbageString(String stream, int index) {
        for (int i = index; i < stream.length(); i++) {
            char sign = stream.charAt(i);
            if (sign == '>' && consecutiveExclamationMarks(stream, i) % 2 == 0) {
                return stream.substring(0, index - 1) + stream.substring(i + 1);
            }
        }
        return stream;
    }


    public int consecutiveExclamationMarks(String stream, int index) {
        int consecutiveExclamationMarks = 0;
        char character = stream.charAt(index - 1);

        while (character == '!') {
            index--;
            consecutiveExclamationMarks++;
            character = stream.charAt(index - 1);
        }

        return consecutiveExclamationMarks;
    }


    public String removeUnnecessaryCommas(String stream) {
        List<Integer> commasToRemove = new ArrayList<>();
        for (int i = 0; i < stream.length(); i++) {
            if (stream.charAt(i) == ',' && (stream.charAt(i + 1) == ',' || stream.charAt(i - 1) ==  ',')) {
                commasToRemove.add(i);
            }
        }

        for (int i = commasToRemove.size() - 1; i >= 0; i--) {
            int removeIndex = commasToRemove.get(i);
            stream = stream.substring(0, removeIndex) + stream.substring(removeIndex + 1);
        }

        return stream;
    }
}
