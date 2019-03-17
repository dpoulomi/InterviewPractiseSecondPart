import java.util.HashMap;
import java.util.Map;

public class LongestSubstringOptimum {

    public static void main(String[] args) {

        LongestSubstringOptimum longestSubstringOptimum = new LongestSubstringOptimum();
        String sampleString = "ABDEFGABEF"; // "GEEKSFORGEEKS"; //
        int longestSubStringLength = longestSubstringOptimum.checkForLongestSubstring(sampleString);
        System.out.println(longestSubStringLength);
    }

    private int checkForLongestSubstring(String sampleString) {

        if (sampleString == null) {
            return 0;
        }

        if (sampleString.length() < 2) {
            return sampleString.length();
        }

        Map<Character, Integer> charIndexMap = new HashMap();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < sampleString.length(); i++) {

            final char currentChar = sampleString.charAt(i);
            if (charIndexMap.containsKey(currentChar)) {
                int index = charIndexMap.get(currentChar);
                if(index >= start) {
                    start = index + 1;
                }
                charIndexMap.put(currentChar, i);
            } else {
                charIndexMap.put(currentChar, i);
            }
            int lengthOfCurrentMax = (i - start) + 1;

            if (maxLength < lengthOfCurrentMax) {
                maxLength = lengthOfCurrentMax;

            }
        }


        return maxLength;
    }

//    private int checkForLongestSubstring(String sampleString) {
//        if (sampleString == null) {
//            return 0;
//        }
//
//        if(sampleString.length() < 2) {
//            return sampleString.length();
//        }
//
//        Map<Character, Integer> charIndexMap = new HashMap();
//        int maxLength = 0;
//
//        for (int i = 0; i < sampleString.length(); i++) {
//            if (charIndexMap.containsKey(sampleString.charAt(i))) {
//
//                charIndexMap.clear();
//            } else {
//                charIndexMap.put(sampleString.charAt(i), i);
//            }
//            if (maxLength < charIndexMap.size()) {
//                maxLength = charIndexMap.size();
//            }
//        }
//
//        return maxLength;
//    }
}
