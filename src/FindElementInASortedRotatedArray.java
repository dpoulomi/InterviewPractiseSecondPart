import java.security.spec.PSSParameterSpec;

public class FindElementInASortedRotatedArray {

    public static void main(String[] args) {
        FindElementInASortedRotatedArray findElementInASortedRotatedArray = new FindElementInASortedRotatedArray();
       System.out.println (findElementInASortedRotatedArray.findElement());
    }


    public  int findElement() {
        int[] arr = {30, 40, 50, 10, 20};
        int element = 20;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            mid = start + (end - start) / 2;
//            if (mid == 0 || mid == arr.length - 1) {
//                return -1;
//            }
            if(arr[start] == element){
                return start;
            }
            if(arr[end] == element){
                return end;
            }
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element && arr[start] <= element) {
                end = mid - 1;
            }
//            else if (arr[mid] < element && arr[start] >= element) {
//                end = mid -1 ;
//            }
            else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
