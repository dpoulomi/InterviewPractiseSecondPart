//public class AvengersChasingThanos {
//
////1 adm 2 ways
//
//    //arr[1 , 2]
//    public int findWays(int[] arr , int noOfYears){
//        int n = arr.length;
//        int[] table = new int[noOfYears + 1];
//        table[0] = 1;
//        for(int i = 0 ; i < n ; i++){
//            for(int j = arr[i] ; j <= noOfYears ; j++){
//                table[j] += table[ j - arr[i]];
//            }
//
//        }
//    return table[noOfYears];
//    }
//
//}
//
//1 , 1 ,
//
//        a   --n - d
//
//        n --
//                d
//
//
//
//
//
//    1 2 3 4 5
//
//2   1 2 3 5 8
//
//
//1 1 1 1
//
//1 1 2
//
//1 2 1
//
//2 1 1
//
//2 2
//
//
//
//
//
//
//
////