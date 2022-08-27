package Valid_Perfect_Square;
import java.util.*;

public class MySolnVPS {
    /*
     * Given a positive integer num, write a function 
     * which returns True if num is a perfect square else 
     * False.

Follow up: Do not use any built-in library function 
such as sqrt.
     */
    public static void main(String[] args) {
        int num = 14;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0 && i * i == num) 
                return true;
        }
        return false;
    }
}
