package Kth_Largest_Ele_in_Array;
import java.util.*;

public class MySolnKLEA {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--,k--) {
            if (k==1) 
                return nums[i];
        }

        return 0;
    }
}
