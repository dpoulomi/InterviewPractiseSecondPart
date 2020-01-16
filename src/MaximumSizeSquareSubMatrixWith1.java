public class MaximumSizeSquareSubMatrixWith1 {


    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                     {1, 1, 0, 1, 0},
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};

        findMaximumSubMatrix(M);
    }

    public static void findMaximumSubMatrix(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        int S[][] = new int[R][C];
        int maximum= Integer.MIN_VALUE;

          int i_index = 0 ;

          int j_index = 0;


        for(int i = 0 ; i < R ; i ++){
            S[i][0] = matrix[i][0];

        }

        for(int j = 0 ; j < C ; j ++){
            S[0][j] = matrix[0][j];
        }


        for(int i = 1 ; i < R;i++ ){
            for(int j = 1 ; j < C ; j++){
                if(matrix[i][j] == 1){

                   // Math.min(matrix[i - 1][j] , matrix[i][j - 1])
                  //  int min = Math.min(matrix[i - 1][j] , matrix[i][j - 1]);
                    S[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j] , matrix[i][j - 1])) + 1;
                }else{
                    S[i][j] = 0 ;
                }
            }
        }

        //findout out the maximum sized square found or maximum size indexes of the square found
        for(int i = 0 ; i < R ; i ++){
            for(int j = 0 ; j < C ; j++){
                if(maximum < S[i][j] ){
                    maximum = S[i][j];
                    i_index = i;
                    j_index = j;

                }

            }
        }

        for(int i = i_index ; i > maximum - i_index ; i--){
            for(int j= j_index; j > maximum - j_index ; j--){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
