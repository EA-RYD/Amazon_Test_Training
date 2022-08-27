package Perfect_Squares;
import java.util.*;

public class MySolnPS {
    /*
     * Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, 
it is the product of some integer with itself. 
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     */
    public static void main(String[] args) {
        int n  = 13;
        System.out.println(numSquares(n));
    }
// same as coin change prob
    public static int numSquares(int n) {
        int num = 0;
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            if (isPSquare(i)) {
                nums.add(i);
            }
        }

        num = recurse(nums, n, new HashMap<>());
        return num;
    }

    private static boolean isPSquare(int n) {
        double sqrt = Math.round(Math.sqrt(n));
        return (sqrt * sqrt == n);
    }

    private static int recurse(ArrayList<Integer> nums, int n,HashMap<Integer,Integer> temp) {
        if (n < 0 ) {
            return -1;   
        } else if (n == 0) {
            return 0;
        } else if (temp.containsKey(n)) {
            return temp.get(n);
        } else {
            int min = Integer.MAX_VALUE;
            for (Integer integer : nums) {
                int res = recurse(nums, n - integer, temp);
                if (res != -1) {
                    min = Math.min(min, res + 1);
                }
            }
            temp.putIfAbsent(n, (min == Integer.MAX_VALUE) ? -1 : min);
            return temp.get(n);
        }
    }
}
