package Range_Addition;
import java.util.*;

public class MySolnRA {
    /*
     * Assume you have an array of length n initialized with all 0’s and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of 
subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.
     */
    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1,  3,  2},
            {2,  4,  3},
            {0,  2, -2}};
        for (int i : getModifiedArray(length, updates)) 
            System.out.print(i + " ");
        System.out.println();
    }

    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] op : updates) {
            for (int i=op[0];i<=op[1];i++) {
                res[i] += op[2];
            }
        }   
        return res;
    }
}
