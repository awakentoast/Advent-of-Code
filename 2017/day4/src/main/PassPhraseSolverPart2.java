package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PassPhraseSolverPart2 {

    public int solve(String[] passphrases) {
        int validPhrases = 0;

        for (String passphrase : passphrases) {
            if (!hasAnagrams(passphrase)) {
                validPhrases++;
            }
        }

        return validPhrases;
    }

    private boolean hasAnagrams(String passphrase) {
        String[] words = passphrase.split(" ");

        String[] sortedWords = new String[words.length];

        int index = -1;
        for (String word : words) {
            sortedWords[++index] = sortWord(word);
        }

        Set<String> wordsSet = new HashSet<>(List.of(sortedWords));

        return wordsSet.size() != sortedWords.length;
    }

    private String sortWord(String word) {
        char[] letters = word.toCharArray();

        List<Integer> letterValues = new String(letters).chars()
                .boxed()
                .toList();

        List<Integer> sortedLetterValues = letterValues.stream()
                .sorted()
                .toList();

        return sortedLetterValues.toString();
    }
}
