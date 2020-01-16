import data.TreeNode;

public class CheckForBalancedTree {

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(1, null , null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n5 = new TreeNode(12,null, null);
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n1 = new TreeNode(10,n6, n5);
        TreeNode n2 = new TreeNode(2, n4 , n3);
        TreeNode root = new TreeNode(6,n2,n1);
        CheckForBalancedTree checkForBalancedTree = new CheckForBalancedTree();
        int depth = 0;
        boolean flag = checkForBalancedTree.checkIfTreeIsBalanced(root , depth);
        System.out.println(flag);
    }

    private boolean checkIfTreeIsBalanced(TreeNode root, int depth) {

        if(root == null){
            depth = 0;
            return true;
        }

        int left = 0;
        int right = 0;

         if((checkIfTreeIsBalanced(root.left ,left) && (checkIfTreeIsBalanced(root.right , right)))) {
            int diff = left - right;
            if (diff >= -1 || depth <= 1) {
                depth = 1 + left > right? left : right;
                return true;

            }
        }
        return false;
    }
}
