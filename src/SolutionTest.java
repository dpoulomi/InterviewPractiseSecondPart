import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionTest {


    static String mergeStrings(String a, String b) {
        int length1 = a.length();
        int length2 = b.length();
        boolean flag = false;
        Character[] mergedString = new Character[length1 + length2];
        int i = 0 ; int j = 0 ;
        int k = 0 ;
        while(i < length1 && j < length2){
            if(!flag){
                mergedString[k] = a.charAt(i);
                flag = !flag;
                i++;

            }else{
                mergedString[k] = a.charAt(i);
                flag = !flag;
                j++;

            }
            k++;
        }
        while(i< length1){
            mergedString[k] = a.charAt(i);
            flag = !flag;
            i++;
            k++;
        }
        while (j < length2) {
            mergedString[k] = a.charAt(j);
            flag = !flag;
            j++;
            k++;
        }
        return String.valueOf(mergedString);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }

        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }

        res = mergeStrings(_a, _b);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}