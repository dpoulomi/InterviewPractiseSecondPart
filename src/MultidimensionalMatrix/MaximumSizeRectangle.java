package MultidimensionalMatrix;

import java.util.Stack;

public class MaximumSizeRectangle {


    public static void main(String[] args) {


        int array[][] = {{0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}};

        int area = calculateMaxArea(array[0], array[0].length);

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {

                if (array[i][j] == 1) {
                    array[i][j] = array[i][j] + array[i - 1][j];
                }

            }
            area = Math.max(calculateMaxArea(array[i], array[i].length), area);
        }

        System.out.println(area);
    }

    private static int calculateMaxArea(int[] hist, int length) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int top = 0;
        int tempArea = 0;
        int maxArea = 0;
        while (index < length) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[index]) {
                stack.push(index++);
            } else {
                top = stack.peek();
                stack.pop();
                tempArea = hist[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                if (maxArea < tempArea) {
                    maxArea = tempArea;
                }
            }
        }

        while (!stack.isEmpty()) {
            top = stack.peek();
            stack.pop();
            tempArea = hist[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            if (maxArea < tempArea) {
                maxArea = tempArea;
            }

        }

        return maxArea;

    }


}
