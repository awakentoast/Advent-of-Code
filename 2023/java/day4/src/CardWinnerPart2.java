import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardWinnerPart2 {
    public int solve(List<Card> cards) {
        int answer = 0;
        for (Card card : cards) {
            Set<Integer> wonNumbers = new HashSet<>(card.getPlayerNumbers());
            wonNumbers.retainAll(card.getWinningNumbers());

        }

        return 0;
    }
}
