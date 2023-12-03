package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassPhraseSolverPart1 {


    public int solve(String[] passphrases) {
        int validPhrases = 0;

        for (String passphrase : passphrases) {
           if (!hasDuplicates(passphrase)) {
                validPhrases++;
            }
        }

        return validPhrases;
    }

    private boolean hasDuplicates(String passphrase) {
        String[] words = passphrase.split(" ");
        Set<String> set = new HashSet<>(List.of(words));

         return set.size() != words.length;
    }
}
