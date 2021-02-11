package MSPrep;

import java.util.Arrays;

public class FindSetsOfNumsThatAddUpto16 {


private static int noOfSets = 0;

    public static void main(String[] args) {
        FindSetsOfNumsThatAddUpto16 findSetsOfNumsThatAddUpto16 = new FindSetsOfNumsThatAddUpto16();
        int arr[] = {2 , 4 , 6 , 10};
        findSetsOfNumsThatAddUpto16.arrayIteration(arr);
        System.out.println(noOfSets);
    }

public void arrayIteration(int arr[]){


    for(int i = 0 ; i < arr.length ; i++){

        findSets(arr, 6, 0 , i);

    }

}

    public void findSets(int arr[] , int sum, int sumSoFar , int index){
        //2 4 6 10
        //sum 16

        if(index < arr.length ) {
            sumSoFar = sumSoFar + arr[index];
        }
        if(sumSoFar == sum){
            noOfSets++;
        }
        if(sumSoFar < sum) {
            findSets(arr, sum, sumSoFar, index++);
        }
        if(sumSoFar > sum || index >= arr.length){

            return;
        }
    }
}
