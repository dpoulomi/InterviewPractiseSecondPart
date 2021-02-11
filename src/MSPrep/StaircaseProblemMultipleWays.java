package MSPrep;

public class StaircaseProblemMultipleWays {

    public static void main(String[] args) {
        StaircaseProblemMultipleWays staircaseProblem = new StaircaseProblemMultipleWays();
        staircaseProblem.climbStairs(4, 4);
    }

    public void climbStairs(int n, int m) {

        System.out.println(getMinimumNumberOfSteps(n, m));
        //return getMinimumNumberOfSteps(n);
    }

    public int getMinimumNumberOfSteps(int n, int max){
        if(n <= 1){
            return n;
        }
        int ways = 0;
        for(int i = 1; i < n && i < max ; i++) {
             ways = getMinimumNumberOfSteps(n - i , max);
        }
        return ways;
    }
}
