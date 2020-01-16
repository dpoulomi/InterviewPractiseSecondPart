import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {1 , 7 , 8 , 5 ,9};
        // 1 9 8 5 7
        //9 1 8 5 7
        //9 7 8 5 1

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        Arrays.stream(arr).forEach(System.out :: println);
    }
    //1 , 7 , 8 , 5 , 9
    public void sort(int[] arr){

        int n = arr.length - 1;
        for(int i = n/2 -1 ; i >= 0 ; i--){
            heapify(arr ,n , i);
        }

        for(int i = n -1 ; i>=0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr ,i , 0);
        }

    }

    private void heapify(int[] arr ,int n , int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[largest] < arr[left]){
            largest = left;
        }
        if(right < n && arr[largest] < arr[right]){
            largest = right;
        }
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr , n , largest);
        }


    }
}
