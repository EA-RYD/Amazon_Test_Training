package Set_Mismatch;
import java.util.*;

public class MySolnSM {
    /*
     * You have a set of integers s, which originally contains all the numbers from 1 to n.
     *  Unfortunately, due to some error, one of the numbers in s got duplicated to another 
     * number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.


     */

    public static void main(String[] args) {
        int[] nums = {3,3,1};
        for (int i : findErrorNums(nums))
            System.out.print(i + " ");
        System.out.println();
    }

    public static int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[2]; //0  is repeat, 1 is missing
        HashSet<Integer> check = new HashSet<>();

        for (int i=0;i<nums.length;i++) {
            if (nums[0] != 1 && ans[1] == 0)
                ans[1] = 1;
            else if (i > 0 && nums[i] != nums[i-1] + 1)
                if (!check.add(nums[i]))
                    ans[0] = nums[i];
                else if (ans[1] == 0)
                    ans[1] = (nums[i] + nums[i-1]) / 2;
            if (ans[0] != 0 && ans[1] != 0) break;
            check.add(nums[i]);
        }

        if (ans[1] == 0)
            ans[1] = nums[nums.length-1] + 1;

        return ans;
    }
}
