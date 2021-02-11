package DynammicProgramming;

public class EditDistance {


    public int editDistance(String firstString, String secString) {

        int[][] ED = new int[firstString.length() + 1][secString.length() + 1];
        for (int i = 0; i <= firstString.length(); i++) {
            for (int j = 0; j <= secString.length(); j++) {
                if (i == 0) {
                    ED[0][j] = j;
                } else if (j == 0) {
                    ED[i][0] = i;
                } else if (firstString.charAt(i - 1) == secString.charAt(j - 1)) {
                    ED[i][j] = ED[i - 1][j - 1];
                } else {
                    ED[i][j] = 1 + Math.min(Math.min(ED[i - 1][j - 1], ED[i][j - 1]), ED[i - 1][j]);
                }
            }

        }
        return ED[firstString.length()][secString.length()];

    }

}
