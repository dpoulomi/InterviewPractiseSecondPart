package DynammicProgramming;

public class CoinChangeProblem {

    public int findCoinChangeOptions(int totalAmount, int[] arr) {
        //
        int coinChange[] = new int[totalAmount + 1];
        coinChange[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = coinChange[i]; j <= totalAmount; j++) {

                coinChange[j] = coinChange[j] + coinChange[j - coinChange[i]];
            }


        }
        return coinChange[totalAmount];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        CoinChangeProblem coinChangeProblem = new CoinChangeProblem();
        System.out.println(coinChangeProblem.findCoinChangeOptions(5, arr));

    }
}
