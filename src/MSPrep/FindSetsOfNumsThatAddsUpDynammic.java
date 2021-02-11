//package MSPrep;
//
//public class FindSetsOfNumsThatAddsUpDynammic {
//
//
//
//    public void findNoOfSets(int[] arr){
//
//        for(int i = 0 ; i < arr.length ; i++){
//            findSets( arr, aimSum, totalSum, index);
//        }
//
//
//    }
//
//    public void findSets(int[] arr, int aimSum, int totalSum, int index){
//        if(index < arr.length){
//            totalSum = totalSum + arr[index];
//
//
//        }
//
//        if(index >= arr.length || totalSum > aimSum){
//            return;
//        }
//        if(totalSum < aimSum){
//
//            findSets();
//        }
//
//    }
//}
