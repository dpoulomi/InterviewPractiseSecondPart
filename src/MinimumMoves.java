//import java.util.*;
//
//public class MinimumMoves {
//
//
//
//
////    List<Integer> lengthSubsequenceShoppers(List<Character> inputList){
////        for(int i = 0 ; i < inputList.size() ; i++){
////
////            Character c = inputList.get(i);
////            if(!start)
////        }
////
////
////    }
//
//
//    public static void main(String[] args) {
//        Character[] input  = {'a' , 'b', 'c', 'd', 's', 'e', 'f', 'g' , 'h', 'i' ,'j', 'e'};
//        List<Character> inputList = Arrays.asList(input);
//        MinimumMoves minimumMoves = new MinimumMoves();
//        minimumMoves.lengthSubsequenceShoppers(inputList);
//        String s = "jhvjhj hgvhdv";
//       String[] ch =s.
//        Character first = ch[1].charAt(0);
//       // if (Character.isDigit(ch[0].charAt(0));
//        if(first == first.toLowerCase(first)){}
//
//    }
//
//
//  //  public int[] sepeareShotsSubSequences(char[] shots) {
//        List<Integer> lengthSubsequenceShoppers(List<Character> inputList){
//
//
//            Map<Character, Integer> map1 = new HashMap<>();
//            Map<Character, Integer> map2 = new HashMap<>();
//            List<Integer> result = new ArrayList<>();
//        for(int i = 0; i < inputList.size() ; i++){
//            if(!map1.containsKey(inputList.get(i))) {
//                map1.put(inputList.get(i), i);
//            }
//        }
//
//            for(int i = inputList.size() - 1; i  >= 0 ; i--){
//                if(!map2.containsKey(inputList.get(i))) {
//                    map2.put(inputList.get(i), i);
//                }
//            }
//
//
//            for(int i = 1; i < inputList.size() ; i++){
//               Character c = inputList.get(i);
//               int val1 = map1.get(c);
//               int val2 = map2.get(inputList.get(i - 1));
//
//            }
//
//
//    Map<Character, Time> map = new HashMap<>();
//
//
//
//    // Loop through shots and store all start and end times
//
//        for(int i = 0; i  < inputList.size(); i++) {
//
//        if(map.containsKey(inputList.get(i))) {
//
//            Time time = map.get(inputList.get(i));
//
//            time.end = i;
//
//        } else {
//
//            // end time is same as start time, handles single shot
//
//            map.put(inputList.get(i), new Time(i, i));
//
//        }
//
//    }
//
//
//
//    // Store all the starts and ends
//
//    int[] shotStarts = new int[map.size()];
//
//    int[] shotEnds = new int[map.size()];
//
//    int counter = 0;
//
//
//
//    for(Map.Entry<Character, Time> entry : map.entrySet()) {
//
//        shotStarts[counter] = entry.getValue().start;
//
//        shotEnds[counter] = entry.getValue().end;
//
//        counter++;
//
//    }
//
//
//
//    // sort the start and ends
//
//    Arrays.sort(shotStarts);
//
//    Arrays.sort(shotEnds);
//
//
//
//    List<Integer> result = new ArrayList<>();
//
//
//
//    // match the overlapped times
//
//    // i tracks shotEnds while j tracks shotStarts
//
//    int i = 0, j = 0;
//
//    for( i = 0; i < shotStarts.length; i++) {
//
//        if(shotStarts[i+1] > shotEnds[i]) {
//
//            result.add(i-j);
//
//            j = i +1;
//
//        }
//
//    }
//
//
//
//    // conver list to result array
//
////    int[] resultArray = new int[list.size()];
////
////    resultArray = result.toArray(resultArray);
//
//
//
//    return result;
//
//}
//
//
//
//
//
//class Time {
//
//    int start;
//
//    int end;
//
//    Time(int start, int end) {
//
//        this.start = start;
//
//        this.end = end;
//
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////    List<Integer> lengthSubsequenceShoppers(List<Character> inputList)
////    {
////        Map<Character, Integer> map = new HashMap<>();
////
////        List<String> result = new ArrayList<>();
////        String s = String.valueOf(inputList);
////        if(s==null)
////
////        return null;
////        int n = s.length();
////        int k = n - 1;
////        if( n * k == 0) {
////
////            return 0;
////
////        }
////
////
////
////        int left = 0, right = 0;
////
////
////
////        while(right < n) {
////
////            map.put(s.charAt(right), right++);
////
////
////
////            if(map.size() == k) {
////
////                if(right - left == k + 1) {
////
////                    result.add(s.substring(left,right));
////
////                }
////
////            }
////
////
////
////            if(map.size() > k) {
////
////                int del_idx = Collections.min(map.values());
////
////                map.remove(s.charAt(del_idx));
////
////                left = del_idx + 1;
////
////            }
////
////        }
////
////
////
////        return result;
////
////
////
////
////
////
////
////
////
////
////
////
////
//////       String s = String.valueOf(inputList);
//////        if(s==null)
//////
//////        return null;
//////
//////        List<Integer> result = new ArrayList<>();
//////
//////
//////        int startSeq = 0;
//////
//////        int endSeq = 0;
//////
//////        char[] sArr = s.toCharArray();
//////
//////        while(startSeq<sArr.length){
//////
//////            endSeq=s.lastIndexOf(sArr[startSeq]);
//////
//////            if(startSeq==endSeq){
//////
//////                result.add(1);
//////
//////                startSeq++;
//////
//////            }else{
//////
//////
//////
//////                for(int j=startSeq+1;j<endSeq;j++){
//////
//////                    if(s.lastIndexOf(sArr[j])>endSeq)
//////
//////                        endSeq = s.lastIndexOf(sArr[j]);
//////
//////                }
//////
//////                result.add(endSeq-startSeq+1);
//////
//////                startSeq = endSeq+1;
//////
//////            }
//////
//////
//////
//////        }
//////
//////
//////
////////        Integer[] resultArr =  new Integer[result.size()];
////////
////////        resultArr = result.toArray(resultArr);
//////
//////        return result;
////    }
//}
