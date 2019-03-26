public class ReversedPair {

    public static void main(String[] args) {
        int[] inputArray = {7, 5, 6, 4};
        ReversedPair pair = new ReversedPair();
        int startIndex = 0;
        int endIndex = inputArray.length - 1;
        int[] bufferArray = new int[inputArray.length];
        System.out.print(pair.getReversedPairs(inputArray , startIndex , endIndex , bufferArray));
    }

    private int getReversedPairs(int[] inputArray , int startIndex , int endIndex , int[] bufferArray) {

        if(endIndex >= startIndex) {
            int mid = startIndex + (endIndex - startIndex)/2;
            int start = getReversedPairs(inputArray, startIndex, mid , bufferArray);
            int end = getReversedPairs(inputArray, mid + 1, endIndex , bufferArray);

            int between =merge(startIndex ,mid ,  endIndex, inputArray , bufferArray);
            return  start + end + between;
        }
            return 0;

    }

    private int merge(int start,int mid,  int end, int[] inputArray , int[] bufferArray) {
       int count = 0;
       int i =mid;
       int j = end;
       int k = end;

       while(i >= start && j >= mid + 1) {
           if (inputArray[i] > inputArray[j]) {
               count = count + (j- mid);
               bufferArray[k--] = inputArray[i--];
           } else {
               bufferArray[k--] = inputArray[j--];
           }
       }
        while(i >= start) {

            bufferArray[k--] = inputArray[i--];
        }
        while(j >= mid + 1) {

            bufferArray[k--] = inputArray[j--];
        }
        for(int l = start ;l< end;l++){
           inputArray[l] = bufferArray[l];

        }
        return count;

       }

}
