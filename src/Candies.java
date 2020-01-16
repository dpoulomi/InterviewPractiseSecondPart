import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        long[] leftCandyCount = new long[arr.length];

        long noOfCandiesRight = 0;
        leftCandyCount[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                leftCandyCount[i] = leftCandyCount[i - 1] + 1;

            } else {

                leftCandyCount[i] = 1;
            }
        }


        long[] rightCandyCount = new long[arr.length];

        rightCandyCount[n-1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                rightCandyCount[i] = rightCandyCount[i + 1] + 1;

            } else {

                rightCandyCount[i] = 1;
            }
        }

        for(int i = 0 ; i < leftCandyCount.length ; i++){
            if(leftCandyCount[i] > rightCandyCount[i]){
                noOfCandiesRight = noOfCandiesRight + leftCandyCount[i];
            }else {
                noOfCandiesRight = noOfCandiesRight + rightCandyCount[i];
            }
        }


        return noOfCandiesRight;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
