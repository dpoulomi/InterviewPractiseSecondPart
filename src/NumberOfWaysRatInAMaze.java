import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysRatInAMaze {

    public static void main(String[] args) {
        NumberOfWaysRatInAMaze numberOfWaysRatInAMaze = new NumberOfWaysRatInAMaze();

       int maze[][] =  {
               {0, -1, -1, 0},
               {0, 0, 0, 0},
               {0, -1, 0, 0}};

        System.out.print(numberOfWaysRatInAMaze.findNumberOfWays(maze));
    }
    public int findNumberOfWays(int [][] maze){

        int rowSize = maze.length;
        int colSize = maze[0].length;
        int ways = findNumberOfWaysUtil(maze , 0 , 0 , rowSize , colSize);
        return ways;

    }


    private int findNumberOfWaysUtil(int[][] maze, int i, int j, int rowSize, int colSize) {
        if(maze [i][j] == -1){
            return 0;
        }
        if(i == rowSize - 1 && j ==colSize - 1 && maze[i][j] == 0){
            return 1;
        }


        List<Pair<Integer, Integer>> neighbours = getNeighbours(maze , i , j , rowSize , colSize);
        int ways = 0;
        for(Pair<Integer, Integer> neighbour : neighbours){
            ways = ways + findNumberOfWaysUtil(maze , neighbour.getKey() , neighbour.getValue(), rowSize , colSize);

        }
        return ways;
    }

    private List<Pair<Integer,Integer>> getNeighbours(int[][] maze, int i, int j, int rowSize, int colSize) {
        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
        if(isValid(i + 1 , j , rowSize , colSize)){
           neighbours.add( new Pair<>(i + 1, j));
        }
        if(isValid(i , j + 1 , rowSize, colSize)){
            neighbours.add( new Pair<>(i , j + 1));
        }
        return neighbours;
    }

    private boolean isValid(int i ,int j , int rowSize , int colSize){
        if(i >= 0 && i < rowSize && j >= 0 && j < colSize){
            return true;
        }
        return false;
    }
}
