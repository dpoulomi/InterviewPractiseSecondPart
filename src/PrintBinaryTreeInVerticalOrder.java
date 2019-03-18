import data.TreeNode;

import java.util.*;

public class PrintBinaryTreeInVerticalOrder {

    public static void main(String[] args) {
        PrintBinaryTreeInVerticalOrder  tree = new PrintBinaryTreeInVerticalOrder();

        TreeNode n9 = new TreeNode(10, null, null);
        TreeNode n1 = new TreeNode(9, null, null);
        TreeNode n2 = new TreeNode(8, null, null);
        TreeNode n3 = new TreeNode(7, n2, n1);
        TreeNode n4 = new TreeNode(6, null, null);
        TreeNode n5 = new TreeNode(5, n9, null);
        TreeNode n6 = new TreeNode(4, null, null);
        TreeNode n7 = new TreeNode(3, n4, n3);
        TreeNode n8 = new TreeNode(2, n6, n5);
        TreeNode root = new TreeNode(1, n8, n7);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printTreeInVertical(root);
    }

    private void printTreeInVertical(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int horrizontalLine = 0;
        printTreeInVerticalOrder(horrizontalLine, root, map);

        int min = getMin(map.keySet());

        for (int i = min; map.get(i) != null; i++) {

            System.out.println(map.get(i));
        }
    }

    private int getMin(Set<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int key : list) {
            if (key < min) {
                min = key;
            }
        }
        return min;
    }

    private void printTreeInVerticalOrder(int horrizontalLine, TreeNode root, Map<Integer, List<Integer>> map) {

        if(root == null){
            return;
        }

        List<Integer> nodes  = map.get(horrizontalLine);

         if(nodes==null){
             nodes = new ArrayList<>();
             nodes.add(root.data);

         }else{
             nodes = map.get(horrizontalLine);
             nodes.add(root.data);


         }
        map.put(horrizontalLine, nodes);

         printTreeInVerticalOrder(horrizontalLine-1, root.left , map);
         printTreeInVerticalOrder(horrizontalLine+1 , root.right , map);
    }



    private void getInOrderTraversalArray(TreeNode root, int[] inOrderTraversal) {
        getInOrderTraversalArray(root , inOrderTraversal);
        int index = 0;
        while(root!=null){
            root = root.left;
            inOrderTraversal[index] = root.data;
            root = root.right;
            index++;
        }

    }


}
