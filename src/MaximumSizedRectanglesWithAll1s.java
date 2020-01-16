import java.util.Stack;

public class MaximumSizedRectanglesWithAll1s {

    // Driver code
    public static void main (String[] args)
    {
        int matrix[][] = { {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        System.out.print("Area of maximum rectangle is " +
                maxRectangle(rowSize,columnSize,matrix));
    }

    private static int maxRectangle(int rowSize, int columnSize, int[][] a) {
        int result = calculateMaxHistogram(rowSize , columnSize , a[0]);
        for(int i = 1 ; i < a.length ; i++){
            for (int j = 0 ; j < a[0].length ; j++){
                if(a[i][j] == 1){
                    a[i][j] = a[i][j] + a[i - 1 ][j];
                }

            }
            result =  Math.max(result , calculateMaxHistogram(rowSize , columnSize , a[i]));
        }
        return result;
    }

    private static int calculateMaxHistogram(int rowSize, int columnSize, int[] array) {
        Stack<Integer> stack = new Stack<>();
        int top_value = 0 ;
        int i = 0 ;
        int maxArea = 0 ;
        int area = 0;
        while(i < columnSize){
            if(stack.isEmpty() || array[stack.peek()] <= array[i]){
                stack.push(i++);
            }else{
                top_value =  array[stack.peek()];
                stack.pop();
                area = top_value * i;
                if(!stack.isEmpty()) {
                    area = top_value * (i - stack.peek() - 1);
                }
                if(maxArea < area){
                    maxArea = area;
                }
            }
        }
            while(!stack.isEmpty()){
                top_value =  array[stack.peek()];
                stack.pop();
                area = top_value * i;
                if(!stack.isEmpty()) {
                    area = top_value * (i - stack.peek() - 1);
                }
                if (maxArea < area) {
                    maxArea = area;
                }
            }
            return maxArea;

    }
}
