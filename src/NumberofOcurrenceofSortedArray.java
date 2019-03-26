public class NumberofOcurrenceofSortedArray {

    public static void main(String[] args) {
        NumberofOcurrenceofSortedArray numberofOcurrenceofSortedArray = new NumberofOcurrenceofSortedArray();
        int arr[] = {1, 2, 2, 2 , 2, 3, 3, 3, 3,3, 4, 5};
        int noToSearch = 4;
        int start = 0;
        int end = arr.length-1;
        System.out.println(numberofOcurrenceofSortedArray.findNumberOfOccurrences(noToSearch, arr , start, end));
    }

    private int findNumberOfOccurrences(int noToSearch, int[] arr , int start , int end) {
        int occurence = 0;
        int left = findOccurenceFromLeft(noToSearch , arr , start , end);
        int right = findOccurenceFromRight(noToSearch , arr , start, end);
        if(left > -1 && right > -1){
            occurence = right - left +1;
        }

        return occurence;


    }

    private int findOccurenceFromLeft(int noToSearch, int[] arr, int start, int end) {
        {


            while(start<= end){
                int mid = start + (end - start)/2;
                if(arr[mid] == noToSearch){
                    if((mid > 0 && arr[mid-1]!=noToSearch) || mid == 0){
                        return mid;
                    }
                    end = mid -1;

                }else if(arr[mid] > noToSearch){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }


            }

        }
        return -1;
    }

    private int findOccurenceFromRight(int noToSearch, int[] arr, int start, int end) {

        if(start > end){
            return -1;
        }
        while(start<= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == noToSearch){
                if((mid < arr.length - 1 && arr[mid + 1]!=noToSearch) || mid == arr.length-1){
                    return mid;
                }
                start = mid + 1;

            }else if(arr[mid] > noToSearch){
                end = mid -1;
            }else{
                start = mid + 1;
            }


        }
        return -1;
    }

//    private int searchForMore(int noToSearch, int mid, int[] arr) {
//           int startIndex = mid ;
//           int count = 0;
//            startIndex = mid + 1;
//           while(arr[startIndex] == mid){
//               startIndex++;
//               count++;
//           }
//           startIndex = mid-1;
//            while(arr[startIndex] == mid){
//                startIndex--;
//                count++;
//            }
//            return count+1;
//    }
}
