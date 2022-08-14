package Find_Pivot_Index;
import java.util.*;

public class MySolnPI {
    /*
     * Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the 
index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no 
elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
     */
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int rightSum = Arrays.stream(nums).reduce(0, (a,b) -> a + b) -  nums[0];
        int leftSum = 0;
        for (int i=0;i<nums.length;i++) {
            if (leftSum == rightSum)
                return i;
            leftSum+=nums[i];
            if (i!=nums.length-1) 
                rightSum-=nums[i+1];
            else 
                rightSum = 0;
        }

        return -1;
    }
}
