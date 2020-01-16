import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Solution23 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[] ) throws Exception {




        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("testResult.test"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

      //  int n = Integer.parseInt(nr[0]);

        int r = Integer.parseInt(nr[0]);
        for(int i = 0 ; i < r ; i++){

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());




            String result = result(arr);

            bufferedWriter.write(String.valueOf(result));

            bufferedWriter.newLine();
        }



        bufferedWriter.close();

        scanner.close();
    }

    public static int findMaxElement(List<Integer> arr){
        int max = arr.get(0);
        for(int i = 1 ; i < arr.size(); i++){
            if(arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }

    public static boolean checkHasEvents(List<Integer> arr){
        for(int i = 0 ; i < arr.size(); i++){
            if(arr.get(i) != i + 1){
                return false;
            }
        }
        return true;
    }

    public static boolean checkForInValid(List<Integer> arr){
        for (int i = 0; i < arr.size(); i++) {


            if(!(arr.get(i) instanceof Integer)){
                invalidLine = i + 1;
                return true;
            }
        }
        return false;
    }
    private static int invalidLine = 0;
    public static String result(List<Integer> arr){
        String result = "";
        int length = arr.size();
        int max = findMaxElement(arr);
        if(length < max){
            result = "FAILURE => RECEIVED: "+length+", EXPECTED: "+ max;
            return result;
        }else if(length == max){
            boolean inValid = checkForInValid(arr);
            if(inValid){
                result = "FAILURE => WRONG INPUT "+ "(LINE "+invalidLine;
                return result;
            }
            boolean check = checkHasEvents(arr);
            if(check){
                result = "SUCCESS => RECEIVED: "+ max;
                return result;
            }
        }
        // for(int i = 0 ; i < length; i++){

        // }
        return result;
    }
}

