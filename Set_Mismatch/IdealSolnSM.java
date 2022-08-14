package Set_Mismatch;
import java.util.*;

public class IdealSolnSM {
    /*
     * Idea is to compute the sum mathematically first, and subtracting the elements from it.
Find the duplicate element, and add that to sum.
     */
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int duplicate = 0, n = nums.length;
        long sum = (n * (n+1)) / 2;
        for(int i : nums) {
            if(set.contains(i)) duplicate = i;
            sum -= i;
            set.add(i);
        }
        return new int[] {duplicate, (int)sum + duplicate};
    }
}
