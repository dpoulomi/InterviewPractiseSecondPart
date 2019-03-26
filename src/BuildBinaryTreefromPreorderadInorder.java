import data.TreeNode;

public class BuildBinaryTreefromPreorderadInorder {

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6} ;
        int start = 0 ;
        int end = preOrder.length - 1;
        BuildBinaryTreefromPreorderadInorder buildBinaryTreefromPreorderadInorder = new BuildBinaryTreefromPreorderadInorder();
        buildBinaryTreefromPreorderadInorder.buildTree(inOrder , preOrder , start ,end);




    }

    private int preOrderIndex = 0 ;

    private TreeNode buildTree(int[] inOrder, int[] preOrder , int start
    , int end) {
        if (start > end) {
            return null;
        }

        TreeNode root = null;
        if(preOrderIndex < preOrder.length) {
            root = new TreeNode(preOrder[preOrderIndex], null, null);
            preOrderIndex++;
             if(start == end){
                 return root;
             }
        }

        for(int i = 0 ; i< inOrder.length ; i++){

            if(root.data == inOrder[i]){
                root.left = buildTree(inOrder , preOrder , start , i -1);
                root.right = buildTree(inOrder , preOrder, i +1 , end);

            }
        }
        return root;
    }

//    private void createTree(int i, int[] preOrder, in[) {
//        root = new TreeNode(inOrder[i], null , null);
//
//        int rootInPreOrder = findIndex(inorder[i]);
//
//        root.left = createTree();
//
//    }

//    private TreeNode root = null;

}
