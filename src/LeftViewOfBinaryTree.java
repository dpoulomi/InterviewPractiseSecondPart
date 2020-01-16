import data.TreeNode;

public class LeftViewOfBinaryTree {

    private static int maxLevel = 0;

    public static void leftView(TreeNode data){

        leftViewUtil(data , 1);
    }

    private static void leftViewUtil(TreeNode data, int level) {


        if(data == null){
            return;
        }

        if(maxLevel < level){
            System.out.println(data.data);
            maxLevel = level;
        }

        leftViewUtil(data.left , level + 1);
        leftViewUtil(data.right , level + 1);



    }

    public static void main(String args[])
    {
        TreeNode n6 = new TreeNode(7 , null , null);
        TreeNode n5 = new TreeNode(6 , null , null);
        TreeNode n4 = new TreeNode(5 , null , null);
        TreeNode n3 = new TreeNode(4 , null , null);
        TreeNode n2 = new TreeNode(3 , n5 , n6);
        TreeNode n1 = new TreeNode(2 , n3 , n4);
        TreeNode root = new TreeNode(1 , n1 , n2);
        leftView(root);

    }
}
