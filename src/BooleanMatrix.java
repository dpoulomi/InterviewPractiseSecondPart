public class BooleanMatrix {

    public static void main(String[] args) {
        int mat[][] = {{1, 0, 0, 1},
                       {0, 0, 1, 0},
                       {0, 0, 0, 0}};

        System.out.println("Input Matrix :");
        BooleanMatrix booleanMatrix = new BooleanMatrix();
        booleanMatrix.printMatrix(mat);

        booleanMatrix.modifyMatrix(mat);

        System.out.println("Matrix After Modification :");
        booleanMatrix.printMatrix(mat);
    }

    private void modifyMatrix(int[][] mat) {
        int rowCount = mat.length;
        int colCount = mat[0].length;
        boolean rowFlag = false;
        boolean colFlag = false;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (i == 0 && mat[i][j] == 1) {
                    rowFlag = true;
                }
                if (j == 0 && mat[i][j] == 1) {
                    colFlag = true;
                }

                if (mat[i][j] == 1) {
                    mat[0][j] = 1;
                    mat[i][0] = 1;
                }
            }
        }
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                if (mat[i][0] == 1 || mat[0][j] == 1) {
                    mat[i][j] = 1;
                }
            }
        }

        if (rowFlag==true) {
            for (int i = 0; i < colCount; i++) {
                mat[0][i] = 1;
            }
        }

        if (colFlag==true) {
            for (int i = 0; i < rowCount; i++) {
                mat[i][0] = 1;
            }
        }
    }

    private static void printMatrix(int[][] mat) {
        for(int i = 0; i<mat.length;i++){

            for(int j = 0 ;j < mat[0].length; j++){

                System.out.print(mat[i][j]);

            }
            System.out.println();
        }

    }
}
