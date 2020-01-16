package BinaryTree;

import data.TreeNode;

public class BinartyTreetoMirrorTree {

    public TreeNode convertToMirrorTree(TreeNode head) {
        // TreeNode n  = head;
        if (head == null) {
            return head;
        }
        TreeNode left = convertToMirrorTree(head.left);
        TreeNode right = convertToMirrorTree(head.right);

        head.left = right;
        head.right = left;


        return head;
    }

    }

