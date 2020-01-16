public class MaximumSizeSquareSubMatrixWithAll1 {


    public int findMaximumSizeSquareSubMatrix(int[][] arr){
        int S[][] = new int[arr.length][arr[0].length];
        for(int i = 0 ; i < arr.length ; i++){
            S[i][0] = arr[i][0];
        }
        for(int i = 0 ; i < arr[0].length ; i++){
            S[0][i] = arr[0][i];
        }
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = 1 ; j < arr[0].length ; j++){
                if(arr[i][j] == 1){
                    S[i][j] = 1 + Math.min(S[i - 1][j] , Math.min(S[i][j - 1] , S[i - 1][ j - 1]));
                }else{
                    S[i][j] = 0;
                }
            }
        }

        int maxValue = Integer.MIN_VALUE;

        for(int i = 0 ; i < S.length ; i++){
            for(int j = 0 ; j < S[0].length ; j++){
                if(maxValue < S[i][j]){
                    maxValue = S[i][j];
                }

            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        MaximumSizeSquareSubMatrixWithAll1 maximumSizeSquareSubMatrixWithAll1 = new MaximumSizeSquareSubMatrixWithAll1();
        System.out.println(maximumSizeSquareSubMatrixWithAll1.findMaximumSizeSquareSubMatrix(M));

    }
}
