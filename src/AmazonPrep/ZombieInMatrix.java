package AmazonPrep;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ZombieInMatrix {


    public static void main(String[] args) {
        int[][] zombies = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};


        int rowCount = zombies.length;
        int colCount = zombies[0].length;
        ZombieInMatrix zombieInMatrix = new ZombieInMatrix();

        int minutes = zombieInMatrix.findMinutesLapsed(zombies, rowCount, colCount);
        System.out.println(minutes);


    }

    private int findMinutesLapsed(int[][] zombies, int rowCount, int colCount) {
        int minutes = 0;
        boolean[][] visited = new boolean[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                DFS(zombies, rowCount, colCount, visited, i, j, minutes);
            }
        }
        return minutes;
    }


    //cover each node first
    private void DFS(int[][] zombies, int rowCount, int colCount, boolean[][] visited, int rowIndex, int colIndex, int minutes) {

        visited[rowIndex][colIndex] = true;

        List<Pair<Integer, Integer>> neighbours = getValidNeighbours(zombies, visited, rowIndex, colIndex);

        for (Pair<Integer, Integer> neighbour : neighbours) {
            if (zombies[neighbour.getKey()][neighbour.getValue()] == 0) {
                zombies[neighbour.getKey()][neighbour.getValue()] = 1;
                DFS(zombies, rowCount, colCount, visited, neighbour.getKey(), neighbour.getValue(), minutes);
                minutes++;
            }


        }


    }

    private List<Pair<Integer, Integer>> getValidNeighbours(int[][] zombies, boolean[][] visited, int rowIndex, int colIndex) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if (isValid(visited, zombies, rowIndex + 1, colIndex)) {
            neighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(visited, zombies, rowIndex, colIndex + 1)) {
            neighbours.add(new Pair<>(rowIndex, colIndex + 1));
        }
        if (isValid(visited, zombies, rowIndex - 1, colIndex)) {
            neighbours.add(new Pair<>(rowIndex - 1, colIndex));
        }
        if (isValid(visited, zombies, rowIndex, colIndex - 1)) {
            neighbours.add(new Pair<>(rowIndex, colIndex - 1));

        }
        return neighbours;
    }

    private boolean isValid(boolean[][] visited, int[][] zombies, int rowIndex, int colIndex) {

        return rowIndex > 0 &&
                rowIndex < zombies.length && colIndex > 0
                && colIndex < zombies[0].length && visited[rowIndex][colIndex] == false;
    }


}
