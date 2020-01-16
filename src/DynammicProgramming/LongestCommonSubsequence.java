package DynammicProgramming;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.findLongestCommonSubsequence());
    }

    public int findLongestCommonSubsequence() {

        String string1 = "ABCDGH";
        String string2 = "AEDFHR";
        int m = string1.length();
        int n = string2.length();


        int[][] LCS = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    LCS[i][j] = 0;
                } else if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }

            }

        }

        return LCS[m][n];


    }
}
