//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.regex.*;
//
//public class Solution2 {
//
//    // Complete the findShortest function below.
//
//    /*
//     * For the unweighted graph, <name>:
//     *
//     * 1. The number of nodes is <name>Nodes.
//     * 2. The number of edges is <name>Edges.
//     * 3. An edge exists between <name>From[i] to <name>To[i].
//     *
//     */
//    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
//        // solve here
//        List<Integer>[] nodeColorPair =  new ArrayList[graphNodes];
//        boolean[] visited = new boolean[graphNodes];
//        createGraph(nodeColorPair , graphFrom , graphTo , val);
//        int path = navigateToFindPath( nodeColorPair , visited , ids , val);
//        return path;
//
//    }
//
//    public boolean checkIfColorPresent(long[] ids, int val){
//        int startIndex = -1 ;
//        int endIndex =  -1 ;
//        int count = 0;
//        int min_Edge = -1;
//        for(int i = 0 ; i< ids.length ; i++){
//            if(ids[i] == val){
//                startIndex = i;
//                break;
//            }
//        }
//        for(int i = startIndex+1 ; i< ids.length ; i++){
//            if(ids[i] == val){
//                endIndex = i;
//                break;
//            }
//        }
//        return true;
//    }
//
//    private static int navigateToFindPath(List<Integer>[] nodeColorPair, boolean[] visited, long[] ids, int val) {
//        int startIndex = -1 ;
//        int endIndex =  -1 ;
//        int count = 0;
//        int min_Edge = -1;
//        for(int i = 0 ; i< ids.length ; i++){
//            if(ids[i] == val){
//                startIndex = i;
//                break;
//            }
//        }
//        for(int i = startIndex+1 ; i< ids.length ; i++){
//            if(ids[i] == val){
//                endIndex = i;
//                break;
//            }
//        }
//        if(startIndex > - 1 && endIndex > -1){
//            min_Edge = DFS(nodeColorPair , visited , ids , val , count , startIndex , endIndex, min_Edge);
//        }
//
//        return min_Edge;
//    }
//
//    private static int DFS(List<Integer>[] nodeColorPair, boolean[] visited, long[] ids, int val ,int count ,
//                            int startIndex , int endIndex , int min_Edge) {
//
//       int[] distance = new int[visited.length];
//       visited[startIndex] = true;
//       Queue<Integer> queue = new LinkedList<>();
//       queue.add(startIndex);
//        distance[startIndex] = 0 ;
//       while(!queue.isEmpty()){
//           int num = queue.peek();
//           queue.poll();
//           List<Integer> connectedNodesList = nodeColorPair[num];
//           for(Integer element : connectedNodesList){
//               if(!visited[element]){
//                    visited[element] = true;
//                    queue.add(element);
//                    distance[element] = distance[num] + 1;
//
//               }
//
//           }
//
//
//           }
//           return distance[endIndex];
//       }
//
//
//    private static void createGraph(List<Integer>[] nodeColorPair, int[] graphFrom, int[] graphTo, int val) {
//        for(int i = 0 ; i < nodeColorPair.length ; i++){
//            nodeColorPair[i] = new ArrayList<>();
//        }
//
//        for(int i = 0 ; i < graphFrom.length ; i++){
//            nodeColorPair[graphFrom[i] - 1].add(graphTo[i] - 1);
//            nodeColorPair[graphTo[i] - 1].add(graphFrom[i] - 1);
//        }
//
//
//    }
//
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));
//        String[] graphNodesEdges = scanner.nextLine().split(" ");
//        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
//        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());
//
//        int[] graphFrom = new int[graphEdges];
//        int[] graphTo = new int[graphEdges];
//
//        for (int i = 0; i < graphEdges; i++) {
//            String[] graphFromTo = scanner.nextLine().split(" ");
//            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
//            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
//        }
//
//        long[] ids = new long[graphNodes];
//
//        String[] idsItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < graphNodes; i++) {
//            long idsItem = Long.parseLong(idsItems[i]);
//            ids[i] = idsItem;
//        }
//
//        int val = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);
//
//        bufferedWriter.write(String.valueOf(ans));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
//}
