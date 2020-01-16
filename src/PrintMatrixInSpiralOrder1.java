public class PrintMatrixInSpiralOrder1 {


    public static void main(String[] args) {
        PrintMatrixInSpiralOrder1 printMatrixInSpiralOrder1 = new PrintMatrixInSpiralOrder1();
        int matrix[][] = {{1 , 2, 3 , 4},{5 , 6, 7 , 8},{9 , 10 , 11 , 12},{13 , 14 , 15 , 16}};
        printMatrixInSpiralOrder1.printMatrix(matrix);
    }

    public void printMatrix(int [][] matrix){

        int k = 0 , l = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0 ;
        while(k < m && l < n) {
            for (i = l; i < n; i++) {
                System.out.println(matrix[k][i]);
            }
            k ++;
            for( i = k ; i < m ; i++){
                System.out.println(matrix[i][n - 1]);

            }
            n--;
            //if( < n) {
                for (i = n - 1; i >= l; i--) {
                    System.out.println(matrix[m - 1][i]);
                }
                m--;
         //   }
          //  if(k < m) {
                for (i = m - 1; i >= k; i--) {

                    System.out.println(matrix[i][l]);
                }
                l++;
          //  }

        }

    }
}
