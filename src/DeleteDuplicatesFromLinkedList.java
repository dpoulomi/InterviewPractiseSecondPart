import data.LinkedListNode;
import data.LinkedListNode;

public class DeleteDuplicatesFromLinkedList {

    public static void main(String[] args) {
        DeleteDuplicatesFromLinkedList deleteDuplicatesFromLinkedList = new DeleteDuplicatesFromLinkedList();
        LinkedListNode n7 = new LinkedListNode(9, null);
        LinkedListNode n6 = new LinkedListNode(9, n7);
        LinkedListNode n5 = new LinkedListNode(5, n6);
        LinkedListNode n4 = new LinkedListNode(3, n5);
        LinkedListNode n3 = new LinkedListNode(3, n4);
        LinkedListNode n2 = new LinkedListNode(2, n3);
        LinkedListNode n1 = new LinkedListNode(1, n2);
        LinkedListNode withoutDuplicate = deleteDuplicatesFromLinkedList.delete(n1);
        deleteDuplicatesFromLinkedList.printList(withoutDuplicate);
    }

    void printList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private LinkedListNode delete(LinkedListNode root) {
        if (root == null) {
            return null;
        }
        LinkedListNode node = root;
        LinkedListNode next = node.next;
        LinkedListNode prev = null;
        while (node != null && node.next != null) {
            boolean duplicate = false;
            if (node.data == node.next.data) {
                duplicate = true;
            }
            if (!duplicate) {
                prev = node;
                node = node.next;
            } else {
                int value = node.data;
                LinkedListNode nodeToDelete = node;
                while (nodeToDelete != null && nodeToDelete.data == value) {
                    next = nodeToDelete.next;
                    nodeToDelete = null;
                    nodeToDelete = next;
                }
                if (prev == null) {
                    root = next;
                } else {
                    prev.next = next;

                }
                node = next;
            }
        }
        return root;
    }
}
