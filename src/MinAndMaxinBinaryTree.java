import data.TreeNode;

public class MinAndMaxinBinaryTree {


    public static void main(String[] args) {
        TreeNode n7 = new TreeNode(4, null, null);
        TreeNode n3 = new TreeNode(1, null, null);

        TreeNode n5 = new TreeNode(11, null, null);
        TreeNode n4 = new TreeNode(6, n3, n5);
        TreeNode n6 = new TreeNode(9, n7, null);
        TreeNode n1 = new TreeNode(5, null, n6);
        TreeNode n2 = new TreeNode(7, null, n4);
        TreeNode root = new TreeNode(2, n2, n1);

        MinAndMaxinBinaryTree minAndMaxinBinaryTree = new MinAndMaxinBinaryTree();
//        int minimumNode = MinAndMaxinBinaryTree.getMinimumNode(root);
//        System.out.println(maxNodeValue);
        int maxNodeValue = minAndMaxinBinaryTree.getMaximumNode(root);
        System.out.println(maxNodeValue);

    }


    private int getMaximumNode(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMaxValue = getMaximumNode(root.left);
        int rightMaxValue = getMaximumNode(root.right);
        return getMaxValue(leftMaxValue, rightMaxValue, root.data);
    }


    private int getMaxValue(int first,
                            int second,
                            int third) {
        int maxBetweenFirstSecond = first > second ? first : second;
        return maxBetweenFirstSecond > third ? maxBetweenFirstSecond : third;
    }
}
