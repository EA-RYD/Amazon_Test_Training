package Merge_Intervals;
import java.util.*;

public class IdealSolnMergeInt {
    public List<int[]> merge(List<int[]> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i)[0];
            ends[i] = intervals.get(i)[1];
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
