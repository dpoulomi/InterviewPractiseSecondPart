package DynammicProgramming;

public class MinimumPartitionUsingRecursion {

    public int findMinimumPartition(int[] arr, int index, int sumTotal, int sumCalculated) {

        if (index == 0) {
            return Math.abs((sumTotal - sumCalculated) -sumCalculated);

        }

        return Math.min(findMinimumPartition(arr, index - 1, sumTotal, sumCalculated + arr[index - 1]),
                findMinimumPartition(arr, index - 1, sumTotal, sumCalculated));


    }

    public void findMinimumDifferenceFromSubsets() {
        int arr[] = {1, 6, 11, 5};
        int sumTotal = 23;
        int sumCalculated = 0;

        int min = findMinimumPartition(arr, arr.length, sumTotal, sumCalculated);


    }
}
