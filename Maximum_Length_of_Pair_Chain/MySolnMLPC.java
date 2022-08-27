package Maximum_Length_of_Pair_Chain;
import java.util.*;

public class MySolnMLPC {
    /*
     You are given an array of n pairs pairs where 
     pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. 
A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can 
select pairs in any order.

     */
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }

    //O(nlog(n)) Time O(1) Space
    //sort the array by finishing time, choose the first one, 
    //discard all those that conflict, and continue this process until the end.
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x,y) -> Integer.compare(x[1], y[1]));
        int count = 0, i = 0, n = pairs.length;
        while (i < n) {
            count++;
            int curEnd = pairs[i][1];
            while (i < n && pairs[i][0] <= curEnd) i++;
        }
        return count;
    }
}
