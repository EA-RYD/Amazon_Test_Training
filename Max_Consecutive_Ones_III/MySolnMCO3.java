package Max_Consecutive_Ones_III;
import java.util.*;
public class MySolnMCO3 {
    /*
     * Given a binary array nums and an integer k, 
     * return the maximum number of consecutive 1's in
     *  the array if you can flip at most k 0's.
     */
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k = 8;
        System.out.println(longestOnes(nums, k));
    }

    //test cases passed but took too long
    // look at windows that contain k zeros, save index of zeros and 
    // shift to them once you take one length
    public static int longestOnes(int[] nums, int k) {
        int max = 0;
        int previousZeroTotal = 0;
        Queue<Integer> zeroIndice = new ArrayDeque<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0 && zeroIndice.size()!= k) {
                zeroIndice.offer(i);
                if (i != 0)
                    nums[i] = nums[i-1] + 1;
                else  
                    nums[i] = 1;
            } else if (nums[i] == 0 && k!=0) {
                int temptotal = nums[zeroIndice.poll()];
                nums[i] = nums[i-1] + 1 - temptotal;
                nums[zeroIndice.peek()] = nums[zeroIndice.peek()] - previousZeroTotal;
                zeroIndice.offer(i);
            } else if (i!=0 && nums[i] == 1) {
                nums[i] = nums[i-1] + nums[i];
            }
            max = (max < nums[i]) ? nums[i] : max;
        }
        return max;
    }
}
