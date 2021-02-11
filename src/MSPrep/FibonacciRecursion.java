package MSPrep;

public class FibonacciRecursion {


    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 21 34
        FibonacciRecursion fibonacciRecursion = new FibonacciRecursion();
        System.out.println(fibonacciRecursion.findNthFibonacci(7));
    }
    //calculate nth fibonacci number

    public int findNthFibonacci(int n){

        if(n == 0 || n == 1){
            return 1;
        }

        int result = findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
        return result;

    }
}
