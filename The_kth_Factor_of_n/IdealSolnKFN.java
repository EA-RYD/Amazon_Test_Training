package The_kth_Factor_of_n;
import java.util.*;

public class IdealSolnKFN {
    //O(sqrt n) time, O(1) space,
    // If i is a divisor of n, 
    //then n / i is a divisor of n as well.
    // Consequently, we can find all the divisors of n 
    //only by processing the numbers that are smaller or equal 
    //to the square root of n.
    /*
     * Let's divide all the divisors of n into 2 parts:

    divisors smaller than the square root of n
    divisors bigger than the square root of n.

Note: There's an edge case when the 
square root of n is an integer 
(for example when n is 9 or 16) which we'll discuss later.
     */

    
    public static int kthFactor(int n, int k) {
        for(int i = 1; i < Math.sqrt(n); ++i) //check left of n sqrt
            if(n % i== 0 && --k == 0) 
                return i;                       
        for(int i = (int) Math.sqrt(n); i >= 1; --i) //check right of n sqrt
            if(n % (n/i) == 0 && --k == 0) 
                return n/i;          
        return -1;
    }
}
