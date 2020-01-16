import java.util.Deque;
import java.util.LinkedList;

public class MaximumInAQueue {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 2 , 6, 3 ,1, 5 ,4} ;//{2, 3, 4, 2, 6, 2, 5, 1};
        int slidingWindow = 4;
        MaximumInAQueue maximumInQueue = new MaximumInAQueue();
        maximumInQueue.maximumInAQueue(arr, slidingWindow);


    }

    public void maximumInAQueue(int[] array , int slidingWindowSize){
        //2 3 4 2 6 2 5 1

//        Deque<Integer> deque = new LinkedList<>();
//
//        for(int i = 0 ; i < slidingWindowSize ; i++){
//            while (!deque.isEmpty() && array[i] > deque.peek()){
//                deque.removeLast();
//            }
//            deque.addLast(i);
//        }
//        System.out.println(deque.peek());
//        for(int i = slidingWindowSize ; i < array.length ; i++){
//            while(!deque.isEmpty() && deque.peek() <  array[i]){
//                deque.remove();
//
//            }
//            while (!deque.isEmpty() && (i - deque.peek()) < array[i] &&  == slidingWindowSize) {
//              deque.removeLast();
//            }
//            deque.addLast(i);
//            System.out.println(deque.peek());
//        }
    }
}
