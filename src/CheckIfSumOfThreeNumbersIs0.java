import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class CheckIfSumOfThreeNumbersIs0 {
    public static void main(String[] args) {
        CheckIfSumOfThreeNumbersIs0 checkIfSumOfThreeNumbersIs0 = new CheckIfSumOfThreeNumbersIs0();
        int arr[] = {-1, 0, 2, 3, 3, 4, -5};
        System.out.println(checkIfSumOfThreeNumbersIs0.getTriplet(arr));
    }

    private boolean getTriplet(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean found = findSum(i, arr);
            if (found) {
                return found;
            }
        }
        return false;
    }
    // 
    private boolean findSum(int excludeIndex, int[] arr) {
        int noToSearch = arr[excludeIndex] * (-1);
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            // if excludeIndex matches with the startIndex and endIndex
            if(excludeIndex == startIndex){
                startIndex ++;
            }
            else if(excludeIndex == endIndex ){
                endIndex--;
            }
            if (noToSearch == arr[startIndex] + arr[endIndex]) {
                return true;
            } else if (noToSearch > arr[startIndex] + arr[endIndex]) {
                startIndex++;
            } else {
                endIndex--;
            }

        }
        return false;
    }
}
