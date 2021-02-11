package AmazonPrep;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class TresureIsland {

    public static void main(String[] args) {
        TresureIsland tresureIsland = new TresureIsland();
        Character[][] map = {{'O', 'O', 'O', 'O'},
                       {'D', 'O', 'D', 'O'},
                       {'O', 'O', 'O', 'O'},
                       {'X', 'D', 'D', 'O'}};

        System.out.println(tresureIsland.findShortestRouteToTreasure(map));
    }

    public int findShortestRouteToTreasure(Character[][] map){

        int count = 0;
        boolean visited[][] = new boolean[map.length][map[0].length];
        for(int i = 0 ; i < map.length ; i++){
            for(int j = 0 ; j < map[0].length ; j++){
                if(map[i][j].equals('X')){
                    return count;
                }
                if(visited[i][j] == false && map[i][j].equals('O')) {
                    visited[i][j] = true;
                    DFS(i, j, map, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFS(int i, int j, Character[][] map, boolean[][] visited) {

        List<Pair<Integer , Integer>> neighbours = getNeighbours(i , j , map , visited);
        for(Pair<Integer , Integer> pair : neighbours){
           int neighbouri = pair.getKey();
           int neighbourj = pair.getValue();
//            if(map[neighbouri][neighbourj].equals('X')){
//                return;
//            }
           if(map[neighbouri][neighbourj].equals('0')) {
               visited[neighbouri][neighbourj] = true;
               DFS(neighbouri, neighbourj, map, visited);
           }
        }
    }

    private List<Pair<Integer,Integer>> getNeighbours(int i, int j, Character[][] map, boolean[][] visited) {
        List<Pair<Integer , Integer>> neighbours = new ArrayList<>();

        if(isValid(i + 1 , j , map, visited)){
            neighbours.add(new Pair<>(i + 1 , j));
        }
        if(isValid(i , j + 1 , map, visited)){
            neighbours.add(new Pair<>(i  , j + 1));
        }
        if(isValid(i - 1 , j , map, visited)){
            neighbours.add(new Pair<>(i - 1 , j));
        }
        if(isValid(i, j - 1, map, visited)){
            neighbours.add(new Pair<>(i , j - 1));
        }

        return neighbours;

    }

    private boolean isValid(int i, int j, Character[][] map, boolean[][] visited) {
        return i > 0 && i< map.length && j > 0 && j < map[0].length && visited[i][j] == false;
    }
}
