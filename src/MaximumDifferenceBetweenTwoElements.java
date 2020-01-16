public class MaximumDifferenceBetweenTwoElements {

    public int findMaximumDifference(int[] arr){
    // 2 , 3, 10 , 6 , 4 , 8 , 1
      int min_element = Integer.MAX_VALUE;
      int max_diff = Integer.MIN_VALUE;

       max_diff = arr[1] - arr[0];
       min_element = arr[0];

       for(int i = 1 ; i < arr.length ; i++){
           if(arr[i] - min_element > max_diff){

               max_diff = arr[i] - min_element;
           }

           if(arr[i] < min_element){
               min_element = arr[i];
           }
       }

        return max_diff;

    }
}
