package MSPrep;

public class StaircaseProblem {

    public static void main(String[] args) {
        StaircaseProblem staircaseProblem = new StaircaseProblem();
        staircaseProblem.climbStairs(4);
    }

    public void climbStairs(int n) {

        System.out.println(getMinimumNumberOfSteps(n));
        //return getMinimumNumberOfSteps(n);
    }

    public int getMinimumNumberOfSteps(int n){
        if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 0){
            return 0;
        }
        int ways = getMinimumNumberOfSteps(n - 1 ) + getMinimumNumberOfSteps(n - 2);
        return ways;
    }
}
