
package MSPrep;
import java.util.*;

class ShiftLinkedList {
    public static LinkedList shiftList(LinkedList head, int k) {
        // Write your code here.
        if(head.next == null){
            return head;
        }

        LinkedList list = head;

        int noOfNodes = 0;
        while (list != null){
            list = list.next;
            noOfNodes++;


        }
        int nodesToNavigate = noOfNodes - k;
        list = head;
        while(nodesToNavigate > 1){

            head = head.next;
            nodesToNavigate --;
        }
        LinkedList firstNode = head.next;
        head.next = null;
        LinkedList temp = firstNode;
        while(temp.next != null) {
            temp = temp.next;

        }
        temp.next = list;



        return firstNode;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    //0 - 1 -2 - 3 - 4 - 5 - 6
    //temp -- 5 - 6
    //list - 4 -- null
    public static void main(String[] args) {
        LinkedList head = new LinkedList(0);
        LinkedList next1 = new LinkedList(1);

        head.next = next1;
        LinkedList next2 = new LinkedList(2);
        next1.next = next2;
        LinkedList next3 = new LinkedList(3);
        next2.next = next3;
        LinkedList next4 = new LinkedList(4);
        next3.next = next4;
        LinkedList next5 = new LinkedList(5);
        next4.next = next5;
        LinkedList next6 = new LinkedList(6);
        next5.next = next6;
        ShiftLinkedList shiftLinkedList = new ShiftLinkedList();
         head  = shiftLinkedList.shiftList(head, 7);
         shiftLinkedList.print(head);
    }

    private void print(LinkedList head) {
        while(head != null){

            System.out.print(head.value + " --->");
            head = head.next;
        }
    }
}
