import java.util.Deque;
import java.util.LinkedList;

public class ZigzagUsingDeque {



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
       // Node tree = new Node();
        ZigzagUsingDeque tree = new ZigzagUsingDeque();

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

    private void printTreeInSpiralOrder(Node root) {

        Deque<Node> deque = new LinkedList<>();
        deque.offerFirst(root);
        boolean flip = false;
        int current = 1;
        int next = 0;

        while(!deque.isEmpty()){

            while(current > 0) {
                if (flip) {
                    Node element = deque.pollFirst();
                    System.out.print(element.data + "-->");
                    if (element.left != null) {
                        deque.offerLast(element.left);
                        next++;
                    }
                    if (element.left != null) {
                        deque.offerLast(element.right);
                        next++;
                    }

                } else {

                    Node element = deque.pollLast();
                    System.out.print(element.data + "-->");
                    if (element.left != null) {
                        deque.offerFirst(element.right);
                        next++;
                    }
                    if (element.left != null) {
                        deque.offerFirst(element.left);
                        next++;
                    }
                }
                current--;
            }

                current = next;
                next = 0;
                flip = !flip;

        }



    }


}
