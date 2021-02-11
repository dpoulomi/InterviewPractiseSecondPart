package AmazonPrep;

import java.util.*;

public class TopNBuzzWordsSelf {


    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};

        TopNBuzzWordsSelf topNBuzzWordsSelf = new TopNBuzzWordsSelf();
        List<String> topUsed = topNBuzzWordsSelf.getMaxUsed(numToys, topToys, toys, numQuotes, quotes);

        topUsed.stream().forEach(element -> System.out.println(element));
    }


    public List<String> getMaxUsed(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        Map<String, Integer> tracker = new HashMap<>();
        for (String toy : toys) {
            tracker.put(toy, 0);
        }
        for (String quote : quotes) {
            String[] words = quote.split(" ");
            for (int i = 0; i < words.length; i++) {
                String wordInLowerCase = words[i].toLowerCase();
                if (tracker.containsKey(wordInLowerCase)) {
                    tracker.put(wordInLowerCase, tracker.get(wordInLowerCase) + 1);
                }

            }

        }

        List<Map.Entry<String, Integer>> sortedToys = new ArrayList<>(tracker.entrySet());

        Collections.sort(sortedToys, (a, b) -> (b.getValue() - a.getValue()) != 0 ? b.getValue() - a.getValue() : a.getKey().compareTo(b.getKey()));

        List<String> result = new ArrayList<>();
        int i = 0;

        for (Map.Entry<String, Integer> res : sortedToys) {
            if (i == topToys) {
                break;
            }
            result.add(res.getKey());
            i++;

        }

        return result;
    }
}
