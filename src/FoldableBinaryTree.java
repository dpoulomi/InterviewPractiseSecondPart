import data.TreeNode;

public class FoldableBinaryTree {

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5 , null , null);
        TreeNode n4 = new TreeNode(4 , null , null);
        TreeNode n2 = new TreeNode(3 , null , n5);

        TreeNode n1 = new TreeNode(2 , null , n4);

        TreeNode n = new TreeNode(1 , n1 , n2);


        FoldableBinaryTree foldableBinaryTree = new FoldableBinaryTree();
       System.out.println(foldableBinaryTree.isFoldable(n));


    }

    public boolean isFoldable(TreeNode head){


        boolean result = false;

        mirror(head.left);

        result = isStructureSame(head.left , head.right);

        mirror(head.left);

        return result;

    }

    private boolean isStructureSame(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;

        }
        if(left != null && right!=null && isStructureSame(left.left, right.left) && isStructureSame(left.right , right.right)) {

            return true;
        }
        return false;
    }

    private void mirror(TreeNode node) {

        if(node == null){
            return;
        }else {
            mirror(node.left);
            mirror(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }

    }
}
