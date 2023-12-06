import java.util.*;

public class CardWinnerPart2 {
    public int solve(List<Card> cards) {
        Map<Integer, Integer> amountOfWinsPerCard = new HashMap<>();
        int answer = 0;

        for (int i = 1; i < cards.size() + 1; i++) {
            Card card = cards.get(i - 1);
            Set<Integer> wonNumbers = new HashSet<>(card.getPlayerNumbers());
            wonNumbers.retainAll(card.getWinningNumbers());

            amountOfWinsPerCard.put(i, wonNumbers.size());


        }
        for (int id : amountOfWinsPerCard.keySet()) {
            answer += getAmountOfCards(amountOfWinsPerCard, id);
        }
        return answer + cards.size();
    }

    public int getAmountOfCards(Map<Integer, Integer> amountOfWinsPerCard, int id) {
        int count = amountOfWinsPerCard.get(id);
        for (int i = 1; i < amountOfWinsPerCard.get(id) + 1; i++) {
            count += getAmountOfCards(amountOfWinsPerCard, id + i);
        }
        return count;
    }
}
