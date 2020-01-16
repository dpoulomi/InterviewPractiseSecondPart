public class BooleanMatrixSetRowColumnTo1 {


    public static void main(String[] args)
    {
        int mat[ ][ ] = { {1, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 0},};

        //System.out.println("Matrix Intially");

        redrawMatrix(mat);

    }

    public static void redrawMatrix(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int row[] = new int[R];
        int col[] = new int[C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < C; j++) {

                    matrix[i][j] = 1;
                }
            }
        }

        for (int j = 0; j < C; j++) {
            if (col[j] == 1) {
                for (int i = 0; i < R; i++) {

                    matrix[i][j] = 1;
                }
            }

        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(matrix[i][j]);

            }

            System.out.println();
        }


    }

}