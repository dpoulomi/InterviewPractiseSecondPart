public class ReverseWordsInASentence {

    public static void main(String[] args) {
        String sentence = "I am a student.";
        ReverseWordsInASentence reverseWordsInASentence = new ReverseWordsInASentence();
        reverseWordsInASentence.reverseWords(sentence);

    }
    //.tneduts a ma I
    //output should be "student. a am I"
    private void reverseWords(String sentence) {
       int start= 0 ;
       int end = sentence.length();
       char[] sentenceArray = sentence.toCharArray();

        String[] splitSentenceArray = sentence.split(" ");
        String reversedString = "";
        for(int i = 0 ; i < splitSentenceArray.length; i++){
           reversedString = reversedString + " " + swapEachCharacter(splitSentenceArray[i].toCharArray(), 0 , splitSentenceArray[i].length()-1);

        }

       sentence = swapEachCharacter(reversedString.toCharArray(), start, end);

        System.out.println(sentence);
    }

    private String swapEachCharacter(char[] sentenceArray , int start , int end) {
        while(start < end){
            char temp = sentenceArray[start];
            sentenceArray[start] = sentenceArray[end];
            sentenceArray[end] = temp;
            start++;
            end--;
        }
        String reversedString = String.valueOf(sentenceArray);
        return reversedString;
    }
}
