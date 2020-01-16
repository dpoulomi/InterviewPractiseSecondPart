import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RoadsAndLibraries {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            System.out.println("Q :: " + qItr);
            String[] nmC_libC_road = scanner.nextLine().split(" ");
            System.out.println(nmC_libC_road[0]);

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            try {

                for (int i = 0; i < m; i++) {
                    String[] citiesRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 2; j++) {
                        int citiesItem = Integer.parseInt(citiesRowItems[j]);
                        cities[i][j] = citiesItem;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            long result = new RoadsAndLibraries().roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }


    /*public static void main(String[] args) {
        int[][] cities = {{1 , 2} , { 1 , 3} , {1 , 4}};
        int noOfCity = 5;
        int costOfLibrary = 6;
        int costOfCity = 1;
        System.out.print(roadsAndLibraries(noOfCity , costOfLibrary , costOfCity , cities));
    }*/



    long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        long costOfLibrary = (long)c_lib;
        long costOfRoad = (long)c_road;
        List<Integer>[] vertices = new ArrayList[n];
        boolean[] visited = new boolean[n];

        if (c_lib <= c_road) {
            return (costOfLibrary * (long)n);
        } else {
            long numberOfDisjointCities = findDisjoint(cities, n, visited, vertices);
            return numberOfDisjointCities * costOfLibrary + (n - numberOfDisjointCities) * costOfRoad;

        }

    }

    private long findDisjoint(int[][] cities ,
                                     int n,
                                     boolean[] visited,
                                     List<Integer>[] vertices) {
        long count = 0L;
        add(cities , n, vertices);
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                DFS(visited, i, vertices);
                count++;
            }
        }

    return count;
    }

    private void DFS( boolean[] visited ,
                             int city,
                             List<Integer>[] vertices) {
       visited[city ] = true;
       List<Integer> list = vertices[city];
       Iterator<Integer> iter = list.iterator();
       while(iter.hasNext()){
           int i = iter.next();
           if(!visited[i]){
               DFS(visited , i, vertices);
           }
       }
    }

    public void add(int[][] cities , int n, List<Integer>[] vertices){
        for(int i = 0 ; i < n ; i ++){
            vertices[i] = new ArrayList<>();
        }

        for(int i = 0 ; i  < cities.length ; i++){
            vertices[cities[i][0] - 1].add(cities[i][1] - 1);
            vertices[cities[i][1] - 1].add(cities[i][0] - 1);

        }

    }
}
