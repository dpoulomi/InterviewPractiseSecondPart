import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CountSubTreesEqualToSum {

    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(7,null, null);
        TreeNode n5 = new TreeNode(4,null, null);

        TreeNode n3 = new TreeNode(9,null, null);
        TreeNode n4 = new TreeNode(8,null, null);
        TreeNode n2 = new TreeNode(3,n5, n6);
        TreeNode n1 = new TreeNode(-10,n3, n4);
        TreeNode root = new TreeNode(5,n1, n2);

//        TreeNode n6 = new TreeNode(7,null, null);
//        TreeNode n5 = new TreeNode(4,null, null);
//
//        TreeNode n3 = new TreeNode(7,null, null);
//        TreeNode n4 = new TreeNode(4,null, null);
//        TreeNode n2 = new TreeNode(12,null, null);
//        TreeNode n1 = new TreeNode(5,n3, n4);
//        TreeNode root = new TreeNode(10,n1, n2);


        int targetValue = 7;
        CountSubTreesEqualToSum countSubTreesEqualToSum = new CountSubTreesEqualToSum();
        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        System.out.println(countSubTreesEqualToSum.findSubTreesEqualToGivenSum(root ,targetValue));
       
    }


    private int findSubTreesEqualToGivenSum(TreeNode root, int targetValue) {
//        if (root == null) {
//            return;
//        }
//        sum = sum + root.data;
//        arr.add(root.data);
//        boolean leaf = root.left == null && root.right == null;
//
//
//        if (sum == targetValue && leaf) {
//            for (int i : arr) {
//                System.out.println(i);
//            }
//        }
//
//        findSubTreesEqualToGivenSum(root.left, targetValue, sum, arr);
//        findSubTreesEqualToGivenSum(root.right, targetValue, sum, arr);
//
//        arr.remove(arr.size()-1);
//        if(root == null){
//            return 0;
//        }
//        int sum = 0;
//        List<Integer> nodes  =  new ArrayList<>();
//        nodes.add(root.data);
//        int leftSum = findSubTreesEqualToGivenSum(root.left, targetValue);
//        int rightSum = findSubTreesEqualToGivenSum(root.right, targetValue);
//        if(leftSum == targetValue){
//
//        }
//        sum = leftSum + rightSum + root.data;
//        if(sum==targetValue){
//            for(int i : nodes){
//                System.out.println(i);
//            }
//        }else if(sum > targetValue){
//            nodes.remove(nodes.size()-1);
//        }
//        return sum;
       int count = 0;

        if(root == null){
            return 0 ;
        }
        
        int leftSum =  getSum(root.left,targetValue , count);
         int rightSum = getSum(root.right, targetValue , count);

          int sum  = leftSum + rightSum + root.data;
          if(targetValue == sum){
              count++;
          }
        
        return count;
    }

    private int getSum(TreeNode root, int targetValue, int count) {

        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left, targetValue , count);
        int rightSum = getSum(root.right, targetValue , count);
        int sum = leftSum + rightSum + root.data;
        if (targetValue == sum) {
            count++;
        }
        return sum;
    }


}
