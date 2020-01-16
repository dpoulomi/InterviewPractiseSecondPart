import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletInGeometric {


    static long countTriplets(List<Long> arr, long commonRatio) {
        long cnt = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Long> rMap = new HashMap<>();
        for (long n : arr) {
            if (n % commonRatio == 0) {
                long pre = n / commonRatio;// here was the mistake 'enter code here'
                Long cnt2 = rMap.get(pre);
                if (cnt2 != null)
                    cnt += cnt2;

                Long cnt1 = map.get(pre);
                if (cnt1 != null)
                    rMap.put(n, rMap.getOrDefault(n, 0L) + cnt1);
            }
            map.put(n, map.getOrDefault(n, 0L) + 1);
        }
        return cnt;
    }



    public static void main(String[] args) {
       List<Long> arr = new ArrayList<>();
//       arr.add(new Long(1));
//        arr.add(new Long(5));
//        arr.add(new Long(5));
//        arr.add(new Long(25));
//        arr.add(new Long(125));
//        long r = 5;

       long r = 3;

        arr.add(new Long(1));
        arr.add(new Long(3));
        arr.add(new Long(9));
        arr.add(new Long(9));
        arr.add(new Long(27));
        arr.add(new Long(81));
        System.out.print(countTriplets(arr , r ));
    }
}
