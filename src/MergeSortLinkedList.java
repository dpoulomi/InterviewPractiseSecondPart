import data.LinkedListNode;

public class MergeSortLinkedList {

    private LinkedListNode root;

    public LinkedListNode mergeSort(LinkedListNode root) {
        if (root == null) {
            return null;
        }
        LinkedListNode middle = getMiddleNode(root);
        LinkedListNode nextToMiddle = middle.next;
        middle.next = null;

        LinkedListNode left = mergeSort(root);
        LinkedListNode right = mergeSort(nextToMiddle);
        LinkedListNode mergedList = sort(left, right);

        return mergedList;

    }



    private LinkedListNode sort(LinkedListNode left, LinkedListNode right) {
        LinkedListNode sortedNode = null;
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.data <= right.data) {

                sortedNode = left;
                sortedNode.next = sort(left.next , right);
        } else {
            sortedNode = right;
            sortedNode.next = sort(left , right.next);
        }
        return sortedNode;
    }

    private LinkedListNode getMiddleNode(LinkedListNode root) {
        LinkedListNode fastPtr = root.next;
        LinkedListNode slowPtr = root;
        while (fastPtr != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
            if (fastPtr != null) {
                fastPtr = fastPtr.next;
            }

        }
        return fastPtr;

    }
}
