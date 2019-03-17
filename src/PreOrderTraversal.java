import java.util.ArrayList;
import java.util.Vector;

public class PreOrderTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }


    public static void main(String args[]) {
        int in[] = {4, 5, 7};
        int n = in.length;
        PreOrderTraversal tree = new PreOrderTraversal();
        ArrayList<Node> trees = tree.getTrees(in, 0, n - 1);
        System.out.println("Preorder traversal of different " +
                " binary trees are:");
//        for (int i = 0; i < trees.size(); i++) {
//            tree.preOrder(trees.get(i));
//            System.out.println("");
//        }
    }

//    private void preOrder(Node node) {
//        for(){}
//    }

    private ArrayList<Node> getTrees(int[] arr, int start, int end){


        ArrayList<Node> preorderTrees = new ArrayList<>();
        if(start>end){
            preorderTrees.add(null);
            return preorderTrees;

        }
        ArrayList<Node> leftTrees = new ArrayList<>();
        ArrayList<Node> rightTrees =  new ArrayList<>();

        for(int k =0 ;k<arr.length;k++) {
            leftTrees = getTrees(arr, start, k - 1);
            rightTrees = getTrees(arr, k + 1, end);


            for (int i = 0; i < leftTrees.size(); i++) {
                for (int j = 0; j < rightTrees.size(); j++) {
                    Node n = new Node(arr[k]);
                    n.left=leftTrees.get(i);
                    n.right= rightTrees.get(j);
                    preorderTrees.add(n);
                }
            }
        }
        return preorderTrees;
    }
}