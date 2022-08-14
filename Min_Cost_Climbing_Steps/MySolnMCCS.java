package Min_Cost_Climbing_Steps;
import java.util.*;

public class MySolnMCCS {
    public static void main(String[] args) {
        //int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};

        System.out.println(minCostClimbingStairs(cost));
    }

    /*
     * You are given an integer array cost where cost[i] is the cost of 
     * ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
     */

     //BETTER THAN 90% for both!!
     // Dynamic programming memoization
    public static int minCostClimbingStairs(int[] cost) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0;i < cost.length;i++) {
            if (i == 0 || i == 1) 
                dp.add(cost[i]);
            else {
                int pos1 = dp.get(i - 2) + cost[i];
                int pos2 = dp.get(i - 1) + cost[i]; 
                dp.add((pos1 < pos2) ? pos1 : pos2);
            }       
        }
        return (dp.get(dp.size()-1) < dp.get(dp.size()-2)) ? dp.get(dp.size()-1) : dp.get(dp.size()-2);
    }

    
}
