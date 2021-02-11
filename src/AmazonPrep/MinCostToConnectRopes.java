package AmazonPrep;

import java.util.Arrays;

public class MinCostToConnectRopes {


    public int getMinCost(int[] ropes){
        //[8, 4, 6, 12]

        Arrays.sort(ropes);
        // 4 , 6 , 8 , 12
        int cost = 0;
        int i = 0;
        for(i = 0 ; i < ropes.length - 1 ; i++){
            cost = ropes[i] + ropes[i + 1];
            ropes[i+ 1] = cost;

        }
        cost = 0 ;
        for(i = 1; i <  ropes.length ; i++){
            cost = cost + ropes[i];
        }
        return cost;
    }

    public static void main(String[] args) {
        MinCostToConnectRopes minCostToConnectRopes = new MinCostToConnectRopes();
        System.out.println(minCostToConnectRopes.getMinCost(new int[] {1, 2, 5, 10, 35, 89}));
    }
}


