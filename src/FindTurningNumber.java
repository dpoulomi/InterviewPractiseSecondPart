public class FindTurningNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        FindTurningNumber findTurningNumber = new FindTurningNumber();
        System.out.print(findTurningNumber.findTurnigNumber(arr));
    }
//
//    A turning number is the maximum number in a unimodal array that increases and then
//    decreases. Please write a function (or a method) that finds the index of the turning number in a unimodal array.
//    For example, the turning number in the array {1, 2, 3, 4, 5, 10, 9, 8, 7, 6} is 10, so its index 5 is the expected
//    output.
    public int findTurnigNumber(int[] arr){

        int start = 0 ;
        int end = arr.length - 1;
        int mid = 0 ;
        if(arr.length  <= 2){
            return -1;
        }
        while(start <= end){
            mid = start + (end - start)/2;
            if(mid == 0 || mid == arr.length - 1){
                return -1 ;
            }
            if( arr[mid] > arr[mid - 1]  && arr[mid] < arr[mid + 1]){
                start = mid;
            }else if(arr[mid] > arr[mid - 1]  && ( arr[mid] > arr[mid + 1])){

                return arr[mid];
            }else{
                end = mid;
            }

        }
            return -1;
    }
}
