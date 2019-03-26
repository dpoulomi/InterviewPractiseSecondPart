import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowRepeat {


    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 2 , 6, 3 ,1, 5 ,4} ;//{2, 3, 4, 2, 6, 2, 5, 1};
        int slidingWindow = 4;
        SlidingWindowRepeat maximumInQueue = new SlidingWindowRepeat();
        maximumInQueue.getWindow(arr, slidingWindow);


    }

    //2 3 4
    private void getWindow(int[] arr, int slidingWindow) {
        Deque<Integer> deque = new LinkedList<>();
        for(int i= 0 ; i< slidingWindow; i++){
            while (!deque.isEmpty() && arr[i] > arr[deque.peekFirst()]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.println(arr[deque.peek()]);

        for(int i= slidingWindow ; i< arr.length; i++) {

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()] && (i - deque.peekLast() < slidingWindow)) {
                deque.removeLast();
            }
            while (!deque.isEmpty() && (i - deque.peek() >= slidingWindow)) {
                deque.removeFirst();
            }
            deque.addLast(i);

            System.out.println(arr[deque.peek()]);


        }
    }
}
