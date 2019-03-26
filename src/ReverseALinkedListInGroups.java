import data.LinkedListNode;

public class ReverseALinkedListInGroups {

    public static void main(String[] args) {
        ReverseALinkedListInGroups reverseLinkedList= new ReverseALinkedListInGroups();
        LinkedListNode n5 =new LinkedListNode(35, null);
        LinkedListNode n4 =new LinkedListNode(45, n5);
        LinkedListNode n3 =new LinkedListNode(55, n4);
        LinkedListNode n2 =new LinkedListNode(65, n3);
        LinkedListNode n1 =new LinkedListNode(75, n2);
        LinkedListNode head = new LinkedListNode(85, n1);

        System.out.println("Given Linked list");
        reverseLinkedList.printList(head);
        int k = 4;
        head = reverseLinkedList.reverse(head , k);
        System.out.println("");
        System.out.println("Reversed linked list ");
        reverseLinkedList.printList(head);
    }

    private LinkedListNode reverse(LinkedListNode head , int k) {
        if(head == null) {
            return null;
        }
        LinkedListNode current = head;
        LinkedListNode next = null;
        LinkedListNode prev = null;
        while(k> 0 && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        if(next != null){
          LinkedListNode revesedNode =  reverse(next , 4);
          head.next = revesedNode;
        }


        return prev;

    }



    // prints content of double linked list
    void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
