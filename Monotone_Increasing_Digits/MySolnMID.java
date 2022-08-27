package Monotone_Increasing_Digits;
import java.util.*;

public class MySolnMID {
    /*
     * An integer has monotone increasing digits if and only 
     * if each pair of adjacent digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or 
equal to n with monotone increasing digits.
     */
    public static void main(String[] args) {
        int n = 10;
        System.out.println(monotoneIncreasingDigits(n));
    }

    public static int monotoneIncreasingDigits(int N) {
        char[] arrN = String.valueOf(N).toCharArray();
        
        int monotoneIncreasingEnd = arrN.length - 1;
        for (int i = arrN.length - 1; i > 0; i--) {
            if (arrN[i] < arrN[i - 1]) {
                monotoneIncreasingEnd = i - 1;
                arrN[i - 1]--;
            }
        }
        // System.out.println("monotoneIncreasingEnd is finalized as : " + monotoneIncreasingEnd);
        // System.out.println("current arrN : " + new String(arrN));
        for (int i = monotoneIncreasingEnd + 1; i < arrN.length; i++) {
            arrN[i] = '9';
        }
        // System.out.println("arrN is finalized as : " + new String(arrN));
        return Integer.parseInt(new String(arrN));
    }
}
