public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.findLongestCommonSubsequence(s1 , s2));
    }

    public int findLongestCommonSubsequence(String s1 , String s2){
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0 ; i <= s1.length() ; i++){
            for(int j = 0 ; j <= s2.length() ; j++){
                if(i == 0 || j == 0){
                    arr[i][j] = 0;
                }
                else if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }else {
                    arr[i][j] = Math.max(arr[i - 1][j] ,arr[i][j -1] );
                }
            }
        }
        return arr[s1.length()][s2.length()];
    }
}
