import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CheckForBST {

    public static void main(String[] args) {
//        TreeNode n6 = new TreeNode(7,null, null);
//        TreeNode n5 = new TreeNode(4,null, null);
//
//        TreeNode n3 = new TreeNode(9,null, null);
//        TreeNode n4 = new TreeNode(8,null, null);
//        TreeNode n2 = new TreeNode(3,n5, n6);
//        TreeNode n1 = new TreeNode(-10,n3, n4);
//        TreeNode root = new TreeNode(5,n1, n2);

//        TreeNode n6 = new TreeNode(7,null, null);
//        TreeNode n5 = new TreeNode(4,null, null);

        TreeNode n3 = new TreeNode(7,null, null);
        TreeNode n4 = new TreeNode(4,null, null);
        TreeNode n2 = new TreeNode(12,null, null);
        TreeNode n1 = new TreeNode(5,n3, n4);
        TreeNode root = new TreeNode(10,n1, n2);

        CheckForBST checkForBST = new CheckForBST();
        System.out.println(checkForBST.checkIfBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));


    }

    private boolean checkIfBSTUtil(TreeNode root , int min , int max) {
//        if(root == null){
//            return true;
//        }
//
//        boolean checkLeftTree =checkIfBST(root.left , 0 ,0);
//        boolean checkRightTree = checkIfBST(root.right, 0 , 0);
//        if( (root.left != null && root.left.data > root.data) || ( root.right != null && root.right.data < root.data)){
//            return false;
//        }
//
//        return  checkLeftTree && checkRightTree;

        return checkIfBST(root, min, max);

    }

    private boolean checkIfBST(TreeNode root, int min, int max) {

        if(root == null){
            return  true;
        }
        if(root.data<min || root.data>max){
            return false;
        }

        return checkIfBST(root.left , min , root.data-1) && checkIfBST(root.right , root.data+1 , max);
    }
}
