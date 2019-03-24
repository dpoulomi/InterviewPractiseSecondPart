import data.TreeNode;

public class MinAndMaxInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(4, null, null);
        TreeNode n3 = new TreeNode(1, null, null);

        TreeNode n5 = new TreeNode(11, null, null);
        TreeNode n4 = new TreeNode(6, n3,n5);
        TreeNode n6 = new TreeNode(9, n7, null);
        TreeNode n1 = new TreeNode(5, null, n6);
        TreeNode n2 = new TreeNode(7, null, n4);
        TreeNode root = new TreeNode(2, n2, n1);

        MinAndMaxInBinarySearchTree minAndMaxInBinarySearchTree = new MinAndMaxInBinarySearchTree();
        int minimumNode = minAndMaxInBinarySearchTree.getMinimumNode(root);
        System.out.println(minimumNode);
        int maximumNode = minAndMaxInBinarySearchTree.getMaximumNode(root);
        System.out.println(maximumNode);

    }

    private int getMaximumNode(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    private int getMinimumNode(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
}
