import java.util.ArrayList;
import java.util.List;

public class MaxHeapImplementation {

    List<Integer> maxheap = new ArrayList<>();


    public void add(int num) {
        maxheap.add(num);
        swim();

    }

    private void swim() {
        int childIndex = maxheap.size()-1;
        int parentIndex = (childIndex - 1 )/ 2;
        while (parentIndex > -1 && maxheap.get(parentIndex) < maxheap.get(childIndex)) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1 )/ 2;
        }
    }

    private void swap(int parentIndex, int childIndex) {
        int temp = maxheap.get(parentIndex);
        maxheap.set(parentIndex, maxheap.get(childIndex));
        maxheap.set(childIndex, temp);
    }

    public void delete() {
        int popped = maxheap.remove(0);
        maxheap.add(0, maxheap.get(maxheap.size() - 1));
        sink();
    }

    public int peek(){
        return maxheap.size() > 0 ? maxheap.get(0) : -1 ;
    }

    private void sink() {
        int parentIndex = 0;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        int largestIndex = getLargestIndex(leftIndex, rightIndex);
        while (largestIndex > -1 && maxheap.get(parentIndex) < maxheap.get(largestIndex)) {
            swap(parentIndex, largestIndex);
        }
        parentIndex = largestIndex;
        leftIndex = 2 * parentIndex + 1;
        rightIndex = 2 * parentIndex + 2;
        largestIndex = getLargestIndex(leftIndex, rightIndex);

    }

    private int getLargestIndex(int leftIndex, int rightIndex) {
        if (leftIndex > maxheap.size() - 1) {
            return -1;
        } else if (rightIndex > maxheap.size() - 1) {
            return leftIndex;
        } else {
            return maxheap.get(leftIndex) > maxheap.get(rightIndex) ? leftIndex : rightIndex;
        }
    }

}
