package Two_Sum_Unique_Pairs;
import java.util.*;

public class MySolnTSUP {
    /*
     * Given an int array nums and an int target, 
     * find how many unique pairs in the array such that their sum is equal 
     * to target. Return the number of pairs
     */
    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 5};
        int target = 6;
        System.out.println(numUniquePairs(target, nums));
    }

    public static int numUniquePairs(int target, int[] nums) {
        HashSet<List<Integer>> sets = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                List<Integer> temp = Arrays.asList(map.get(i),i);
                temp.sort(Comparator.naturalOrder());
                sets.add(temp);
            } else {
                map.put(target - i, i);
            }
        }

        return sets.size();
    }
}
