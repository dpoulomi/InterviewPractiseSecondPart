import data.LinkedListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList= new ReverseLinkedList();
        LinkedListNode n4 =new LinkedListNode(45, null);
        LinkedListNode n3 =new LinkedListNode(55, n4);
        LinkedListNode n2 =new LinkedListNode(65, n3);
        LinkedListNode n1 =new LinkedListNode(75, n2);
        LinkedListNode head = new LinkedListNode(85, n1);

        System.out.println("Given Linked list");
        reverseLinkedList.printList(head);
        head = reverseLinkedList.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        reverseLinkedList.printList(head);
    }

    private LinkedListNode reverse(LinkedListNode head) {
      //   85-->75-->65-->55-->45

        LinkedListNode prev = null;
        LinkedListNode curr = head;
        LinkedListNode next = null;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr= next;

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
