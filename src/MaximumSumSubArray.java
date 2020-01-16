public class MaximumSumSubArray {

    static int maximumToys(int[] prices, int k) {
        int start = 0 ;
        int end = prices.length - 1;
       int sum = 0 ;
        sort(prices ,start , end );
        int i = 0;
        for( i  = 0 ; i < prices.length ; i++){

           if(sum + prices[i] <= k){
               sum = sum + prices[i];
           }else{
               break;
           }
        }
        return i;

    }

    public static void main(String[] args) {
        int prices[] = {1 ,12, 5 ,111 ,200 ,1000, 10};
        int k = 50;
        System.out.print(maximumToys(prices , k));
    }
   static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
}
