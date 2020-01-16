public class MaximumSumFromRootToLeaf {



    public int maxSum(Node root  ){
         int current_sum = 0 ;
         int max_sum = 0 ;
         Node targetNode = null;
         findMaxSumFromRootToLeaf(root , current_sum , max_sum , targetNode);
         return max_sum;
    }

    private void findMaxSumFromRootToLeaf(Node root, int current_sum, int max_sum , Node targetNode) {

        while(root == null){
            return;
        }

        current_sum = current_sum + root.data;
        if (root.left == null && root.right == null) {
            if (max_sum < current_sum) {
                max_sum = current_sum;
                targetNode = root;
            }
        }
        findMaxSumFromRootToLeaf(root.left, current_sum , max_sum , targetNode);
        findMaxSumFromRootToLeaf(root.right , current_sum , max_sum , targetNode);


    }
}
