package MultidimensionalMatrix;

public class MaximumSizeSquareWithAll1 {


    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        MaximumSizeSquareWithAll1 maximumSizeSquareWithAll1 = new MaximumSizeSquareWithAll1();
        int area = maximumSizeSquareWithAll1.calculateMaximumSizeSquare(matrix);
    }

    private int calculateMaximumSizeSquare(int[][] matrix) {
        int bufferArray[][] = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            bufferArray[0][i] = matrix[0][i];
        }
        for (int j = 0; j < matrix.length; j++) {
            bufferArray[j][0] = matrix[j][0];
        }

        return 0;
    }
}
