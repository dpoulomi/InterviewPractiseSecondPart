import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsIn2DArray {


    public static void main(String[] args) {
        int M[][] = new int[][] {
                { 1, 1, 0, 1, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 }
        };

        NumberOfIslandsIn2DArray numberOfIslandsIn2DArray = new NumberOfIslandsIn2DArray();

        System.out.println("Number of islands is: " + numberOfIslandsIn2DArray.findNumberOfIslands(M));
    }
    public int findNumberOfIslands(int[][] array) {
        int rowSize = array.length;
        int columnSize = array[0].length;
        int numberOfIslands = 0;
        boolean[][] visited = new boolean[rowSize][columnSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (array[i][j] == 1 && !isVisited(visited , i , j )) {
                    visited[i][j] = true;
                    DFS(i, j, visited, array);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    public boolean isVisited(boolean[][] visited , int row , int col){
        return visited[row][col];
    }

    private void DFS(int i, int j, boolean[][] visited, int[][] array) {
        List<Pair<Integer, Integer>> neighbours = getNeighbours(i, j, array);
        for (Pair<Integer, Integer> neighbour : neighbours) {
            final Integer neighbourRow = neighbour.getKey();
            final Integer neighbourCol = neighbour.getValue();
            if (isALand(neighbourRow, neighbourCol, array, visited) &&
                    !isVisited(visited , neighbourRow, neighbourCol)) {
                visited[neighbourRow][neighbourCol] = true;
                DFS(neighbourRow, neighbourCol, visited, array);
            }
        }
    }

    private boolean isALand(Integer key, Integer value, int[][] array, boolean[][] visited) {
        return array[key][value] == 1;
    }

    private boolean isValidPointInTheArray(int row, int col, int[][] array) {
        return row >= 0 &&
                col >= 0 &&
                row < array.length &&
                col < array[0].length;
    }

    private List<Pair<Integer, Integer>> getNeighbours(int row, int col, int[][] array) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if (isValidPointInTheArray(row - 1, col, array)) {
            neighbours.add(new Pair<>(row - 1, col));
        }
        if (isValidPointInTheArray(row - 1, col - 1, array)) {
            neighbours.add(new Pair<>(row - 1, col - 1));
        }
        if (isValidPointInTheArray(row, col - 1, array)) {
            neighbours.add(new Pair<>(row, col - 1));
        }
        if (isValidPointInTheArray(row + 1, col - 1, array)) {
            neighbours.add(new Pair<>(row + 1, col - 1));
        }
        if (isValidPointInTheArray(row + 1, col, array)) {
            neighbours.add(new Pair<>(row + 1, col));
        }
        if (isValidPointInTheArray(row + 1, col + 1, array)) {
            neighbours.add(new Pair<>(row + 1, col + 1));
        }
        if (isValidPointInTheArray(row, col + 1, array)) {
            neighbours.add(new Pair<>(row, col + 1));
        }
        if (isValidPointInTheArray(row - 1, col + 1, array)) {
            neighbours.add(new Pair<>(row, col + 1));
        }
        return neighbours;
    }
}
