package DynammicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfJumps {

    public class QueueEntry {
        int vertex = 0 ;
        int jumps = 0 ;
    }

    public int getMinimumNumberOfJumps(int arr[] ){
        Queue<QueueEntry> queue = new LinkedList<>();
        QueueEntry q = new QueueEntry();
        q.vertex = arr[0] ;
        q.jumps = 0 ;
        queue.add(q);
        while(!queue.isEmpty()){
            q = queue.remove();
            int vertex = q.vertex;
            if(vertex == arr.length - 1){
                break;
            }
            for(int i = vertex ; i <= vertex + vertex ; i++ ){
                QueueEntry qEntry = new QueueEntry();
                qEntry.jumps = q.jumps + 1;
                qEntry.vertex = arr[i];
                queue.add(qEntry);
            }
        }
        return q.jumps;
    }

    public static void main(String[] args) {
        MinimumNumberOfJumps minimumNumberOfJumps = new MinimumNumberOfJumps();
        int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minimumNumberOfJumps.getMinimumNumberOfJumps(arr));
    }
}
