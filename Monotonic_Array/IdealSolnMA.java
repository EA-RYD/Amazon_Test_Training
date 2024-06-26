package Monotonic_Array;

public class IdealSolnMA {
    //We check if A is increasing and decreasing.
    public boolean isMonotonic(int[] A) {
        boolean increase = false;
        boolean decrease = false;
        
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                decrease = true;
            }
            if (A[i] > A[i - 1]) {
                increase = true;
            }
        }
        
        return increase && decrease ? false : true;
    }
}
