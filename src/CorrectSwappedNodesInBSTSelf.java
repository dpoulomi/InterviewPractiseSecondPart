import data.TreeNode;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class CorrectSwappedNodesInBSTSelf {


    TreeNode firstFoundNode, secondFoundNode, previous, middle;
    public static void main(String[] args) {
        CorrectSwappedNodesInBSTSelf  tree = new CorrectSwappedNodesInBSTSelf();



        TreeNode n3 = new TreeNode(1, null , null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n5 = new TreeNode(12,null, null);
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n1 = new TreeNode(10,n6, n5);
        TreeNode n2 = new TreeNode(2, n4 , n3);
        TreeNode root = new TreeNode(6,n2,n1);
        tree.printInOrder(root);
        System.out.println("After swapping ");
        //root = tree.correctSwappedNodes(root);
        tree.correctBST(root);
        tree.printInOrder(root);
    }

    private void correctBST(TreeNode root) {
        firstFoundNode= null;
        secondFoundNode = null;
        previous = null;
        middle = null;

        correctBSTUtil(root);

        if(firstFoundNode != null && secondFoundNode != null){
            int temp = firstFoundNode.data;
            firstFoundNode.data = secondFoundNode.data;
            secondFoundNode.data = temp;

        }

        else if(firstFoundNode != null && middle != null){
            int temp = firstFoundNode.data;
            firstFoundNode.data = middle.data;
            middle.data = temp;

        }

    }

    private void correctBSTUtil(TreeNode root) {
       if(root != null){
           correctBSTUtil(root.left);
                if(previous != null && previous.data > root.data){
                    if(firstFoundNode==null){
                        firstFoundNode = previous;
                        middle = root;
                    }else{
                        secondFoundNode = root;
                    }
                }
           previous = root;
           correctBSTUtil(root.right);
        }

    }

    private void printInOrder(TreeNode root) {
        if(root != null){
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }

    }
}
