package DynammicProgramming;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.findLongestIncreasingSubsequence(arr));
    }

    public int findLongestIncreasingSubsequence(int[] arr) {
        int[] LIS = new int[arr.length];

        for (int i = 0; i < LIS.length; i++) {
            LIS[i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }
        int maxSequence = 0;
        for (int i = 0; i < LIS.length; i++) {
            if(maxSequence < LIS[i]){
                maxSequence = LIS[i];
            }
        }
        return maxSequence;
    }
}
