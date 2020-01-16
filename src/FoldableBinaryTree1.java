import data.TreeNode;

public class FoldableBinaryTree1 {


    public boolean isFoldable(TreeNode head){

        boolean result = isFoldableUtil(head.left , head.right);
        return result;

    }

    private boolean isFoldableUtil(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return isFoldableUtil(left.left , right.right) && isFoldableUtil(left.right , right.left);
    }
}
