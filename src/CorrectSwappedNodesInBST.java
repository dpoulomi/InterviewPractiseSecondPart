import data.TreeNode;

public class CorrectSwappedNodesInBST {

    TreeNode first, middle, last, prev;
    public static void main(String[] args) {
        CorrectSwappedNodesInBST  tree = new CorrectSwappedNodesInBST();



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

    private void printInOrder(TreeNode root) {
        if(root != null){
            printInOrder(root.left);
            System.out.println(root.data);
            printInOrder(root.right);
        }
    }

    void correctBST( TreeNode root )
    {
        // Initialize pointers needed
        // for correctBSTUtil()
         first = null ;
         middle = null;
         last = null;
         prev = null;

        // Set the poiters to find out
        // two nodes
        correctBSTUtil( root );

        // Fix (or correct) the tree
        if( first != null && last != null )
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
        // Adjacent nodes swapped
        else if( first != null && middle !=
                null )
        {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }

        // else nodes have not been swapped,
        // passed tree is really BST.
    }

    void correctBSTUtil( TreeNode root)
    {
        if( root != null )
        {
            // Recur for the left subtree
            correctBSTUtil( root.left);

            // If this node is smaller than
            // the previous node, it's
            // violating the BST rule.
            if (prev != null && root.data <
                    prev.data)
            {
                // If this is first violation,
                // mark these two nodes as
                // 'first' and 'middle'
                if (first == null)
                {
                    first = prev;
                    middle = root;
                }

                // If this is second violation,
                // mark this node as last
                else
                    last = root;
            }

            // Mark this node as previous
            prev = root;

            // Recur for the right subtree
            correctBSTUtil( root.right);
        }
    }

    private TreeNode rootData = null;
//    public TreeNode correctSwappedNodes(TreeNode root) {
//        rootData = root;
//        TreeNode tempLeft = rootData;
//        TreeNode tempRight = rootData;
//        TreeNode prev = null;
//        TreeNode middle = null;
//        TreeNode last = null;
//        TreeNode previousToLast = null;
//        root= rootData;
//        while(root != null && prev == null) {
//            if (prev == null) {
//                if (root.data < root.left.data) {
//                    prev = root;
//                    middle = root.left;
//                } else {
//                    root = root.left;
//                }
//            }
//        }
//        root= rootData;
//        while(root != null && previousToLast == null) {
//            if(previousToLast == null) {
//                if (root.right.data < root.data) {
//                    last = root.right;
//                    previousToLast = root;
//                } else {
//                    root = root.right;
//                }
//            }
//        }
//
//        TreeNode leftChild = last.left;
//        TreeNode rightChild = last.right;
//        last.left = middle.left;
//        last.right = middle.right;
//        middle.left = leftChild;
//        middle.right = rightChild;
//
//
//        while(tempLeft != prev){
//            root = root.left;
//
//        }
//
//        tempLeft.left = last;
//        while(tempRight != previousToLast){
//            root = root.left;
//
//        }
//        tempRight.right = middle;
//        return rootData;
//    }
}
