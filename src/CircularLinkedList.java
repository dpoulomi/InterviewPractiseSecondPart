import data.LinkedListNode;

public class CircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        LinkedListNode n4 =new LinkedListNode(45, null);
        LinkedListNode n5 =new LinkedListNode(35, n4);
        LinkedListNode n3 =new LinkedListNode(55, n4);
        LinkedListNode n2 =new LinkedListNode(65, n3);
        LinkedListNode n1 =new LinkedListNode(75, n2);
        LinkedListNode head = new LinkedListNode(85, n1);

        System.out.println("Given Linked list");
       // circularLinkedList.printList(head);
        head = circularLinkedList.cirularLoop(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        circularLinkedList.printList(head);
    }

    private void detectLoop(LinkedListNode ahead , LinkedListNode behind){

//        LinkedListNode ahead= head;
//        LinkedListNode behind = head;
        while (ahead != behind ){
            if(ahead.next!= null && ahead.next.next != null) {
                ahead = ahead.next.next;
            }
            if(behind.next!= null) {
                behind = behind.next;
            }
        }
    }

    private LinkedListNode cirularLoop(LinkedListNode head) {
        LinkedListNode ahead = head;
        LinkedListNode behind = head;
        detectLoop(ahead, behind);
        LinkedListNode root = head;
        int noOfNodes = getNumberOfNodes(ahead, behind) + 1;
        LinkedListNode startingNodeOfLoop = getStartingPointofLoop(root, behind);
        flattenLoop(noOfNodes, startingNodeOfLoop);
        return head;
    }

    private LinkedListNode getStartingPointofLoop(LinkedListNode head, LinkedListNode behind) {
        while (head != behind) {
            head = head.next;
            behind = behind.next;
        }
        return behind;
    }



    private void flattenLoop(int noOfNodes, LinkedListNode startingNode) {
        while (noOfNodes != 0) {
            startingNode = startingNode.next;
            noOfNodes--;
        }
        startingNode.next = null;

    }

    private int getNumberOfNodes(LinkedListNode ahead, LinkedListNode behind) {
        int counter = 0;
        ahead = ahead.next;
        while (ahead != null && ahead != behind) {
            ahead = ahead.next;
            counter++;
        }
        return counter;
    }

    void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
