public class UglyNumberUsingMultipleFactors {


    public static void main(String[] args) {
        int index = 10;
        UglyNumberUsingMultipleFactors uglyNumberUsingMultipleFactors = new UglyNumberUsingMultipleFactors();
        int kthUglyNumber = uglyNumberUsingMultipleFactors.getKthUglyNumber(index);
        System.out.println(kthUglyNumber);
    }

    private int getKthUglyNumber(int index) {
        if(index < 0){
            return  0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyNum = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(nextUglyNum < index){
            int min = Math.min(uglyNums[index2]*2 , uglyNums[index3]*3);
            min = Math.min(min , uglyNums[index5] * 5);
            uglyNums[nextUglyNum] = min;
            while (uglyNums[index2] *2 <= uglyNums[nextUglyNum]){
                index2++;
            }
            while(uglyNums[index3] *3 <= uglyNums[nextUglyNum]){
                index3++;
            }
            while(uglyNums[index5] *5 <= uglyNums[nextUglyNum]){
                index5++;
            }
            nextUglyNum++;
        }
        return uglyNums[nextUglyNum - 1];
    }
}


