package Graph;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NUmberOfISlands {


    public int findNumberOfIslands(int[][] matrix) {

        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        int numberOfIslands = 0;
        boolean visited[][] = new boolean[mat.length][mat[0].length];

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
                if (visited[rowIndex][colIndex] == false && visited[rowIndex][colIndex])
                    DFS(rowIndex, colIndex, mat, numberOfIslands, visited);
                numberOfIslands++;
            }
        }
        return numberOfIslands;

    }

    private void DFS(int rowIndex, int colIndex, int[][] mat, int numberOfIslands, boolean[][] visited) {
        List<Pair<Integer, Integer>> neighbours = getNeighbours(rowIndex, colIndex, mat, visited);
        visited[rowIndex][colIndex] = true;

        for (int i = 0; i < neighbours.size(); i++) {
            int neighbourRowIndex = neighbours.get(i).getKey();
            int neighbourColIndex = neighbours.get(i).getValue();

            if (mat[neighbourRowIndex][neighbourColIndex] == 1) {

                DFS(neighbourRowIndex, colIndex, mat, numberOfIslands, visited);
            }


        }


    }

    private List<Pair<Integer, Integer>> getNeighbours(int rowIndex, int colIndex, int[][] mat, boolean[][] visited) {
        List<Pair<Integer, Integer>> validNeighbours = new ArrayList<>();
        if (isValid(rowIndex + 1, colIndex, mat, visited)) {
            validNeighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(rowIndex, colIndex + 1, mat, visited)) {
            validNeighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(rowIndex, colIndex, mat, visited)) {
            validNeighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(rowIndex, colIndex + 1, mat, visited)) {
            validNeighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        return validNeighbours;
    }

    private boolean isValid(int rowIndex, int colIndex, int[][] mat, boolean[][] visited) {
        return visited[rowIndex][colIndex] == false && rowIndex > 0 && rowIndex < mat.length && colIndex > 0 && colIndex < mat[0].length;
    }


}
