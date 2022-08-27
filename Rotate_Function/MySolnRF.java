package Rotate_Function;

public class MySolnRF {
    /*
     * You are given an integer array nums of length n.

Assume arrk to be an array obtained by rotating nums by k positions clock-wise. 
We define the rotation function F on nums as follow:

    F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].

Return the maximum value of F(0), F(1), ..., F(n-1).

The test cases are generated so that the answer fits in a 32-bit integer.
     */
    public static void main(String[] args) {
        int[] nums = {100};
        System.out.println(maxRotateFunction(nums));
    }

    // k is length of nums
    // works but really ineff
    public static int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE, start = 0, k = nums.length;
        for (int i = 0; i < k; i++) {
            int tempMax = 0, times = 0;
            for (int j = start; j < k + start; j++,times++) {
                if (j < k) { // within array
                    tempMax+=nums[j] * times;
                } else { // outside array
                    tempMax+=nums[j - k] * times;
                }
            }
            max = (tempMax > max) ? tempMax : max;
            start++;
        }

        return max;
    }
}
