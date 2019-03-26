import data.TreeNode;

import javax.sql.rowset.spi.TransactionalWriter;

public class KthNodeInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(1, null , null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n5 = new TreeNode(12,null, null);
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n1 = new TreeNode(10,n6, n5);
        TreeNode n2 = new TreeNode(2, n4 , n3);
        TreeNode root = new TreeNode(6,n2,n1);
        KthNodeInBinarySearchTree kthNodeInBinarySearchTree = new KthNodeInBinarySearchTree();
        kthNodeInBinarySearchTree.getKthNode(root, 4);
    }

    private TreeNode getKthNode(TreeNode root, int k) {
//        if (root == null) {
//            return;
//        }
//        getKthNode(root.left, k);
//        k--;
//        getKthNode(root.right, k);
//        if (k == 1) {
//            System.out.println(root.data);
//        }

        TreeNode target = new TreeNode(0 , null , null);
           if(root.left != null){
             target = getKthNode(root.left , k);
           }
           if(target== null){
               if(k ==1){
                   target = root;
               }
           }

           if(target == null && root.right != null){
               target = getKthNode(root.right, k);
           }

       return target;
    }
}
