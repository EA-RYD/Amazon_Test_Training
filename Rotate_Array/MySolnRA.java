package Rotate_Array;
import java.util.*;
import java.util.stream.Collectors;

public class MySolnRA {
    /*
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);
        System.out.println();
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // there are only nums.length possible orientations so no need to do until k
    // if divisible by nums.length then no change

    // cut out k entries from end and put at start
    // two pointers, one k ahead and one at start
    // stop once j == 0 + k - 1
    // [1,2,3,4,5,6,7]

    // faster than 49.68%
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] newNums = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            if (i + k <= nums.length-1)
                nums[i+k] = newNums[i];
            else 
                nums[i+k - nums.length] = newNums[i];
        }
    }
}
