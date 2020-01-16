import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {

    //0 obstacle and 1 path

    class Path{

        int i  ;

        int j ;

        public Path(int i , int j){
            this.i = i ;

            this.j = j;

        }

    }

    public static void main(String[] args) {
        int[][] grid = {{1 , 1 , 0 , 0},
                        {1 , 1 , 1 , 1},
                        {0 , 0, 1 ,1 },
                        {0 , 0 , 0 , 1}};
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        List<Path> paths = robotInAGrid.findPath(grid);
        if(paths!= null){
          paths.stream().forEach(e -> System.out.println(e.i + "," + e.j));
        }
    }
    public List<Path> findPath(int[][] grid){
        int i = 0 ;
        int j = 0 ;
        List<Path> path = new ArrayList<>();
        path.add(new Path(0 , 0));
        while(i < grid.length - 1 || j < grid[0].length - 1){

                if(j <grid[0].length - 1 && grid[i][j+1] == 1){
                    j ++;
                    path.add(new Path(i , j));
                }else if(i < grid.length - 1 && grid[i + 1][j] == 1){
                    i ++;
                    path.add(new Path(i , j));
                }else{

                  return null;

                }


        }

        return path;

    }
}
