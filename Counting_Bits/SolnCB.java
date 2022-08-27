package Counting_Bits;

public class SolnCB {
    /*
     * Given an integer n, return an array ans of length n + 1 
     * such that for each i (0 <= i <= n), ans[i] is the number of 1's 
     * in the binary representation of i.
     */
    public static void main(String[] args) {
        
    }

    public int[] countBits(int num) {

        if(num == 0) return new int[1];
        
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < num + 1; i++){
            if(i % 2 == 0)
                dp[i] = dp[i/2];
            else
                dp[i] = dp[i/2] + 1;
        }

        return dp;
    }
}
