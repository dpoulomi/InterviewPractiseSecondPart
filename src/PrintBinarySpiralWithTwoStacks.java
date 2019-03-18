import java.util.Stack;

public class PrintBinarySpiralWithTwoStacks {

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
        PrintBinarySpiralWithTwoStacks tree = new PrintBinarySpiralWithTwoStacks();

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
//

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
       while(!s1.isEmpty() || !s2.isEmpty()){
         Node ele = s1.peek();
         s1.pop();
         System.out.println(ele.data);
         if(ele.right != null){
             s2.push(ele.right);
         }
         if(ele.left !=null){
             s2.push(ele.left);
         }

         while(!s2.isEmpty()) {
             Node element = s2.peek();
             System.out.println(element.data);
             s2.pop();
             if(element.left != null){
                 s1.push(element.left);
             }
             if(element.right !=null){
                 s1.push(element.right);
             }
         }

       }
    }

    private void printTreeInSpiralOrderTree(int height, Node root, boolean reverse) {

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
