import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {

    class ProfitTracker{

        private int buy ;

        private int sell;

        ProfitTracker(int buy , int sell){
            this.buy = buy;
            this.sell = sell;
        }
    }

    public static void main(String[] args) {
        StockBuyAndSell stockBuyAndSell = new StockBuyAndSell();
        int arr[] = {100, 180, 26, 310, 40, 535, 30};
        List<ProfitTracker> profitTrackers = stockBuyAndSell.getMaximumProfitDays(arr);

        profitTrackers.stream().forEach(e -> System.out.println(e.buy + "   " + e.sell));


    }
    public List<ProfitTracker> getMaximumProfitDays(int[] arr){



        List<ProfitTracker> profitTrackers = new ArrayList<>();

        int maxDifference = arr[1] - arr[0];
        int minIndex = 0;
        int maxIndex = 1;

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] - arr[minIndex] > maxDifference){
                maxDifference = arr[i] - arr[minIndex];
                maxIndex = i;
            }
            if(i == arr.length - 1 || arr[i] < arr[minIndex]){
                ProfitTracker profitTracker = new ProfitTracker(minIndex , maxIndex);
                profitTrackers.add(profitTracker);
                minIndex = i;
                maxDifference = arr[i] - arr[minIndex];
            }
        }

        return profitTrackers;
    }


}
