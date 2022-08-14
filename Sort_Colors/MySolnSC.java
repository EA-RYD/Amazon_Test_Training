package Sort_Colors;
import java.util.*;

public class MySolnSC {
    /*
     * Given an array nums with n objects colored red, white, or blue, 
     * sort them in-place so that objects of the same color are adjacent, 
     * with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, 
and blue, respectively.

You must solve this problem without using the library's sort function.

two pass is standard, one pass harder
     */
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    //100.00% time, 57 mem
    public static void sortColors(int[] nums) {
        int[] numCount = new int[3];
        for (int i : nums) 
            numCount[i]++;

            
        int i = 0;
        for(;i < numCount[0];i++) {
            nums[i] = 0;
        }
        for(;i < numCount[1] + numCount[0];i++) {
            nums[i] = 1;
        }
        for(;i < numCount[2] + numCount[1] + numCount[0];i++) {
            nums[i] = 2;
        }
        
    }
}
