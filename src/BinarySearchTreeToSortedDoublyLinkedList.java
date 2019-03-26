import data.TreeNode;

public class BinarySearchTreeToSortedDoublyLinkedList {

    TreeNode prev = null;
    static TreeNode head = null;
    public static void main(String[] args) {
        BinarySearchTreeToSortedDoublyLinkedList binarySearchTreeToSortedDoublyLinkedList = new BinarySearchTreeToSortedDoublyLinkedList() ;


        TreeNode n6 = new TreeNode(11,null, null);
        TreeNode n5 = new TreeNode(9,null, null);

        TreeNode n3 = new TreeNode(5,null, null);
        TreeNode n4 = new TreeNode(7,null, null);
        TreeNode n2 = new TreeNode(10,n5, n6);
        TreeNode n1 = new TreeNode(6,n3, n4);
        TreeNode root = new TreeNode(8,n1, n2);

        binarySearchTreeToSortedDoublyLinkedList.createdDoublyLinkedList(root);
        binarySearchTreeToSortedDoublyLinkedList.printList(head);
    }



    void printList(TreeNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }


    public void createdDoublyLinkedList(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            createdDoublyLinkedList(root.left);
        }
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        if (root.right != null) {
            createdDoublyLinkedList(root.right);
        }
    }
}
