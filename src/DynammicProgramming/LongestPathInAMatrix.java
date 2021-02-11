package DynammicProgramming;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LongestPathInAMatrix {


    public List<List<Integer>> findLongestPathInMatrix() {
        List<List<Integer>> arrayList = new ArrayList<>();
        int mat[][] = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};

        int row = mat.length;
        int col = mat[0].length;
        List<Integer> longestPath = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                longestPath.add(mat[i][j]);
                DFS(mat, i, j, longestPath);
                arrayList.add(longestPath);
            }
        }
        return arrayList;
    }

    private void DFS(int[][] mat, int rowIndex, int colIndex, List<Integer> longestPath) {
        List<Pair<Integer, Integer>> neighbours = getNeighbours(mat, rowIndex, colIndex);
        for (int i = 0; i < neighbours.size(); i++) {
            int neighbourRow = neighbours.get(i).getKey();
            int neighbourCol = neighbours.get(i).getValue();
            if (mat[neighbourRow][neighbourCol] - mat[rowIndex][colIndex] == 1) {
                longestPath.add(mat[neighbourRow][neighbourCol]);
                DFS(mat, neighbourRow, neighbourCol, longestPath);
            }
        }
    }

    private List<Pair<Integer, Integer>> getNeighbours(int[][] mat, int rowIndex, int colIndex) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if (isValid(rowIndex + 1, colIndex, mat.length, mat[0].length)) {
            neighbours.add(new Pair<>(rowIndex + 1, colIndex));
        }
        if (isValid(rowIndex, colIndex + 1, mat.length, mat[0].length)) {
            neighbours.add(new Pair<>(rowIndex, colIndex + 1));
        }
        if (isValid(rowIndex - 1, colIndex, mat.length, mat[0].length)) {
            neighbours.add(new Pair<>(rowIndex - 1, colIndex));
        }
        if (isValid(rowIndex, colIndex - 1, mat.length, mat[0].length)) {
            neighbours.add(new Pair<>(rowIndex, colIndex - 1));
        }

        return neighbours;
    }

    private boolean isValid(int rowIndex, int colIndex, int rowSize, int colSize) {
        return rowIndex >= 0 && rowIndex < rowSize && colIndex >= 0 && colIndex <= colSize;
    }

    public static void main(String[] args) {
        LongestPathInAMatrix longestPathInAMatrix = new LongestPathInAMatrix();
        List<List<Integer>> listOfLongestPath = longestPathInAMatrix.findLongestPathInMatrix();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < listOfLongestPath.size(); i++) {
            if (listOfLongestPath.get(i).size() > max) {
                max = listOfLongestPath.get(i).size();
                List<Integer> elements = listOfLongestPath.get(i);
            }
        }

    }

}
