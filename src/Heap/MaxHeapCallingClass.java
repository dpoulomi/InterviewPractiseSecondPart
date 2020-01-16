package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeapCallingClass {

    private MaxHeap maxHeap = new MaxHeap();

    public static void main(String[] args) {
        MaxHeapCallingClass maxHeapCallingClass = new MaxHeapCallingClass();
        maxHeapCallingClass.insertElementToHeap();
        maxHeapCallingClass.deleteElementFromHeap();
        maxHeapCallingClass.deleteElementFromHeap();
    }

    private void deleteElementFromHeap() {
        maxHeap.delete();
        System.out.println(maxHeap.printElement());
    }

    private void insertElementToHeap() {

        maxHeap.insert(2);
        maxHeap.insert(11);
        maxHeap.insert(4);
        maxHeap.insert(5);
        maxHeap.insert(6);
        maxHeap.insert(12);

        System.out.println(maxHeap.printElement());

    }
}
