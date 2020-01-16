public class RotateAMatrixBy90 {

    public static void main (String[] args)
    {
        int N = 4;// Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };




        RotateAMatrixBy90 rotateAMatrixBy90 = new RotateAMatrixBy90();

        rotateAMatrixBy90.rotateMatrix(N,mat);

        // Print rotated matrixrotateAMatrixBy90.displayMatrix(N,mat);
        rotateAMatrixBy90.printMatrix(mat);
    }

    private void rotateMatrix(int n, int[][] mat) {

        transposeMatrix(n , mat);
        reverseMatrix(n , mat);

    }

    private void reverseMatrix(int n, int[][] mat) {
        int k = mat[0].length - 1;
        for(int i = 0 ; i < mat.length ; i++){
            if(i > k){
                break;
            }
            for(int j = 0 ; j < mat[0].length ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[k][j];
                mat[k][j] = temp;
            }
            k --;
        }
    }

     void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }

    private void transposeMatrix(int n, int[][] mat) {
        for(int i = 0 ; i < mat.length ; i--){
            for(int j = mat[0].length - 1; j >= 0 ; j--){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp ;
            }

        }

    }
}
