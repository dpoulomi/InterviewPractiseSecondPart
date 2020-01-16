public class SearchIn2DMatrix {


    public boolean search(){

        int[][] arr = {{1, 3, 5},
                       {7 , 9 , 11},
                       {13, 15 , 17}};

        int noToSearch = 9;

        int rows = arr.length;
        int cols = arr[0].length;
        int start = 0 ;
        int end = rows * cols - 1;

        while(start < end){
            int mid = start + (end - start);
            int row = mid/ cols ;
            int col = mid%cols ;
            if(arr[row][col] == noToSearch){
                return true ;
            }else if(arr[row][col] > noToSearch){
                end = mid -1;
            }else{
                start = mid + 1;
            }


        }



        return false;
    }
}
