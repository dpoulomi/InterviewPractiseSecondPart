package MSPrep;

public class MaxSumBST {

    class Node{
        int data ;
        Node left = null;
        Node right = null;

        Node(int data){
           this.data = data;


        }

    }

    static class MaxNode{

        static int maxSum = Integer.MIN_VALUE;
        static int currentSum = Integer.MIN_VALUE;
        static Node maxNode = null;

    }



    public static void main(String[] args) {
        MaxSumBST maxSumBST = new MaxSumBST();
        Node root = maxSumBST.formBST();
        MaxNode maxSumSubtree = maxSumBST.findMaxSumBST(root);
    }

    public MaxNode findMaxSumBST(Node root){
        if(root.left == null && root.right == null){
            if(MaxNode.currentSum < root.data){
                MaxNode.currentSum = root.data;
                MaxNode.maxNode = root;
            }
        }

        MaxNode left = findMaxSumBST(root.left);
        MaxNode right = findMaxSumBST(root.right);


return null;

    }

    public Node formBST(){
        Node root = new Node(7);
        Node n1 = new Node(12);
        Node n2 = new Node(2);
        root.left = n1;
        root.right = n2;
        Node n3 = new Node(11);
        Node n4 = new Node(12);
        n1.left = n3;
        n1.right = n4;

        Node n5 = new Node(5);
        n2.right = n5;

        return root;
    }
}
