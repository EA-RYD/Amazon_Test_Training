package Combination_Sum;
import java.util.*;
import java.util.stream.Collectors;

public class MySolnCS {
    /*
     * Given an array of distinct integers candidates and a target integer target, 
     * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
     * You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target 
is less than 150 combinations for the given input.
     */
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        
        for (List<Integer> i : combinationSum(candidates, target)) {
            for (Integer integer : i) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    } 

    //to stop repetitions maybe convert nums to char and add together and check??
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> res = new HashSet<>();
        recursion(candidates, target, res, new ArrayList<>());
        return res.stream().collect(Collectors.toList());
    }

    private static void recursion(int[] candidates, int target, HashSet<List<Integer>> res, List<Integer> temp) {
        if (target < 0) 
            return;
        else if (target == 0) {
            List<Integer> addTemp = new ArrayList<>(temp);
            addTemp.sort(Comparator.naturalOrder());
            res.add(addTemp);
        } else {
            if (target == 2)
                System.out.println();
            for (int i=0;i<candidates.length;i++) {
                temp.add(candidates[i]);
                recursion(candidates, target-candidates[i], res, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
