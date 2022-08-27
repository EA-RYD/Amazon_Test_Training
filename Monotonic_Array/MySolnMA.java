package Monotonic_Array;
import java.util.*;

public class MySolnMA {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        int before = -1;
        boolean increaseDecrease = (nums[0] < nums[nums.length-1]); //decrease = false, increase = true
        if (increaseDecrease) {
            before = Integer.MIN_VALUE;
            for (int i : nums) {
                if (i < before) {
                    return false;
                }
                before = i;
            }
        } else {
            before = Integer.MAX_VALUE;
            for (int i : nums) {
                if (i > before) {
                    return false;
                }
                before = i;
            }
        }

        return true;
    }
}
