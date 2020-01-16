package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {


    private List<Integer> elements = new ArrayList<>();


    public void insert(int element) {
        elements.add(element);
        swim();
    }

    public void delete() {
        elements.remove(0);
        elements.add(0, elements.remove(elements.size() - 1));
        sink();

    }

    public int printElement() {
        return elements.get(0);
    }

    public void swim() {

        int childIndex = elements.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (elements.get(parentIndex) < elements.get(childIndex)) {
            swap(parentIndex, childIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;

        }

    }

    private void swap(int parentIndex, int childIndex) {
        int temp = elements.get(parentIndex);

        elements.set(parentIndex, elements.get(childIndex));
       // elements.remove(childIndex);
        elements.set(childIndex, temp);

    }


    public void sink() {
        int parentIndex = 0;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int greaterChildIndex = getLargerChildIndex(leftChildIndex, rightChildIndex);

        while (greaterChildIndex < elements.size() - 1 && greaterChildIndex >=0 && elements.get(greaterChildIndex) > elements.get(parentIndex)) {
            swap(greaterChildIndex, parentIndex);
            parentIndex = greaterChildIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
            greaterChildIndex = getLargerChildIndex(leftChildIndex, rightChildIndex);
        }

    }

    public int getLargerChildIndex(int leftChildIndex, int rightChildIndex) {

        if(rightChildIndex >= elements.size() && leftChildIndex >= elements.size()){
            return -1;
        }else if(rightChildIndex >= elements.size()){
            return leftChildIndex;
        }
        return elements.get(leftChildIndex) > elements.get(rightChildIndex) ? leftChildIndex : rightChildIndex;
    }


}
