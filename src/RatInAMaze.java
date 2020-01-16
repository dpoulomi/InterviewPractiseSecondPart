public class RatInAMaze {

    private static int N ;
    public boolean solveMaze(int[][] maze){
        int solution[][] = new int[N][N];
        boolean result = solveMazeUtil(maze , 0 , 0 , solution);
        return result;
    }

    private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {

        if(x == N - 1 && y == N - 1){
            return true;
        }

        if(isSafe( maze , x , y , solution)){

            solution[x][y] = 1;
            if(solveMazeUtil(maze , x + 1 , y , solution)){
                return true;

            }if(solveMazeUtil(maze , x  , y +1 , solution)){
                return true;
            }
            solution[x][y] = 0 ;
            return false;

        }
        return false;

    }

    private boolean isSafe(int[][] maze, int x, int y, int[][] solution) {
        if((x >= 0 || x < N) && (y >= 0 || y < N ) && maze[x][y] == 1){

            return true;
        }
        return false;
    }

}
