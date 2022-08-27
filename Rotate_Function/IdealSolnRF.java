package Rotate_Function;

public class IdealSolnRF {
    /*
    F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1]
    F(k-1) = 0 * Bk-1[0] + 1 * Bk-1[1] + ... + (n-1) * Bk-1[n-1]
        = 0 * Bk[1] + 1 * Bk[2] + ... + (n-2) * Bk[n-1] + (n-1) * Bk[0]

    Then,

    F(k) - F(k-1) = Bk[1] + Bk[2] + ... + Bk[n-1] + (1-n)Bk[0]
                = (Bk[0] + ... + Bk[n-1]) - nBk[0]
                = sum - nBk[0]

    Thus,

    F(k) = F(k-1) + sum - nBk[0]

    What is Bk[0]?

    k = 0; B[0] = A[0];
    k = 1; B[0] = A[len-1];
    k = 2; B[0] = A[len-2];
    ...

     */
    public static int maxRotateFunction(int[] nums) { 
        int allSum = 0;
        int len = nums.length;
        int F = 0;
        for (int i = 0; i < len; i++) {
            F += i * nums[i];
            allSum += nums[i];
        }
        int max = F;
        for (int i = len - 1; i >= 1; i--) {
            F = F + allSum - len * nums[i];
            max = Math.max(F, max);
        }
        return max;   
    }
}
