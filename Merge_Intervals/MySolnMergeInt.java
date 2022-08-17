package Merge_Intervals;
import java.util.*;

public class MySolnMergeInt {
    /*
     * Given an array of intervals where intervals[i] = [starti, endi], 
     * merge all overlapping intervals, and return an array of the 
     * non-overlapping intervals that cover all the intervals in the input.

 
     */
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


    //Sorting takes O(n log(n)) and merging the intervals takes O(n). 
    // So, the resulting algorithm takes O(n log(n)).
    // SPACE O(newInt)
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) 
            return intervals;
        
        ArrayList<int[]> newInt = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] first =   intervals[0];
        newInt.add(first);

        
        for (int[] i : intervals) { //itll recheck but thats fine since it wont trigger
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
