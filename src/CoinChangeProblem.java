public class CoinChangeProblem {

    public static void main(String[] args) {
        int arr[] = {9, 5 , 2};
        int sum = 9;

     int noOfBoxes = findBoxCount(arr, sum);
     System.out.println(noOfBoxes);
    }

    private static int findBoxCount(int[] arr, int sum) {

        if(sum == 0){
            return 0;
        }
        if(sum <0){
            return  -1;
        }

        int min = -1;
        for(int box : arr){
            int currentMin = findBoxCount(arr, sum - box);
            if(currentMin>=0){
                min = min < 0 ? currentMin : Math.min(currentMin , min);
            }

        }
        return min<0 ? -1: min+1;
    }
}
