import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams {

    public static void main(String[] args) {

    }

    public void groupAnagrams(){
        String[] arr = {"google", "gglere", "ggoole" , "larsen" , "cup" , "nesral"};

     //   Arrays.sort(arr , new AnagramComparator());
        addToHashMap(arr);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]);
        }

    }

    private void addToHashMap(String[] arr) {

    }

    class AnagramComparator implements Comparator<String>{


        @Override
        public int compare(String o1, String o2) {
           return sortString(o1).compareTo(sortString(o2));
        }

        private String sortString(String o1) {
            char[] arr = o1.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);

        }
    }
}
