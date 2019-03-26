public class LeftRotationInAString {
    public static void main(String[] args) {
        String beforeRotation = "abcdefg";
        LeftRotationInAString leftRotationInAString = new LeftRotationInAString();
        int noOfRotations = 2;
        leftRotationInAString.rotateString(beforeRotation , noOfRotations);
    }
    //after rotation the string will become “cdefgab”
    //bagfedc
    //cdefgab
    private void rotateString(String beforeRotation , int noOfRotations) {
        int start = 0;
        int end = noOfRotations-1;
        char[] beforeStringArray = beforeRotation.toCharArray();
        String rotatedArray = swapAlphabets(beforeStringArray , start , end);
        rotatedArray = swapAlphabets(rotatedArray.toCharArray() , noOfRotations, beforeRotation.length()-1);
        beforeRotation = swapAlphabets(rotatedArray.toCharArray() , 0 , beforeRotation.length()-1);

        System.out.println(beforeRotation);

    }

    private String swapAlphabets(char[] beforeStringArray , int start , int end) {
        while (start < end) {
            char temp = beforeStringArray[start];
            beforeStringArray[start] = beforeStringArray[end];
            beforeStringArray[end] = temp;
            start++;
            end--;
        }
        String reversedArray = String.valueOf(beforeStringArray);
        return reversedArray;
    }
}
