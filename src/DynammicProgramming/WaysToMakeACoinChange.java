package DynammicProgramming;

public class WaysToMakeACoinChange {


    public static void main(String[] args) {
        WaysToMakeACoinChange waysToMakeACoinChange = new WaysToMakeACoinChange();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        int n = 4;
        System.out.println(waysToMakeACoinChange.getWaysForCoinChange(arr , n));
    }



    public int getWaysForCoinChange(int coins[] , int V){
        int table[] = new int[V + 1];
        table[0] = 1;
        for(int i = 0 ; i < coins.length  ;  i ++){
            for(int j = coins[i]; j <= V ; j ++){
                table[j] = table[j] + table[j - coins[i]];
            }
        }
        return table[V];
    }
}
