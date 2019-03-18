import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PrintBinaryTreeInSpiralOrder {

    static class Node {

        int data = 0;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left= null;
            this.right= null;
        }
    }

    Node root;
    public static void main(String[] args) {
        PrintBinaryTreeInSpiralOrder tree = new PrintBinaryTreeInSpiralOrder();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printTreeInSpiralOrder(tree.root);
    }

    public void printTreeInSpiralOrder(Node root){
//        Deque<Node> deque = new LinkedList<>();
//        deque.push(root);
//        boolean odd= false;
//        Node ele = null;
//        while(!deque.isEmpty()){
//
//            if(odd) {
//                ele = deque.pollFirst();
//                deque.push(ele.right);
//                deque.push(ele.left);
//            }else{
//                deque.push(ele.left);
//                deque.push(ele.right);
//            }
//        System.out.print(ele.data);
//            odd=!odd;
//        }
//
        int height = getHeight(root);
        boolean reverse = false ;
        for(int i = 1 ;i <= height ; i++){
            printTreeInSpiralOrderTree(i,root, reverse);
            reverse = !reverse;
        }

    }

    private void printTreeInSpiralOrderTree(int height,Node root,boolean reverse) {

        if(root==null){
            return;
        } if(height==1){
            System.out.print(root.data +" ");
        }else if(height > 1) {
            if(reverse) {
                printTreeInSpiralOrderTree(height - 1, root.left,reverse);
                printTreeInSpiralOrderTree(height - 1, root.right,reverse);

            }else{


                printTreeInSpiralOrderTree(height - 1, root.right, reverse);
                printTreeInSpiralOrderTree(height - 1, root.left, reverse);
            }
        }
    }

    public int getHeight(Node root){
        if(root==null){
            return 0;
        }
      int leftTrees = getHeight(root.left);
      int rightTrees = getHeight(root.right);
        if(leftTrees<rightTrees){
            return rightTrees+1;
        }else{
            return leftTrees+1;
        }

    }

}
