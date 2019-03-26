import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ConcatenateArrayToGetMinimumNUmber {

    public static void main(String[] args) {
        int[] inputArray = {3, 32, 321};
        ConcatenateArrayToGetMinimumNUmber arrayToGetMinimumNUmber = new ConcatenateArrayToGetMinimumNUmber();
        arrayToGetMinimumNUmber.getMinimumNumber(inputArray);
    }

    private void getMinimumNumber(int[] inputArray) {
        String[] numbers = new String[inputArray.length];
        for(int i = 0 ; i< inputArray.length ; i++){
            numbers[i] = String.valueOf(inputArray[i]);
        }
        Arrays.sort(numbers , new NumericComparator());
        Arrays.stream(numbers).forEach(System.out::print);
    }

    public class NumericComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String firstString = o1 + o2;
            String secondString = o2 + o1;
//            if (firstString.compareTo(secondString) > 0) {
//                return 1;
//            } else if (firstString.compareTo(secondString) < 0) {
//                return -1;
//            } else {
//                return 0;
//            }
            return firstString.compareTo(secondString);
        }
    }
}
