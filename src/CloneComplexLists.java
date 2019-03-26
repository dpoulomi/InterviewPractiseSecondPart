import data.LinkedListNode;
import sun.awt.image.ImageWatched;

public class CloneComplexLists {

    public static void main(String[] args) {



        LinkedListNode n5 =new LinkedListNode(35, null);
        LinkedListNode n4 =new LinkedListNode(45, n5);
        LinkedListNode n3 =new LinkedListNode(55, n4);
        LinkedListNode n2 =new LinkedListNode(65, n3);
        LinkedListNode n1 =new LinkedListNode(75, n2);
        n1.arbitrary = n3;

        n4.arbitrary = n1;
        n2.arbitrary = n5;
        LinkedListNode head = new LinkedListNode(85, n1);

        CloneComplexLists cloneComplexLists = new CloneComplexLists();
        LinkedListNode clonedList = cloneComplexLists.cloneLists(head);
        cloneComplexLists.printLinkedList(head);
        cloneComplexLists.printLinkedList(clonedList);
    }

    private void printLinkedList(LinkedListNode clonedList) {
        while(clonedList != null){
            System.out.println(clonedList.data);
            clonedList = clonedList.next;
        }
    }

    private LinkedListNode cloneLists(LinkedListNode head) {
        //copy each nnode copy
        LinkedListNode original = head;
        LinkedListNode temp = null;
        while(original!= null) {
            temp = original.next;
            original.next = new LinkedListNode(original.data , temp) ;
            original = temp;
        }
        //link the arbit pointers
        original = head;
        while(original != null){
            original.next.arbitrary = original.arbitrary !=null ? original.arbitrary.next:original.arbitrary;
            original = original.next != null ? original.next.next : original.next;
        }
        original = head;
        LinkedListNode copy = original.next;
        temp = copy;
        while(original != null){
            original.next = original.next != null ? original.next.next : original.next;
           copy.next = original.next;
           original = original.next;
           copy = copy.next;
        }
        return temp;
    }
}
