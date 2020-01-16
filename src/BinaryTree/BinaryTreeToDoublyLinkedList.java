package BinaryTree;

import data.TreeNode;

public class BinaryTreeToDoublyLinkedList {

    private TreeNode head = null;

    private TreeNode prev = null;
    public void convertBinaryTreeToDoublyLinkedList(TreeNode treeRoot){

        if(treeRoot == null){
            return;
        }

        convertBinaryTreeToDoublyLinkedList(treeRoot.left);
        if(prev == null){

           head= treeRoot;
        }else {
            treeRoot.left = prev;
            prev.right = treeRoot;

        }

        prev = treeRoot;

        convertBinaryTreeToDoublyLinkedList(treeRoot.right);

    }
}
