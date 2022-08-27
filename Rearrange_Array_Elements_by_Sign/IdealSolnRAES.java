package Rearrange_Array_Elements_by_Sign;
import java.util.*;

public class IdealSolnRAES {
    public static void main(String[] args) {
        
    }

    /*
     * In-place but time limit exceeding for the last 4 test cases.

The idea is to process array from left to right. While processing, 
find the first out of place element in the remaining unprocessed array. 
An element is out of place if it is negative and at odd index (0 based index), 
or it is positive and at even index (0 based index) . 
Once we find an out of place element, we find the first element after it with opposite sign. 
We right rotate the subarray between these two elements (including these two).


     */

    public int[] rearrangeArray(int[] nums) {
        int outOfPlace = -1;
        int j = -1;
        for(int i=0; i<nums.length; i++) {
            if(i%2==0 && nums[i]<0) {
                outOfPlace = i;
                j=i+1;
                while(nums[j]<0){j++;}
                reArrange(nums, outOfPlace, j);
            } else if(i%2==1 && nums[i]>0) {
                outOfPlace = i;
                j = i+1;
                while(nums[j]>0) {j++;}
                    reArrange(nums, outOfPlace, j);
            }
        }
        return nums;
    }

    public void reArrange(int[] nums, int outOfPlace, int end) {
        int temp = nums[end];
        for(int i=end; i>outOfPlace; i--) {
            nums[i] = nums[i-1];
        }
        nums[outOfPlace] = temp;
    }
}