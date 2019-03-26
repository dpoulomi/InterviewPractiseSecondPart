public class EditDistanceDynamicProgramming {

    public static void main(String[] args) {
        String firstString = "Sunday";
        String secondString = "Saturday";
        EditDistanceDynamicProgramming editDistanceDynamicProgramming = new EditDistanceDynamicProgramming();
        int minOperation = editDistanceDynamicProgramming.getMinimumOperation(firstString , secondString);
        //int minOperation = getMinimumOperation(firstString , secondString);
        System.out.println(minOperation);
    }

    private int min(int x , int y , int z){
        if(x <= z && x <= y ){
            return x;
        }else if(y <= z && y <= x){
            return y;
        }else{
            return z;
        }

    }

    private  int getMinimumOperation(String firstString, String secondString) {
        int m = firstString.length();
        int n = secondString.length();

        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <=m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    L[i][j] = j;

                } else if (j == 0) {
                    L[i][j] = i;
                } else if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    L[i][j] = L[i - 1][j - 1];
                } else {
                    L[i][j] = min(L[i - 1][j], L[i][j - 1], L[i-1][j-1]) + 1;
                }

            }

        }
        return L[m][n];
    }
}
