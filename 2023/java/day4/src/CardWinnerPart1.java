import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardWinnerPart1 {
    public int solve(List<Card> cards) {
        int answer = 0;
        for (Card card : cards) {
            Set<Integer> wonNumbers = new HashSet<>(card.getPlayerNumbers());
            wonNumbers.retainAll(card.getWinningNumbers());

            int tempAnswer = 1;
            for (int i = 0; i < wonNumbers.size(); i++) {
                tempAnswer *= 2;
            }
            answer += tempAnswer /  2;
        }

        return answer;
    }
}
