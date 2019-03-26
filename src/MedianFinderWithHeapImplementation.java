import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinderWithHeapImplementation {




    public static void main(String[] args) {
        int stream[] = {1, 4, 6 , 7, 9, 0 , 3, 5 ,13, 12, 10};
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();
        MedianFinderWithHeapImplementation medianFinder = new MedianFinderWithHeapImplementation();

        for (int i = 0 ; i< stream.length ; i++){
            medianFinder.addNumber(stream[i] , maxHeap , minHeap);
            double median = medianFinder.findMedian(maxHeap, minHeap);
            System.out.println(median);
        }
    }

    private double findMedian(MaxHeap maxHeap, MinHeap minHeap) {

        if(minHeap.size()> maxHeap.size()){
            return minHeap.poll();
        }else{
            return (minHeap.poll() + maxHeap.poll())/2.0;
        }
    }

    private void addNumber(int element , MaxHeap maxHeap , MinHeap minHeap) {
        minHeap.add(element);
        maxHeap.add(minHeap.delete());
        if(minHeap.size() < maxHeap.size()){
            minHeap.add(maxHeap.delete());

        }
    }

}
