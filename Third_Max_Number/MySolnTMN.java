package Third_Max_Number;
import java.util.*;

public class MySolnTMN {
    public static void main(String[] args) {
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(thirdMax(nums));
    }

    //faster than 67.29%
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Integer.max(nums[0], nums[1]);
        } else {
            Arrays.sort(nums);
            ArrayList<Integer> topThree = new ArrayList<>();
            int storeNum = nums[nums.length-1],j=0;
            topThree.add(storeNum);
            for (int i = nums.length-1; i >= 0 && topThree.size() < 3; i--) {
                if (storeNum != nums[i]) {
                    j++;
                    storeNum = nums[i];
                    topThree.add(storeNum);
                } 
            }

            if (topThree.size() < 3) 
                return topThree.get(0);
            else 
                return topThree.get(j);
        }
    }
}
