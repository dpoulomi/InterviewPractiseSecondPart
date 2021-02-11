package MultidimensionalMatrix;

import javafx.util.Pair;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class ShortestPathInABinaryMaze {


    public static void main(String[] args) {
        int matrix[][] = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}};

        ShortestPathInABinaryMaze shortestPathInABinaryMaze = new ShortestPathInABinaryMaze();
        shortestPathInABinaryMaze.getMinPath(matrix);
    }

    public void getMinPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
     //  List<List<Integer>> numberOfPaths = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; i++) {

                DFS(matrix, i, j, visited, 5, 5);
            }
        }
    }

    private void DFS(int[][] matrix, int rowIndex, int colIndex, boolean[][] visited, int destRow, int destCol) {
        visited[rowIndex][colIndex] = true;

        List<Pair<Integer, Integer>> neighbours = getNeighbours(matrix, rowIndex, colIndex, visited);
        for (int i = 0; i < neighbours.size(); i++) {
            int neighbourRowIndex = neighbours.get(i).getKey();
            int neighbourColIndex = neighbours.get(i).getValue();

            if (matrix[neighbourRowIndex][neighbourColIndex] == 1 && neighbourRowIndex == destRow && neighbourColIndex == destCol) {
                DFS(matrix, neighbourRowIndex, neighbourColIndex, visited, destRow, destCol);
            }
        }


    }

    private List<Pair<Integer, Integer>> getNeighbours(int[][] matrix, int rowIndex, int colIndex, boolean[][] visited) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if (isValid(rowIndex + 1, colIndex, matrix, visited)) {
            neighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(rowIndex, colIndex + 1, matrix, visited)) {
            neighbours.add(new Pair<>(rowIndex, colIndex + 1));
        }
        if (isValid(rowIndex - 1, colIndex, matrix, visited)) {
            neighbours.add(new Pair<>(rowIndex - 1, colIndex));
        }
        if (isValid(rowIndex, colIndex - 1, matrix, visited)) {
            neighbours.add(new Pair<>(rowIndex, colIndex - 1));
        }

        return neighbours;
    }

    private boolean isValid(int rowIndex, int colIndex, int[][] matrix, boolean[][] visited) {
        return visited[rowIndex][colIndex] == false &&
                rowIndex > 0 && rowIndex < matrix.length &&
                colIndex > 0 && colIndex < matrix[0].length;

    }
}
