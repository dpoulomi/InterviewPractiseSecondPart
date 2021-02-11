//package Array;
//
//public class NumberOfOccurencesOfAnElement {
//
//
//    public static void main(String[] args) {
//        int array[] = {1, 2, 3, 3, 3, 3, 4, 5};
//        int start = 0;
//        int end = array.length;
//        int mid = array.length / 2;
//        int element = 3;
//        int occurences = findNumberOfOccurences(array, element, start, mid, end);
//
//    }
//
//    private static int findNumberOfOccurences(int[] array, int ele, int start, int mid, int end) {
//        mid = array.length / 2;
//        for (int i = 0; i < array.length; i++) {
//            if (array[mid] == ele) {
//                findNumberOfOccurences();
//            } else if (array[mid] > ele) {
//                findNumberOfOccurences(array, ele, 0, mid, mid - 1);
//            } else {
//                findNumberOfOccurences(array, ele, mid, mid, end);
//            }
//        }
//    }
//}
