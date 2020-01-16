import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Abbreviation {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        boolean[][] DP = new boolean[a.length() + 1][b.length() + 1];
        DP[0][0] = true; // emptyString == emptyString

        boolean uppercase = false;
        for (int row = 1; row <= a.length(); row++) {
            int i = row - 1;

            // This code sets the first column to true until
            // the first instance of an upper-case letter
            if (isUpperCase(a.charAt(i)) || uppercase) {
                uppercase = true;
                DP[row][0] = false; // (upper-case letter) != emptyString
            } // (lower-case -> emptyString) == emptyString
            else DP[row][0] = true;
        }
        // fill in dp matrix
        for (int row = 1; row <= a.length(); row++) {
            int i = row - 1;

            for (int col = 1; col <= b.length(); col++) {
                int j = col - 1;

                if (a.charAt(i) == b.charAt(j)) {
                    DP[row][col] = DP[row-1][col-1];
                } else if (isUpperCase(a.charAt(i))) {
                    DP[row][col] = false;
                } else if (toUpperCase(a.charAt(i)) == b.charAt(j)) {
                    DP[row][col] = DP[row-1][col-1] || DP[row-1][col];
                }  else {
                    DP[row][col] = DP[row-1][col];
                }
            }
        }


        return DP[a.length()][b.length()] ? "YES" : "NO";
    }

    private static Character toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    public static boolean isUpperCase(char c){
        return Character.isUpperCase(c);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
