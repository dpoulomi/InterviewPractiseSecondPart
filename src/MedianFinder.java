import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MedianInAStream {

    public class ReverseComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2) {
            int num1 = o1.intValue();
            int num2 = o2.intValue();
            if (num1 > num2) {
                return -1;
            } else if (num1 < num2) {
                return 1;
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 7, 9, 0, 3, 5, 13, 12, 10};
        MedianInAStream medianInAStream = new MedianInAStream();
        medianInAStream.findMedian(num);
    }

    private void findMedian(int num) PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}

