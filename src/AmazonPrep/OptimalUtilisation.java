package AmazonPrep;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class OptimalUtilisation {


    public List<Pair> findOptimization(List<Pair<Integer, Integer>> pair1, List<Pair<Integer, Integer>> pair2, int target) {


        int diff = target - (pair1.get(0).getValue() + pair2.get(0).getValue());
        ;

        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < pair1.size(); i++) {
            for (int j = 0; j < pair2.size(); j++) {
                int sum = (pair1.get(i).getValue() + pair2.get(j).getValue());
                if (target == sum) {
                    result.add(new Pair(i + 1, j + 1));
                    diff = target - (pair1.get(i).getValue() + pair2.get(j).getValue());

                } else if (sum < target && diff > target - sum) {
                    diff = target - sum;
                    result.add(new Pair(i + 1, j + 1));

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> a = new ArrayList<>();
        a.add(new Pair<>(1, 2));
        a.add(new Pair<>(2, 3));
        a.add(new Pair<>(3, 4));
        a.add(new Pair<>(4, 5));
        List<Pair<Integer, Integer>> b = new ArrayList<>();
        b.add(new Pair<>(1, 2));
        b.add(new Pair<>(2, 3));
        b.add(new Pair<>(3, 4));
        int target = 6;


        OptimalUtilisation optimalUtilisation = new OptimalUtilisation();
        List<Pair> result = optimalUtilisation.findOptimization(a, b, target);
        for (Pair<Integer, Integer> pair : result) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
