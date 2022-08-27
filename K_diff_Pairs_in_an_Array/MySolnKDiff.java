package K_diff_Pairs_in_an_Array;
import java.util.*;

public class MySolnKDiff {
    /*
     * Given an array of integers nums and an integer k,
     *  return the number of unique k-diffs pairs in the array.

A k-diffs pair is an integer pair (nums[i], nums[j]), 
where the following are true:

    0 <= i, j < nums.length
    i != j
    nums[i] - nums[j] == k

Notice that |val| denotes the absolute value of val.
     */
    public static void main(String[] args) {
        
    }

    public int findPairs(int[] nums, int k) {
        int res = 0;
        HashMap<Integer,Integer> diffs = new HashMap<>();
        for (int i : nums) {
            if (diffs.containsKey(i)) {
                if (k == 0 && diffs.get(i) == 1) { // specific case of k = 0
                    res++;
                }
                diffs.put(i, diffs.get(i) + 1);
            } else {
                if (diffs.containsKey(i - k)) {
                    res++;
                }
                if (diffs.containsKey(i + k)) {
                    res++;
                }
                diffs.put(i, 1);
            }
        }

        return res;
    }
}
