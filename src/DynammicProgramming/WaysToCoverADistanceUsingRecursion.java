package DynammicProgramming;

public class WaysToCoverADistanceUsingRecursion {


    public static void main(String[] args) {
        WaysToCoverADistanceUsingRecursion waysToCoverADistance = new WaysToCoverADistanceUsingRecursion();
        System.out.println(waysToCoverADistance.findWays(4));

    }

    public int findWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return findWays(n - 1) + findWays(n - 2) + findWays(n - 3);
    }
}
