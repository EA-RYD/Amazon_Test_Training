package Permutations;
import java.util.*;

public class MySolnPM {
    /*
     * Given an array nums of distinct integers,
     *  return all the possible permutations. 
     * You can return the answer in any order.
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println();
        for (List<Integer> p : permute(nums)) {
            for (int i : p) {
                System.out.print(i + " ");
            }
            System.out.println();  
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursion(nums, res, new ArrayList<>());
        return res;
    }

    private static void recursion(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temp.contains(nums[i])) // never repeat digits, know nums is distinct
                    continue;
                temp.add(nums[i]);
                recursion(nums, res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
}
