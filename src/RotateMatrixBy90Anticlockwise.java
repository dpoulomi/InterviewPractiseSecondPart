public class RotateMatrixBy90Anticlockwise {

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        RotateMatrixBy90Anticlockwise rotateMatrixBy90Anticlockwise = new RotateMatrixBy90Anticlockwise();
        rotateMatrixBy90Anticlockwise.printMatrix(arr);
        rotateMatrixBy90Anticlockwise.rotateMatrixBy90(arr);
        rotateMatrixBy90Anticlockwise.printMatrix(arr);

    }

    private void printMatrix(int[][] arr){

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println("");
            }

    }

    private void rotateMatrixBy90(int[][] arr) {
        transposeMtrix(arr);
        RotateMatrixBy90Anticlockwise rotateMatrixBy90Anticlockwise = new RotateMatrixBy90Anticlockwise();

        rotateMatrixBy90Anticlockwise.printMatrix(arr);
        reverseColumnofMatrix(arr);
        reverseColumnofMatrixClockWise(arr);
    }

    private void reverseColumnofMatrix(int[][] arr) {

        for (int i = 0; i < arr[0].length; i++) {

            for (int j = 0 , k = arr[0].length-1; j < k; j++,k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
        }
    }

    private void reverseColumnofMatrixClockWise(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0 , k = arr.length-1; j < k; j++,k--) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][k];
                arr[i][k] = temp;
            }
        }
    }

    private void transposeMtrix(int[][] arr) {

        for(int i =0;i < arr.length ; i++){

            for(int j = i; j<arr[0].length ; j++){

               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
    }


}
