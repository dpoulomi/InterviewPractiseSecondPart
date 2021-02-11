package DynammicProgramming;

public class SubsetSum {


    public boolean subsetIsPresent(int arr[], int sum) {


        boolean ss[][] = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            ss[i][0] = true;
        }


        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    ss[i][j] = ss[i - 1][j] || ss[i - 1][j - arr[i - 1]];
                } else {

                    ss[i][j] = ss[i - 1][j];
                }
            }
        }

        return ss[arr.length][sum];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 7, 8, 10};
        int sum = 14;
        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.subsetIsPresent(arr, sum));

    }
}
