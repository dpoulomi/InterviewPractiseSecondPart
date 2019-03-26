public class MinimumInRotatedArray {

//    When some elements at the beginning of an array are moved to the end, it becomes a rotation
//    of the original array. Please implement a function to get the minimum number in a rotation of an increasingly
//    sorted array. For example, the array {3, 4, 5, 1, 2} is a rotation of array {1, 2, 3, 4, 5}, of which the minimum is 1.
//5 1 2 3 4

    public static void main(String[] args) {
        int arr[] = {4, 5, 1 , 2,3 };
        MinimumInRotatedArray minimumInRotatedArray = new MinimumInRotatedArray();
        System.out.print(minimumInRotatedArray.getMinimum(arr));
    }

    public int getMinimum(int[] array){
        int start = 0 ;
        int end = array.length - 1;
        int mid = start + (end - start)/2;
        while(start <= end) {
            mid = start + (end - start)/2;
            if(array[mid] < array[mid -1] && array[mid]< array[mid + 1]){
                return array[mid];
            }

            if (array[mid] >= array[end]) {
                start = mid + 1;
            } else if (array[mid] <= array[end]) {
                end = mid - 1;
            }
        }
        return array[mid];
    }
}
