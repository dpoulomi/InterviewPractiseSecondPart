import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LongestPathInAMatrix {

    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}
        };

        LongestPathInAMatrix longestPathInAMatrix = new LongestPathInAMatrix();
        List<Integer> longestPath = longestPathInAMatrix.findLongestPathInAMatrix(mat);
        longestPath.stream().forEach(e -> System.out.println(e));
    }

    public List<Integer> findLongestPathInAMatrix(int[][] matrix) {
        List<List<Integer>> elements = new ArrayList<>();
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
                List<Integer> longestPath = new ArrayList<>();
                longestPath.add(matrix[rowIndex][colIndex]);
                findLongestPathUtil(matrix, rowIndex, colIndex, longestPath);
                elements.add(longestPath);
            }
        }

        return longestPath(elements);
    }

    private List<Integer> longestPath(List<List<Integer>> elements) {
        int max = 0;
        List<Integer> answer = new ArrayList<>();
        for (List<Integer> element : elements) {
            if (max < element.size()) {
                max = element.size();
                answer = element;
            }

        }
        return answer;
    }

    private void findLongestPathUtil(int[][] matrix, int row, int col, List<Integer> elements) {

        List<Pair<Integer, Integer>> neighbours = getNeighbours(matrix, row, col);
        for (Pair<Integer, Integer> pair : neighbours) {
            final Integer neighbourRowIndex = pair.getKey();
            final Integer neighbourColIndex = pair.getValue();
            if (matrix[neighbourRowIndex][neighbourColIndex] - matrix[row][col] == 1) {
                elements.add(matrix[neighbourRowIndex][neighbourColIndex]);
                findLongestPathUtil(matrix, neighbourRowIndex, neighbourColIndex, elements);
            }
        }
    }

    private List<Pair<Integer, Integer>> getNeighbours(int[][] matrix, int i, int j) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if (isValid(i + 1, j, matrix)) {
            neighbours.add(new Pair<>(i + 1, j));
        }
        if (isValid(i, j + 1, matrix)) {
            neighbours.add(new Pair<>(i, j + 1));
        }
        if (isValid(i - 1, j, matrix)) {
            neighbours.add(new Pair<>(i - 1, j));
        }
        if (isValid(i, j - 1, matrix)) {
            neighbours.add(new Pair<>(i, j - 1));
        }
        return neighbours;
    }

    private boolean isValid(int i, int j, int[][] matrix) {

        return (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length);
    }
}
