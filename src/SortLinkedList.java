import data.LinkedListNode;

public class SortLinkedList {

    //2 1 4 3
    //1 2 4 3
    public LinkedListNode sort(LinkedListNode head) {
        if(head == null){
            return null;
        }

        LinkedListNode middle = getMiddle(head);
        LinkedListNode nextToMiddle = middle.next;
        middle.next = null;

        LinkedListNode left = sort(head);
        LinkedListNode right = sort(nextToMiddle);

        LinkedListNode sortedList = mergetSort(left , right);
        return sortedList;
    }

    private LinkedListNode mergetSort(LinkedListNode left, LinkedListNode right) {
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        LinkedListNode sortedList = null;
        if(left.data < right.data){
            sortedList = left;
            sortedList.next = mergetSort(left.next , right);
        }else{
            sortedList = right;
            sortedList.next = mergetSort(left , right.next);
        }
        return sortedList;
    }

    private LinkedListNode getMiddle(LinkedListNode head) {
        LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head.next;
        while(fastPtr != null){
            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
                slowPtr = slowPtr.next;
            }
        }
        return slowPtr;

    }

}


