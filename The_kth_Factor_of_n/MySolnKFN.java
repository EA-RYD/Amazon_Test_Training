package The_kth_Factor_of_n;
import java.util.*;

public class MySolnKFN {
    /*
     * You are given two positive integers n and k. 
     * A factor of an integer n is defined as an integer i where n % i == 0.

Consider a list of all factors of n sorted in ascending order, 
return the kth factor in this list or return -1 if n has less than k factors.
     */
    public static void main(String[] args) {
        int n = 4;
        int k = 4;
        System.out.println(kthFactor(n, k));
    }
    // 90.37%,79%
    // O(n) O(1)
    public static int kthFactor(int n, int k) {
        int factor = 0;
        for (int i = 1; i <= n && k != 0; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0)
                    factor = i;
            }
        }
        return k != 0 ? -1 : factor;
    }
}
