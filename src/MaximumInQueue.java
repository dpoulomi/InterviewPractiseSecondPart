import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumInQueue {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 2, 6, 2, 5, 1};
        int queueSize = 3;
        MaximumInQueue maximumInQueue = new MaximumInQueue();
        maximumInQueue.getWindow(arr, queueSize);


    }

    private static void getWindow(int[] arr, int queueSize) {
        Deque<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < queueSize; i++) {

            while (!maxQueue.isEmpty() && maxQueue.peekLast()<arr[i]){
                maxQueue.removeLast();
                maxQueue.addLast(arr[i]);
            }
        }
        for(int i = queueSize ; i<= arr.length-1 ; i++){
            System.out.println(maxQueue.peek());
            while((!maxQueue.isEmpty()) && maxQueue.peek() <= i-queueSize)
                maxQueue.removeFirst();


            while((!maxQueue.isEmpty()) && arr[i] >= arr[maxQueue.peekLast()])
                maxQueue.removeLast();



            maxQueue.addLast(i);

        }
        System.out.println(maxQueue.peek());

    }

    private static void addToMaxQueue(int element, Deque<Integer> maxQueue, int queueSize) {
        if (maxQueue.size() < queueSize) {
//            if(maxQueue.size() == 0){
//                maxQueue.push(element);
//            }else{
//                int ele = maxQueue.peekFirst();
//                if(ele < element){
//                    maxQueue.addFirst(element);
//                }else{
//                    maxQueue.addLast(element);
//                }
//
//            }
            maxQueue.push(element);
        } else {
            int ele = maxQueue.peekFirst();
            if (ele < element) {

                        maxQueue.addFirst(element);
            } else {
                maxQueue.addLast(element);
            }

        }
    }
}
