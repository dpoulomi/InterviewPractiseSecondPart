import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionMedian {

    private static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

   static class ReverseComparator implements Comparator<Integer> {


        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1.compareTo(o2) > 0){
                return  1;
            }else if(o1.compareTo(o2) < 0){
                return -1;
            }else {
                return 0;
            }
        }
    }

    public static void addNo(int i ){
        minQueue.add(i);
        maxQueue.add(minQueue.poll());
        if(minQueue.size() < maxQueue.size()){
            minQueue.add(maxQueue.poll());

        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 4};
         int d = 4;
        System.out.print(activityNotifications(arr , d));
    }

    public static double findMedian(){
        if(minQueue.size() > maxQueue.size()){
            return minQueue.peek();
        }else {
            return (minQueue.peek()+minQueue.peek())/2.0;
        }
    }

    static int activityNotifications(int[] expenditure, int d) {
        int noOfNotifications = 0 ;
        for(int i = 0 ; i < expenditure.length ; i++){

            if(i  >= d){
               double median = findMedian();
               if(expenditure[i] >= 2 * median){
                   noOfNotifications++;
               }
            }
            addNo(expenditure[i]);
        }
        return noOfNotifications;
    }

    }

