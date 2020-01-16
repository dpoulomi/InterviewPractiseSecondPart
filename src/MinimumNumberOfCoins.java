public class MinimumNumberOfCoins {


    public static void main(String[] args) {
        MinimumNumberOfCoins minimumNumberOfCoins = new MinimumNumberOfCoins();
        int coins[] = {9 ,6 ,  5 , 1};
        int total = 11;
        System.out.println(minimumNumberOfCoins.findMinimumNuumberOFcoins(coins , total));
    }

    public int findMinimumNuumberOFcoins(int[] coins , int N){
       int[] table = new int[N + 1];
       table[0] = 0;
           for(int i = 1 ; i <= N ; i++){
               table[i] = Integer.MAX_VALUE ;
           }
           for(int i = 1 ; i <= N ; i++){
               for(int j = 0 ; j < coins.length  ; j++) {
                   if(coins[j] <= i){
                   int sub_result = table[i - coins[j]];
                   if (sub_result != Integer.MAX_VALUE && sub_result + 1 < table[i]) {

                       table[i] = 1 + sub_result;
                   }
               }
               }
           }
        return table[N ];
    }
}
