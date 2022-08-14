package Merge_Intervals;
import java.util.*;

public class MySolnMergeInt {
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

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) 
            return intervals;
        
        ArrayList<int[]> newInt = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] first =   intervals[0];
        newInt.add(first);

        
        for (int[] i : intervals) {
            int[] temp = i;
            if (first[1] >= temp[0]) {
                first[1] = Math.max(temp[1], first[1]);//changes values in newInt
            } else {
                first = temp;
                newInt.add(first);
            }
        }

        return newInt.toArray(new int[newInt.size()][]);
    }
}
