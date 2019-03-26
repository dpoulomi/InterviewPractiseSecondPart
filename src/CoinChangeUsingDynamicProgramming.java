public class CoinChangeUsingDynamicProgramming {

    public static void main(String[] args) {
        int v = 11;
        int coins[] = { 9 , 6 , 5 ,1};
        CoinChangeUsingDynamicProgramming coinChangeUsingDynamicProgramming = new CoinChangeUsingDynamicProgramming();
        int noOfCoins = coinChangeUsingDynamicProgramming.getMinimumNoOfCoins(coins,v);
        System.out.println(noOfCoins);
    }

    private int getMinimumNoOfCoins(int[] coins, int v) {
        int store[] = new int[v+1];
        store[0] = 0;
        for(int i = 1; i<=v ;i++){
            store[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i <= v;i ++){
            for(int j = 0 ; j< coins.length ; j++){
                if(coins[j]<= i){
                    int result = store[i - coins[j]] ;
                    if(result != Integer.MAX_VALUE && result+1 < store[i]) {
                        store[i] = result + 1;
                    }
                }
            }
        }
        return store[v];
    }
}
