
    class TransposeMatrix {

        public static void main(String[] args) {
            int[][] A = {{1,2},{4,5},{7,8}};
            for(int i = 0 ; i < A.length; i++){
                System.out.println();
                for(int j = 0 ; j < A[0].length ; j++){
                    System.out.print(A[i][j]);
                }
            }
            System.out.println();
            TransposeMatrix transposeMatrix = new TransposeMatrix();
           int[][] B= transposeMatrix.transpose(A);
              for(int i = 0 ; i<B.length; i++){
                  System.out.println();
                 for(int j = 0 ; j < B[0].length ; j++){
                     System.out.print(B[i][j]);
                 }
             }
        }
        public int[][] transpose(int[][] A) {
            int row = A.length;
            int col = A[0].length;
            int[][] B = new int[col][row];
            for(int i = 0 ; i<col; i++){
                for(int j = 0 ; j < row ; j++){
                    B[j][i] = A[i][j];
                }
            }
            return B;
        }
    }

