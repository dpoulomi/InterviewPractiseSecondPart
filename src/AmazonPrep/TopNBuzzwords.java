package AmazonPrep;

import java.util.*;

public class TopNBuzzwords {

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

        HashMap<String, Integer> topUsed = getMaxUsed(numToys, topToys, toys, numQuotes, quotes);

        for (String key : topUsed.keySet()) {
            System.out.println(key);

        }
    }

    private static HashMap<String, Integer> getMaxUsed(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {

        HashMap<String, Integer> tracker = new HashMap<>();
        for (String quote : quotes) {
            for (int i = 0; i < toys.length; i++) {

                    if (tracker.get(toys[i]) == null) {
                        tracker.put(toys[i], 0);
                    } else {
                        int number = tracker.get(toys[i]);
                        tracker.put(toys[i], number++);
                    }
            }
        }


        List<Map.Entry<String, Integer>> linkedListTracker = new LinkedList<>(tracker.entrySet());
        Collections.sort(linkedListTracker, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });


        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> each : linkedListTracker) {

            hashMap.put(each.getKey(), each.getValue());
        }

        return hashMap;
    }
}
