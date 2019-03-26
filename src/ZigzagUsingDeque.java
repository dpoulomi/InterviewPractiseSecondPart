import java.util.Deque;
import java.util.LinkedList;

public class Node {


    public Node(int i) {
    }

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
        Node tree = new Node();

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

    printTreeInSpiralOrder(NOde head){
        Deque<Integer> deque = new LinkedList<>();
        while(){}


    }
}
