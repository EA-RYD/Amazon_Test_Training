package Happy_Number;

import java.util.*;

public class MySolnHN {
    /*
     * A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.

    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a 
    cycle which does not include 1.

    Those numbers for which this process ends in 1 are happy.

    Return true if n is a happy number, and false if not.

     */
    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }

    // 47%
    public static boolean isHappy(int n) {
        ArrayList<Integer> cycleCheck = new ArrayList<>();
        cycleCheck.add(n);
        int total = n;
        while (total != 1) {
            int temp = 0;
            for (char d : String.valueOf(total).toCharArray()) {
                temp += (Integer.valueOf(d - '0') * Integer.valueOf(d - '0'));
            }
            
            total = temp;
            if (cycleCheck.contains(total)) //loop detected
                return false;
             else 
                cycleCheck.add(total);
        }

        return true;
    }
}
