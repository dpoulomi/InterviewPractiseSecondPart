import java.util.ArrayList;
import java.util.List;

public class Xor {


    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        int empty = 0 ;
        List<Integer> binaryList = new ArrayList<>();

        for(int j = 0 ; j < days ; j++) {

            for (int i = 0; i < states.length; i++) {
                if (i == 0) {
                    binaryList.add(empty ^ states[i + 1]);
                } else if (i == states.length - 1) {
                    binaryList.add(states[i - 1] ^ empty);
                } else {
                    binaryList.add(states[i - 1] ^ states[i + 1]);
                }
            }

           for(int i = 0 ; i < states.length ; i++){
                states[i] =binaryList.get(i);
           }
           if(j < days - 1){
               binaryList.clear();
           }
        }
            return binaryList;
    }

    public static void main(String[] args) {
        //int arr[]  = {1 , 0 , 0 , 0 , 0 , 1 , 0 , 0};
        int arr[]  = {1 , 1 , 1 , 0 , 1 , 1 , 1 , 1};
     //   int arr[]  = {1 , 0 , 1 , 0 , 1 , 0 , 0 , 1};
        int i = 2;
        Xor xor = new Xor();
       List<Integer> integers =  xor.cellCompete(arr , i);
       integers.stream().forEach(System.out:: println);
    }
}
