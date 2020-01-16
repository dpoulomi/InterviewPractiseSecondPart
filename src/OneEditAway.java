public class OneEditAway {

   public boolean checkingIfOneEditAway(String firstString, String secondString){
        if(Math.abs((firstString.length() - secondString.length())) > 1){
            return false;
        }
        String s1 = firstString.length() > secondString.length() ? firstString : secondString ;
        String  s2 = firstString.length() > secondString.length() ? secondString : firstString ;

        int index1 = 0 ;
        int index2 = 0;
        boolean foundDifference = false;
        while(index1 < firstString.length() && index2 < secondString.length()){
            if(firstString.charAt(index1) != secondString.charAt(index2)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
                if(s1.length() == s2.length()){
                    index1++;
                }
            }
            else {
                index1++;
            }
            index2 ++;
        }
        return true;
    }
}
