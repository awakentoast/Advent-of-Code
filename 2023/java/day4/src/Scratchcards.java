import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scratchcards {
    public static void main(String[] args) {
        String input = readInput();
        List<Card> cards = parseInput(input);

        CardWinnerPart1 cardWinnerPart1 = new CardWinnerPart1();
        int part1 = cardWinnerPart1.solve(cards);
        System.out.println("Part 1: " + part1);

        CardWinnerPart2 cardWinnerPart2 = new CardWinnerPart2();
        int part2 = cardWinnerPart2.solve(cards);
        System.out.println("Part 2: " + part2);
    }

    private static List<Card> parseInput(String input) {
        String[] lines = input.split("%n");
        List<Card> cards = new ArrayList<>(lines.length);

        Pattern p = Pattern.compile("\\d+");

        Card card;
        for (String line : lines) {
            card = new Card();
            String[] noIndex = line.split(": ");
            String[] bothPlayers = noIndex[1].split(" \\| ");

            Matcher winningNumbers = p.matcher(bothPlayers[0]);
            while (winningNumbers.find()) {
                card.addWinningNumber(Integer.parseInt(winningNumbers.group()));
            }

            Matcher playerNumbers = p.matcher(bothPlayers[1]);
            while (playerNumbers.find()) {
                card.addPlayerNumber(Integer.parseInt(playerNumbers.group()));
            }
            cards.add(card);
        }

        return cards;
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("%n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}