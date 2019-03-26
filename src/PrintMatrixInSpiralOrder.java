public class PrintMatrixInSpiralOrder {

    public static void main(String[] args) {
        int[][] matrix = {{1 ,2 ,3 ,4},
                          {5, 6, 7, 8} ,
                          {9, 10, 11, 12},
                          {13, 14, 15, 16},
                          {17, 18, 19, 20}
    };
        
        PrintMatrixInSpiralOrder printMatrixInSpiralOrder = new PrintMatrixInSpiralOrder();
        printMatrixInSpiralOrder.printInSpiralOrder(matrix);
}

    private void printInSpiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rowIndex = 0;
        int colIndex = 0;
        int fixedIndex = 0;
        while(row != 0 && col!= 0) {

            fixedIndex = rowIndex;
            for(int i = rowIndex ; i< col ; i++){
                System.out.print(matrix[fixedIndex][i] + ",");
            }
            fixedIndex = col - 1 ;
            for(int i = rowIndex +1 ; i < row ; i++){
                System.out.print(matrix[i][fixedIndex] + ",");
            }
            fixedIndex = row - 1;
            for(int i = col -1 -1 ; i> colIndex;i--){
                System.out.print(matrix[fixedIndex][i] + ",");
            }
            fixedIndex = colIndex;
            for(int i = row -1 ; i> rowIndex; i--){
                System.out.print(matrix[i][fixedIndex] + ",");
            }
            rowIndex++;
            colIndex++;
            row--;
            col --;
        }}

    }

