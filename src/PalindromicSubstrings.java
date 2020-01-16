import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PalindromicSubstrings {

    // Complete the substrCount function below.
//    static long substrCount(int n, String s) {
//        long count= 0 ;
//        String temp = "";
//        StringBuffer stf ;
//        count = s.length();
//        for(int i = 0 ; i<= s.length() ; i++){
//            for(int j = i+1 ; j<= s.length() ; j++){
//                temp = s.substring(i, j);
//                if (temp.length() >= 2) {
//                    stf = new StringBuffer(temp);
//                    stf.reverse();
//                    if (stf.toString().equals(temp)) {
//                        int mid = temp.length()/2;
//                        if(temp.length()%2 == 0 || temp.substring(0 , mid).equals(temp.substring(mid+1 , temp.length()))) {
//                            System.out.println(stf);
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }


    static long substrCount(int n, String s) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            int innerCounter = 1;

            int counterDown = 0;
            int counterUp = 1;
            while (i - innerCounter >= 0 && i + innerCounter < s.length()
                    && s.charAt(i - innerCounter) == s.charAt(i - 1) && s.charAt(i + innerCounter) == s.charAt(i - 1)) {
                System.out.print(s.charAt(i - 1));
                count++;
                innerCounter++;
            }

            while (i - counterDown >= 0 && i + counterUp < s.length() && s.charAt(i - counterDown) == s.charAt(i)
                    && s.charAt(i + counterUp) == s.charAt(i)) {
                System.out.print(s.charAt(i - counterDown));
                count++;
                counterDown++;
                counterUp++;
            }
        }

        return count + s.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
