package MSPrep;

public class FibonacciDynammicProgramming {

    public static void main(String[] args) {
        FibonacciDynammicProgramming fibonacciDynammicProgramming = new FibonacciDynammicProgramming();
        System.out.println(fibonacciDynammicProgramming.findFibonacciNthTerm(5));
    }

    public int findFibonacciNthTerm(int n){


        int fib[] = new int[n + 1];
        fib[0] = 1;
        fib[1] = 1;
        for(int i = 2; i <= n ; i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }
}
