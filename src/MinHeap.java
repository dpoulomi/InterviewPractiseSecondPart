import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> minHeap;

    public List<Integer> getMinHeap() {
        return minHeap;
    }

    public MinHeap() {
        this.minHeap = new ArrayList<>();
    }


    public int poll() {
        return minHeap.get(0);
    }

    public int size(){
        return minHeap.size();
    }

    public void add(int element) {
        minHeap.add(element);
        swim(minHeap.size() - 1);
    }

    public int delete() {
        int element = minHeap.get(0);
        minHeap.set(0, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);
        sink(0);
        return element;
    }

    private void sink(int elementIndex) {
        int leftChildIndex = getMeLeftChild(elementIndex);
        int rightChildIndex = getMeRightChild(elementIndex);
        int smallestIndex = getSmallestIndex(leftChildIndex, rightChildIndex);

        while (smallestIndex > -1 && (minHeap.get(smallestIndex) < minHeap.get(elementIndex))) {
            swap(smallestIndex, elementIndex);
            elementIndex = smallestIndex;
            leftChildIndex = getMeLeftChild(elementIndex);
            rightChildIndex = getMeRightChild(elementIndex);
            smallestIndex = getSmallestIndex(leftChildIndex, rightChildIndex);
        }
    }

    // get me the index of the largest between left child value and right child value
    private int getSmallestIndex(int leftChildIndex, int rightChildIndex) {
        // if left childIndex is inside the heap
        if(leftChildIndex > minHeap.size() - 1) {
            return -1;
        }

        // if right childIndex is inside the heap
        if(rightChildIndex > minHeap.size() - 1) {
            return leftChildIndex;
        }

        return minHeap.get(leftChildIndex) < minHeap.get(rightChildIndex) ?
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
        while (parentIndex > -1 && minHeap.get(parentIndex) > minHeap.get(elementIndex)) {
            swap(parentIndex, elementIndex);
            elementIndex = parentIndex;
            parentIndex = getMeParent(elementIndex);

        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int firstElement = minHeap.get(firstIndex);
        minHeap.set(firstIndex, minHeap.get(secondIndex));
        minHeap.set(secondIndex, firstElement);
    }

    private int getMeParent(int elementIndex) {
        return (elementIndex - 1) / 2;
    }


}
