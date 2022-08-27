package Shuffle_an_Array;

import java.util.Random;

public class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /*
     *for position 0, we choose a random number nums[i] from nums[0 : n-1], put it to nums[0](
        actually swap it with nums[0] such that we can follow the following rules);
for position 1, we choose a random number nums[i] from nums[1 : n-1], put it to nums[1], (...);
for position 2, we choose a random number nums[i] from nums[2 : n-1], put it to nums[2], (...);
...
and so on.
     */
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
		int[] res = new int[nums.length];
		res = nums.clone();
		
		for(int i = 0; i < nums.length; i++){
			int rand = (int)(Math.random()*(nums.length - i)) + i;
			swap(res, i, rand);
		}
		return res;
	}
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
