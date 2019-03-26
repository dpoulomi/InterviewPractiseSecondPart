public class CheckMaajoritiesInAnArray {


    public void checkMajorities(){
        int[] arr = {1 , 2, 3 , 2 , 2, 2, 4, 5 , 6 };
        int times = 0 ;
        CheckMaajoritiesInAnArray checkMaajoritiesInAnArray = new CheckMaajoritiesInAnArray();
        checkMaajoritiesInAnArray.findMajorities(arr , times);

    }

    private void findMajorities(int[] arr, int times) {

        int result = arr[0];
        times = 1;
        for(int i = 1 ; i < arr.length; i++ ){
            if(times == 0){
                result = arr[i];
                times = 1;
            }else if(result == arr[i]){
                times++ ;
            }else{
                times-- ;
            }

        }
    }
}
