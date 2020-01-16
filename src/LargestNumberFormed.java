import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFormed {


    public static void main(String[] args) {
        int arr[] = {54 , 546 , 548 , 60};
        LargestNumberFormed largestNumberFormed = new LargestNumberFormed();
        largestNumberFormed.largestNumberformed(arr);
    }

    public void largestNumberformed(int[] arr){
        String[] stringArray = new String[arr.length];
            for(int i = 0 ; i < stringArray.length ; i++){
                stringArray[i] = String.valueOf(arr[i]);
            }
        Arrays.sort(stringArray , new NumericComparator());
        for(int i = 0 ; i < stringArray.length ; i ++){

                System.out.print(stringArray[i]);
        }


    }


    public class NumericComparator implements Comparator<String>{

        public int compare(String string1 , String string2){
            String num1 = string1 + string2;
            String num2 = string2 + string1;
            return num1.compareTo(num2) > 0 ? - 1 :  1;
        }
    }
}
