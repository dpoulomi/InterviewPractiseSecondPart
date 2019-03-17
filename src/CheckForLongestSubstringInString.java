public class CheckForLongestSubstringInString {

    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        int n = checkForLongestSubstring(s);
        System.out.println(n);
        System.out.print(longest);
    }
    private static String longest="";
    private static int checkForLongestSubstring(String s) {
        int start = 0;
        int end=2;
        int maxLength = 0;

       // for( end ;end< s.length();end++){
        while(end<=s.length()){
            String substr= s.substring(start,end);
            boolean flag =checkForLongestSubstringInString(substr);
            if(end-start>maxLength){
                maxLength= end- start;
                longest= s.substring(start,end-1);
            }
            if (!flag) {
                start ++;
            }else{
                end++;
            }

        }

        return maxLength-1;
    }

    private static boolean checkForLongestSubstringInString(String s) {
        for(int j = 0;j<s.length();j++){
            for(int i =j+1;i<s.length();i++){
                if(s.charAt(i)==s.charAt(j)){
                   return false;

                }

            }


        }
            return true;
    }
}
