import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {



    public static void main(String[] args) {
        int arr[] = {1, 4, 6 , 7, 9, 0 , 3, 5 ,13, 12, 10};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap =  new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0 ; i< arr.length ; i++){
            MedianFinder medianFinder = new MedianFinder();
            medianFinder.addNum(arr[i], maxHeap, minHeap);
            System.out.println(medianFinder.findMedian(maxHeap, minHeap));

        }
    }



    public void addNum(int num , PriorityQueue<Integer> maxHeap , PriorityQueue<Integer> minHeap) {

        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian(PriorityQueue<Integer> maxHeap , PriorityQueue<Integer> minHeap) {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}