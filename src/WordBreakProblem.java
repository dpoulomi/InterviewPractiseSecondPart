public class WordBreakProblem {


    public static void main(String []args)
    {
        // array of strings to be added in dictionary set.
        WordBreakProblem wordBreakProblem = new WordBreakProblem();
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};


        // sample input cases

        System.out.println(wordBreakProblem.findIfWordPresent("ilikesamsungs" , temp_dictionary));
//        System.out.println(wordBreak("iiiiiiii"));
//        System.out.println(wordBreak(""));
//        System.out.println(wordBreak("ilikelikeimangoiii"));
//        System.out.println(wordBreak("samsungandmango"));
//        System.out.println(wordBreak("samsungandmangok"));

    }


    public boolean findIfWordPresent(String word , String[] dictionary){
        int size = word.length();
        if(size == 0){
            return true;
        }
        for(int i = 1 ; i <= word.length() ; i++){
            if( findIfWordPresentInDictionary(word.substring(0 , i) , dictionary) &&
                    findIfWordPresent(word.substring(i , size), dictionary)){
                return true;
            }
        }
        return false;
    }

    private boolean findIfWordPresentInDictionary(String subString , String[] dictionary) {
        for(int i = 0 ; i < dictionary.length ; i++){
            if(subString .equals(dictionary[i])){
                return true;
            }
        }
        return false;
    }
}
