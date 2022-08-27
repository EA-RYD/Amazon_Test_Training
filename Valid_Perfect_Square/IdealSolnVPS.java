package Valid_Perfect_Square;

public class IdealSolnVPS {
    /*
     * A few ideal soln:
     * binary search
     * newton method
     * math derive
     */

    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1; //prev overflow (same as low + high / 2)
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num, int t) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
