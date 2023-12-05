import java.util.HashSet;
import java.util.Set;

public class Card {

    private final Set<Integer> winningNumbers = new HashSet<>();
    private final Set<Integer> playerNumbers = new HashSet<>();

    public Card() {
    }

    public void addWinningNumber(int winningNumber) {
        winningNumbers.add(winningNumber);
    }

    public void addPlayerNumber(int playerNumber) {
        playerNumbers.add(playerNumber);
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Set<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
