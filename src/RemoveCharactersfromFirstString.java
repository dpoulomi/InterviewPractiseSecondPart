public class RemoveCharactersfromFirstString {

    public static void main(String[] args) {
        String s = "GEEKSFORGEEKS";
        String s1 = "GEEKS";
        String  n = remove(s1, s);
        System.out.println(n);
     //   System.out.print(longest);
    }

    private static String remove(String s,String s1) {

        int arr[] = new int[256];
        char arr1[] = new char[s1.length()];

        for(int i = 0;i<s1.length();i++){
            arr[i]=arr[s1.charAt(i)]++;
        }

        for(int i = 0;i <s.length();i++){
            if(arr[s.charAt(i)]>0){
                arr[s.charAt(i)]=0;
            }
        }
        for(int i=0;i<s1.length();i++){
               if(arr[s1.charAt(i)]>0){

               }
        }
        return null;
    }
}
