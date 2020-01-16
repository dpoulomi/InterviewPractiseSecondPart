import data.TreeNode;

public class MaximumSizeBinarySubTree {


    public int largestSubtree(TreeNode root){
        int largestSize = 0 ;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        findLargestSizeSubtree(root ,min, max,  largestSize);
        return largestSize;
    }

    private boolean findLargestSizeSubtree(TreeNode root,int min , int max , int largestSize) {
        if(root == null){
            largestSize = 0;
            min = Integer.MIN_VALUE;
            max = Integer.MAX_VALUE;
            return true;
        }
        int leftMin = 0 ;
        int leftMax = 0;
        int leftSize = 0 ;
        boolean left = findLargestSizeSubtree(root.left ,leftMin , leftMax , leftSize);
        int rightMin = 0;
        int rightMax = 0 ;
        int rightSize = 0 ;
        boolean right = findLargestSizeSubtree(root.right , rightMin , rightMax ,rightSize);
        boolean overall = false;
        if(left && right && root.data >= leftMax && root.data <= rightMin){
            largestSize = leftSize + rightSize + 1;
            overall = true;
            min = root.data < leftMin ? root.data : leftMin;
            max = root.data > rightMax ? root.data : rightMax;
        }else{

            largestSize = leftSize > rightSize  ? leftSize : rightSize ;
        }

        return overall;
    }


    public static void main(String[] args) {
        MaximumSizeBinarySubTree tree = new MaximumSizeBinarySubTree();
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n5 = new TreeNode(6 , null , null);
        TreeNode n4 = new TreeNode(5 , null , null);
        TreeNode n3 = new TreeNode(4 , null , null);
        TreeNode n2 = new TreeNode(3 , n5 , n6);
        TreeNode n1 = new TreeNode(2 , n3 , n4);
        TreeNode root = new TreeNode(1 , n1 , n2);
        System.out.println("Size of largest BST is " + tree.largestSubtree(root));
    }

}
