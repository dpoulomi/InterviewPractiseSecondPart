import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {


    public class QueueEntry{

        int vertex = 0 ;
        int distance = 0;

    }

    public static void main(String[] args)
    {

        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
//        moves[2] = 18;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                snakeAndLadder.getMinimumNoOfMoves(moves, N));
    }

    public int getMinimumNoOfMoves(int move[], int n){


        int[] visited = new int[n];
        Queue<QueueEntry> queue = new LinkedList<>();
        QueueEntry q  = new QueueEntry();
        q .vertex = 0 ;
        q .distance = 0 ;
        queue.add(q );
        visited[0] = 1;

        while (!queue.isEmpty()){
             q = queue.remove();
            int vertex = q.vertex;
            if(vertex == n - 1){
                break;
            }
            for(int j = vertex + 1; j <= vertex + 6 && j < n;  j++ ){
                if(visited[j] == 0){
                    QueueEntry queueEntry = new QueueEntry();
                    queueEntry.distance = q.distance + 1;
                    visited[j] = 1;
                    if(move[j] != -1){
                        queueEntry.vertex = move[j];
                   }else{

                        queueEntry.vertex = j;
                    }
                    queue.add(queueEntry);

                }
            }

        }

        return q.distance;


    }
}
