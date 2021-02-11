package AmazonPrep;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZombieInMatrixUsingBFS {

    public static void main(String[] args) {
        int[][] zombies = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};

        ZombieInMatrixUsingBFS zombieInMatrixUsingBFS = new ZombieInMatrixUsingBFS();
        System.out.println(zombieInMatrixUsingBFS.getMaximumZombie(zombies));
    }


    public int getMaximumZombie(int[][] zombieMatrix) {
        int minutes = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < zombieMatrix.length; i++) {
            for (int j = 0; j < zombieMatrix[0].length; j++) {
                if (zombieMatrix[i][j] == 1) {
                    queue.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> zombie = queue.peek();
                queue.poll();
                List<Pair<Integer, Integer>> humanNeighbours = getHumanNeighbours(zombie, zombieMatrix);
                for (int j = 0; j < humanNeighbours.size(); j++) {
                    zombieMatrix[humanNeighbours.get(j).getKey()][humanNeighbours.get(j).getValue()] = 1;
                    queue.add(humanNeighbours.get(j));
                }
            }

            if (queue.isEmpty()) {
                return minutes;
            }
            minutes++;
        }

        return minutes;


    }

    private List<Pair<Integer, Integer>> getHumanNeighbours(Pair<Integer, Integer> zombie, int[][] zombieMatrix) {
        List<Pair<Integer, Integer>> humanNeighbours = new ArrayList<>();
        if (isValid(zombieMatrix, zombie.getKey() + 1, zombie.getValue())) {
            humanNeighbours.add(new Pair<>(zombie.getKey() + 1, zombie.getValue()));
        }
        if (isValid(zombieMatrix, zombie.getKey(), zombie.getValue() + 1)) {
            humanNeighbours.add(new Pair<>(zombie.getKey(), zombie.getValue() + 1));
        }
        if (isValid(zombieMatrix, zombie.getKey() - 1, zombie.getValue())) {
            humanNeighbours.add(new Pair<>(zombie.getKey() - 1, zombie.getValue()));
        }
        if (isValid(zombieMatrix, zombie.getKey(), zombie.getValue() - 1)) {
            humanNeighbours.add(new Pair<>(zombie.getKey(), zombie.getValue() - 1));

        }
        return humanNeighbours;
    }

    private boolean isValid(int[][] zombies, int rowIndex, int colIndex) {

        return rowIndex > 0 &&
                rowIndex < zombies.length && colIndex > 0
                && colIndex < zombies[0].length && zombies[rowIndex][colIndex] == 0;
    }
}
