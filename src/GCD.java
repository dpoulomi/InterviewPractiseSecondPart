public class GCD {


    public int generalizedGCD(int num, int[] arr)
    {

        int result = arr[0];
        for (int i = 1; i < num; i++)
            result = gcd(arr[i], result);

        return result;
    }

//    static int findGCD(int arr[], int n)
//    {
//        int result = arr[0];
//        for (int i = 1; i < n; i++)
//            result = gcd(arr[i], result);
//
//        return result;
//    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
