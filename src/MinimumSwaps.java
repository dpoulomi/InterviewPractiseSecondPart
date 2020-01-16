import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        //7, 1, 3, 2, 4, 5, 6
        // 6 , 1 , 3, 2, 4 , 5 , 7
        // 6, 3, 2, 4, 5, 7

        int count  = 0;
        //  for(int i = 0 ; i < arr.length ; i++){
        int i = 0;
        int j = arr.length;
        for( ; i< arr.length ; i++){
            while(arr[i]- 1 != i){
                int temp = arr[i];
                int temp1 = arr[i]-1;
                arr[i] = arr[arr[i]-1];
                arr[temp1] = temp ;

                count++;
            }
        }
        return count ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] arr = {4 , 3 , 1,2};
        System.out.print(minimumSwaps(arr));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        int res = minimumSwaps(arr);
//
//        bufferedWriter.write(String.valueOf(res));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
