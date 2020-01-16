public class LongestIncreasingSubsequence {

    public int findLongestIncreasingSubsequence(int[] array){
        int max = 0 ;
        int table[] = new int[array.length];
        for(int i = 0 ; i < array.length ; i++){
            table[i] = 1;
        }

        for(int i = 1 ; i < array.length ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(array[i] > array[j] && table[i] < table[j] + 1){
                    table[i] = table[j] + 1;
                }
            }
        }
        for(int i = 0 ; i < table.length ; i++){
            if(max < array[i]){
                max = array[i];
            }
        }
        return max;
    }
}
