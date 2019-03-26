public class VerifyPostOrderOfBinarySearchTree {

    public static void main(String[] args) {
        int[] postOrder = {5, 7, 6, 9, 11, 10, 8};
        int start = 0;
        int end = postOrder.length;
        VerifyPostOrderOfBinarySearchTree verifyPostOrderOfBinarySearchTree = new VerifyPostOrderOfBinarySearchTree();
        verifyPostOrderOfBinarySearchTree.verify(postOrder , postOrder.length , start , end);
    }

    private boolean verify(int[] postOrder , int length , int start , int end) {
        if(length < 0){
            return false;
        }
        int root = end - 1;
        int i = start;
        for(; i<length - 1 ; i++){
            if(postOrder[root]> postOrder[i]){
                break;
            }
        }
        int j = i;
        for(; j < length - 1 ; j++ ){
            if(postOrder[j] < postOrder[root]){
                return false;
            }
        }
        boolean left = true;
        if(i > 0)
         left = verify(postOrder , i , start , i);
        boolean right = true;
        if(j < postOrder.length-1){

            right = verify(postOrder , postOrder.length -i -1 , i + 1 , end );
        }
        return left && right;
    }

    private int findIndexLeft(int[] postOrder, int rootIndex) {
        int i = 0;
        while(postOrder[rootIndex] < postOrder[i]){
            i++;
        }
        return i-1;
    }


    private int findIndexRight(int[] postOrder, int rootIndex) {
        int i = 0;
        while(postOrder[rootIndex] > postOrder[i]){
            i++;
        }
        return i;
    }
}
