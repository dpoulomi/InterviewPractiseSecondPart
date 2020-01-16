import java.util.Stack;

public class MaximumSizeRectangleWithAll1 {


    public static void main(String[] args) {

        MaximumSizeRectangleWithAll1 maximumSizeRectangleWithAll1 = new MaximumSizeRectangleWithAll1();
        int A[][] = { {0, 1, 1, 0},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
        };


        System.out.println(maximumSizeRectangleWithAll1.findLargestAreaSquare(A));
}


    public int findLargestAreaSquare(int matrix[][]){

        int row = matrix.length;
        int column = matrix[0].length;
        int result = getMaxAreaHistogram(row , column , matrix[0]);
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
                result = Math.max(result , getMaxAreaHistogram(row , column , matrix[i]));

            }
        }

        return result;

    }

    private int getMaxAreaHistogram(int row, int column, int[] matrix) {

        Stack<Integer> stack = new Stack<>();

        int i = 0 ;
        int top = 0;
        int area = 0 ;
        int maxArea = 0;

        while(i < column){
            if(stack.isEmpty() || matrix[stack.peek()] <= matrix[i]){
                stack.push(i++);
            }else{

                top = stack.peek();
                stack.pop();

                area = matrix[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < area){
                    maxArea = area;
                }
            }

        }

        while(!stack.isEmpty()){
                top = stack.peek();
                stack.pop();

                area = matrix[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if(maxArea < area){
                    maxArea = area;
                }

        }
        return maxArea;
    }
}
