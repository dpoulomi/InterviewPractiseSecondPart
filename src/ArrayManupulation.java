import java.util.HashMap;
import java.util.Map;

public class ArrayManupulation {

    static long arrayManipulation(int n, int[][] queries) {
        int[] sum = new int[n];
        int[] diff = new int[n];
        diff[0] = sum[0];
        for(int i = 1 ; i< n ; i++){
            diff[i] = sum[i] - sum[i -1];
        }
        for(int i = 0 ; i< queries.length ; i++){
            createDifferenceArray(sum , diff , queries , i);
        }
        for(int i = 1 ; i < n ; i++){
            createSumArray(sum , diff , queries , i);
        }
        for(int i = 0 ; i < n ; i++){
            if(max < sum[i]){
                max = sum[i];
            }
        }
        return max;
    }
    Map<Integer , Integer> hashMap = new HashMap<>();

    private static int max = 0;
    public static void createSumArray(int[] sum ,int[] diff , int[][] queries ,int index){
        sum[index] = diff[index] + sum[index - 1];



    }
    public static void createDifferenceArray(int[] sum, int[] diff, int[][] queries , int index)  {
        diff[queries[index][0]-1] =  diff[queries[index][0]-1] + queries[index][2];
        diff[queries[index][1]-1] =  diff[queries[index][1]-1] - queries[index][2];
    }

    public static void main(String[] args) {

        ArrayManupulation arrayManupulation = new ArrayManupulation();

    }
}
