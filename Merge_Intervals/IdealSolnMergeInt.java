package Merge_Intervals;
import java.util.*;

public class IdealSolnMergeInt {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        //int[][] intervals = {{1,4},{5,6}};
        for (int[] is : merge(intervals)) {
            System.out.println();
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
        }
        System.out.println(); 
    }
    // O(n) eff since sorting takes O(logn) since we dont have to be checking multiple indice
    public static List<int[]> merge(int[][] intervals) {
        // sort start&end
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<int[]> res = new ArrayList<int[]>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                int[] temp = {starts[j],ends[i]};
                res.add(temp);
                j = i + 1;
            }
        }
        return res;
    }
}
