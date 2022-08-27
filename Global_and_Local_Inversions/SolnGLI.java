package Global_and_Local_Inversions;
import java.util.*;

public class SolnGLI {

    /*
     * You are given an integer array nums of length n which represents a 
     * permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

    0 <= i < j < n
    nums[i] > nums[j]

The number of local inversions is the number of indices i where:

    0 <= i < n - 1
    nums[i] > nums[i + 1]

Return true if the number of global inversions is equal to the number of local 
inversions.
     * 
     * 
     */
    public static void main(String[] args) {
        
    }

    /*
    Explanation

    All local inversions are global inversions.
    If the number of global inversions is equal to the number of local inversions,
    it means that all global inversions in permutations are local inversions.
    It also means that we can not find nums[i] > nums[j] with i+2<=j.
    In other words, max(nums[i]) < nums[i+2]

    In this first solution, I traverse nums and keep the current biggest number cmax.
    Then I check the condition cmax < nums[i+2]
     */

     //intuitive
    public boolean isIdealPermutation(int[] A, int p) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] < A[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    //optimized
    public boolean isIdealPermutation(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (Math.abs(i - A[i]) > 1)
                return false;
        }

        return true;
    }
}
