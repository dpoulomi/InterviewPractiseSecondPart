public class MinimumKNumbers {
    public static void main(String[] args) {

        int[] numbers = {4, 5, 1, 6, 2, 7, 3, 8};
        MinimumKNumbers minimumKNumbers = new MinimumKNumbers();
        minimumKNumbers.getMinimumKNumbers(numbers);
    }

    private void getMinimumKNumbers(int[] numbers) {
        MinHeap  minHeap = new MinHeap();
        for(int i = 0 ; i< numbers.length ; i++){
            minHeap.add(numbers[i]);
        }
        int k = 5;
        for(int i = 0 ; i< 5 ; i++ ){
            int element = minHeap.delete();
           System.out.println(element);
        }
    }
}
