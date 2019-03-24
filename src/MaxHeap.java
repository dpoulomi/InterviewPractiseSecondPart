import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

    private List<Integer> maxHeap;

    public MaxHeap() {
        this.maxHeap = new ArrayList<>();
    }

    public List<Integer> getMaxHeap() {
        return maxHeap;
    }

    public int poll() {
        return maxHeap.get(0);
    }

    public void add(int element) {
        maxHeap.add(element);
        swim(maxHeap.size() - 1);
    }

    public void delete() {
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(maxHeap.size() - 1);
        sink(0);
    }

    private void sink(int elementIndex) {
        int leftChildIndex = getMeLeftChild(elementIndex);
        int rightChildIndex = getMeRightChild(elementIndex);
        int largestIndex = getLargestIndex(leftChildIndex, rightChildIndex);

        while (largestIndex > -1 && (maxHeap.get(largestIndex) > maxHeap.get(elementIndex))) {
            swap(largestIndex, elementIndex);
            elementIndex = largestIndex;
            leftChildIndex = getMeLeftChild(elementIndex);
            rightChildIndex = getMeRightChild(elementIndex);
            largestIndex = getLargestIndex(leftChildIndex, rightChildIndex);
        }
    }

    // get me the index of the largest between left child value and right child value
    private int getLargestIndex(int leftChildIndex, int rightChildIndex) {
        // if left childIndex is inside the heap
        if(leftChildIndex > maxHeap.size() - 1) {
            return -1;
        }

        // if right childIndex is inside the heap
        if(rightChildIndex > maxHeap.size() - 1) {
            return maxHeap.get(leftChildIndex);
        }

        return maxHeap.get(leftChildIndex) > maxHeap.get(rightChildIndex) ?
                leftChildIndex :
                rightChildIndex;
    }

    private int getMeLeftChild(int elementIndex) {

        return (2 * elementIndex) + 1;
    }

    private int getMeRightChild(int elementIndex) {
        return (2 * elementIndex) + 2;
    }


    private void swim(int elementIndex) {
        int parentIndex = getMeParent(elementIndex);
        while (parentIndex > -1 && maxHeap.get(parentIndex) < maxHeap.get(elementIndex)) {
            swap(parentIndex, elementIndex);
            elementIndex = parentIndex;
            parentIndex = getMeParent(elementIndex);

        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int firstElement = maxHeap.get(firstIndex);
        maxHeap.set(firstIndex, maxHeap.get(secondIndex));
        maxHeap.set(secondIndex, firstElement);
    }

    private int getMeParent(int elementIndex) {
        return (elementIndex - 1) / 2;
    }


}

