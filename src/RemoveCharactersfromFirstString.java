public class RemoveCharactersfromFirstString {

    public static void main(String[] args) {
        String firstStringToReplace = "GEEKSFORGEEKS";
        String secondString = "MASK";
        String  replacedString = remove( firstStringToReplace , secondString);
        System.out.println(replacedString);
    }

    private static String remove(String firstStringToReplace,String secondString) {
        String replacedString= "";

        int countArray[] = new int[256];

        for(int i = 0;i < secondString.length();i++){
            countArray[i] = countArray[secondString.charAt(i)]++;
        }

        for(int i = 0;i < firstStringToReplace.length();i++){
               if(countArray[firstStringToReplace.charAt(i)]==0){
                   replacedString =  replacedString + firstStringToReplace.charAt(i);
               }
        }
        return replacedString;
    }
}
