package MultidimensionalMatrix;

public class RotateMatrixBy90 {


    public void rotateMatrixAntiClockWise() {

        int mat[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        //3  6  9
        //2  5  8
        //1  4  7

        transpose(mat);
        reverseInAntiClockwise(mat);
        printMatrix(mat);


    }

    private void rotateMatrixClockWise() {
        int mat[][] = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};

        transpose(mat);
        reverseInClockWise(mat);
        printMatrix(mat);

    }

    private void reverseInClockWise(int[][] mat) {
        for(int i = 0 ; i < mat[0].length ; i++){
            for(int j = 0, k = mat[0].length - 1; j < k ; j++ , k --){
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;

            }

        }
    }

    public void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }

    public void transpose(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }


    public void reverseInAntiClockwise(int mat[][]) {
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0, k = mat[0].length - 1; j < k; j++, k--) {
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;

            }

        }

    }

    public static void main(String[] args) {
        RotateMatrixBy90 rotateMatrixBy90 = new RotateMatrixBy90();
        rotateMatrixBy90.rotateMatrixAntiClockWise();
        System.out.println();
        rotateMatrixBy90.rotateMatrixClockWise();
    }


}
