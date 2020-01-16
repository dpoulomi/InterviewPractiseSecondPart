import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class RatInAMazeRepeat {

    public static void main(String[] args) {
        RatInAMazeRepeat ratInAMazeRepeat = new RatInAMazeRepeat();
        int maze[][] = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 1}
        };
        System.out.print(ratInAMazeRepeat.findPathForRatFromSourceToDestination(maze));
    }


    public boolean findPathForRatFromSourceToDestination(int[][] maze) {
        int rowSize = maze.length;
        int colSize = maze[0].length;
        int[][] solution = new int[rowSize][colSize];
        return findPathIfPresent(maze, solution, 0, 0, rowSize, colSize);
    }

    private boolean findPathIfPresent(int[][] maze, int[][] solution, int rowIndex, int colIndex, int rowSize, int colSize) {
        if(maze[rowIndex][colIndex] == 0) {
            return false;
        }
        if (rowIndex == rowSize - 1 && colIndex == colSize - 1) {
            return true;
        }

        final List<Pair<Integer, Integer>> neighbours = getNeighbours(rowIndex, colIndex, rowSize, colSize);

        for (Pair<Integer, Integer> neighbour : neighbours) {
            int neighbourRowIndex = neighbour.getKey();
            int neighbourColIndex = neighbour.getValue();
            boolean thisNeighbourCanReachDestination = findPathIfPresent(maze,
                                                                        solution,
                                                                        neighbourRowIndex,
                                                                        neighbourColIndex,
                                                                        rowSize,
                                                                        colSize);
            if(thisNeighbourCanReachDestination) {
                return true;
            }
        }
        return false;


    }

    private List<Pair<Integer, Integer>> getNeighbours(int row, int col, int rowSize, int colSize) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();

        if(isValidIndex(row, col + 1, rowSize, colSize)) {
            neighbours.add(new Pair<>(row, col + 1));
        }

        if(isValidIndex(row + 1, col, rowSize, colSize)) {
            neighbours.add(new Pair<>(row + 1, col));
        }

        return neighbours;
    }

    private boolean isValidIndex(int row, int col, int rowSize, int colSize) {
        return row >= 0 &&
                col >= 0 &&
                row < rowSize &&
                col < colSize;
    }


}
