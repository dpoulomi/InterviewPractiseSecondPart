package AmazonPrep;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreasureIslandUsingBFS {


//    public static void main(String[] args) {
//        TreasureIslandUsingBFS tresureIsland = new TreasureIslandUsingBFS();
//        Character[][] map = {{'O', 'O', 'O', 'O'},
//                {'D', 'O', 'D', 'O'},
//                {'O', 'O', 'O', 'O'},
//                {'X', 'D', 'D', 'O'}};
//
//        System.out.println(tresureIsland.findMinimumSteps(map));
//    }

    // "static void main" must be defined in a public class.

        public static void main(String[] args) {
            char[][] grid = {{'O', 'O', 'O', 'O'},
                    {'D', 'O', 'D', 'O'},
                    {'O', 'O', 'O', 'O'},
                    {'X', 'D', 'D', 'O'}};
            int step = new TreasureIslandUsingBFS().getMinStep(grid);
            System.out.println("step: " + step);
        }

        public int getMinStep(char[][] grid) {
            char[][] visited = grid.clone();
            visited[0][0] = 'D';

            int m = visited.length, n = visited[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            int step = 0;
            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            while(!queue.isEmpty()) {
                step ++;
                for(int size = queue.size(); size > 0; size--) {
                    int[] cur = queue.poll();
                    for(int[] dir: dirs) {
                        int dx = cur[0] + dir[0];
                        int dy = cur[1] + dir[1];
                        if(dx >= 0 && dx < m && dy >= 0 && dy < n && visited[dx][dy] != 'D') {
                            if(grid[dx][dy] == 'X') return step;
                            visited[dx][dy] = 'D';
                            queue.offer(new int[]{dx, dy});
                        }
                    }
                }
            }
            return -1;
        }
    }



//    public int findMinimumSteps(Character[][] island) {
//        boolean visited[][] = new boolean[island.length][island[0].length];
//
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair<>(0, 0));
//        visited[0][0] = true;
//        int steps = 0;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Pair<Integer, Integer> index = queue.poll();
//                int x = index.getKey();
//                int y = index.getValue();
//                if (island[x][y].equals('X')) {
//                    return steps;
//                }
//                List<Pair<Integer, Integer>> neighbours = getValidNeighbours(x, y, island, visited);
//                for (int j = 0; j < neighbours.size(); j++) {
//
//                    if (island[neighbours.get(j).getKey()][neighbours.get(j).getValue()] == '0') {
//
//                        queue.add(neighbours.get(j));
//                    }
//                }
//            }
//            steps++;
//        }
//        return steps;
//    }
//
//
//    private List<Pair<Integer, Integer>> getValidNeighbours(int i, int j, Character[][] map, boolean[][] visited) {
//        List<Pair<Integer, Integer>> neighbours = new ArrayList<>();
//
//        if (isValid(i + 1, j, map, visited)) {
//            neighbours.add(new Pair<>(i + 1, j));
//        }
//        if (isValid(i, j + 1, map, visited)) {
//            neighbours.add(new Pair<>(i, j + 1));
//        }
//        if (isValid(i - 1, j, map, visited)) {
//            neighbours.add(new Pair<>(i - 1, j));
//        }
//        if (isValid(i, j - 1, map, visited)) {
//            neighbours.add(new Pair<>(i, j - 1));
//        }
//
//        return neighbours;
//
//    }
//
//    private boolean isValid(int i, int j, Character[][] map, boolean[][] visited) {
//        return i > 0 && i < map.length && j > 0 && j < map[0].length && visited[i][j] == false && !map[i][j].equals('D');
//    }
//}
//
//}



