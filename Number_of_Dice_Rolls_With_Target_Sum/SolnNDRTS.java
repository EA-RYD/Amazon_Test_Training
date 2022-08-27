package Number_of_Dice_Rolls_With_Target_Sum;
import java.util.*;

public class SolnNDRTS {

    /*
     * You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways 
(out of the kn total ways) to roll the dice so the sum of the face-up numbers 
equals target. Since the answer may be too large, return it modulo 109 + 7.
     */
    public static void main(String[] args) {
        int n = 1;
        int k = 6;
        int target = 3;
        System.out.println(numRollsToTarget(n, k, target));
    }

    // n = dices
    // k = faces
    static int MOD = 1000000000 + 7;
    static Map<String, Integer> memo = new HashMap<>();
    public static int numRollsToTarget(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }
        String str = d + " " + target; // could prob do with int[], wouldnt work with contains tho
        if (memo.containsKey(str)) {
            return memo.get(str);
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + numRollsToTarget(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        memo.put(str, res);
        return res;
    }


    //BOTTOM UP VERSION
    public int numRollsToTargetBot(int n, int k, int target) {
        int MOD = (int)Math.pow(10, 9) + 7;
        long[][] dp = new long[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                for (int l = 1; l <= k; l++) {
                    if (j >= l) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                    } else {
                        break;
                    }
                }
            }
        }
        return (int)dp[n][target];
    }
}
