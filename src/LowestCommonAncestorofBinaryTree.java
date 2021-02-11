import data.TreeNode;

public class    LowestCommonAncestorofBinaryTree {


    public static void main(String[] args) {
        LowestCommonAncestorofBinaryTree  tree = new LowestCommonAncestorofBinaryTree();
        TreeNode n3 = new TreeNode(1, null , null);
        TreeNode n4 = new TreeNode(3, null, null);
        TreeNode n5 = new TreeNode(12,null, null);
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n1 = new TreeNode(10,n6, n5);
        TreeNode n2 = new TreeNode(2, n4 , n3);
        TreeNode root = new TreeNode(6,n2,n1);

        TreeNode givenFirstNode = n2;
        TreeNode givenSecondNode =n5;

        TreeNode ancestor =tree.findLowestCommonAncestor(root, givenFirstNode, givenSecondNode);
        System.out.print(ancestor.data);

    }

    private TreeNode findLowestCommonAncestor(TreeNode root, TreeNode givenFirstNode, TreeNode givenSecondNode) {

      if(root == null){
          return null;
      }

      if(root.data == givenFirstNode.data || root.data == givenSecondNode.data){
          return root;
      }

      TreeNode left = findLowestCommonAncestor(root.left , givenFirstNode, givenSecondNode);
      TreeNode right = findLowestCommonAncestor(root.right , givenFirstNode, givenSecondNode);

      if(left != null && right !=null){
          return root;
      }

      return left != null ? left : right;

    }


}
