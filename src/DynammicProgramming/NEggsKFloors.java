package DynammicProgramming;

public class NEggsKFloors {

    public int getMinimumNoOfTrials(int eggs , int floors){
        if(floors == 0 || floors == 1){
            return floors;
        }
        if(eggs == 1){
            return floors;
        }
        int x = 0 ;
        int result = 0;
        int min = Integer.MAX_VALUE;
        for(x = 1 ; x <= floors ; x++  ) {
            result = Math.max(getMinimumNoOfTrials(eggs - 1, x - 1), getMinimumNoOfTrials(eggs, floors - x));
            if(result < min){
                min = result;

            }
        }
        return min + 1;
    }
}
