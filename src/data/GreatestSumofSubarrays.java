package data;

public class GreatestSumofSubarrays {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        GreatestSumofSubarrays sumofSubarrays = new GreatestSumofSubarrays();
        sumofSubarrays.getGreatestSum(array);
    }

    private void getGreatestSum(int[] array) {
        int currentSum = 0;
        int maxiMumSum = 0;

        for(int i = 0 ; i< array.length ; i++){
            currentSum = getMaximum( array[i] , currentSum + array[i]);

//           if(currentSum <= 0){
//               currentSum = array[i];
//           }else{
//               currentSum = currentSum + array[i];
//           }
           maxiMumSum = Math.max(currentSum, maxiMumSum);
        }
        System.out.println(maxiMumSum);
    }

    private int getMaximum(int currentSum, int i) {
        return currentSum > i ? currentSum : i ;
    }
}
