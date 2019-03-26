public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int inputNumber = 10;
        int[] factors ={2, 3, 5};
        uglyNumber.checkIfUglyNumber(inputNumber , factors);
    }

    private void checkIfUglyNumber(int inputNumber, int[] factors) {
        for(int i = 0 ; i < factors.length; i++) {
            while (inputNumber % factors[i] == 0){
               inputNumber= inputNumber/factors[i];
            }
        }
        boolean isUgly = inputNumber == 1 ? true : false;
        System.out.println(isUgly);
    }
}
