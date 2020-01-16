import java.util.List;

public class PartitionProblemDynammicProgramming {

    public static void main(String[] args) {

    }

    public boolean findIfSubsetsPresent(int[] array){
        int sum = 0 ;
          for(int i = 0 ; i < array.length ; i++){
              sum = sum + array[i];
          }
          if(sum % 2 == 1){
              return false;
          }else{
              int sumToFind = sum / 2;
             System.out.print(findIfSubsetsPresent(sumToFind , array , array.length ));
          }

        return false;
    }

    private boolean findIfSubsetsPresent(int sumToFind, int[] array , int n) {

        if(sumToFind == 0){
            return true;
        }
        if(n == 0 && sumToFind != 0){
            return false;
        }
        if(array[n -1 ] > sumToFind){
            return findIfSubsetsPresent(sumToFind , array , n -1);
        }

        return findIfSubsetsPresent(sumToFind , array, n - 1) ||
                findIfSubsetsPresent(sumToFind - array[n - 1], array , n - 1);
    }


}
