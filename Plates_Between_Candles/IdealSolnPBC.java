package Plates_Between_Candles;
import java.util.*;

public class IdealSolnPBC {
    /*Approach 1: Binary Search

We remember the position of each candle. 
Then, we binary-search for the leftmost (first) and rightmost (last) candle for each query.

Now, we know how many total items are between the first and last candle, and how many candles are there.

The time complexity of this solution is O(n log m), where n is the number of queries, and m - the length 
of the string. */



/*Approach 2: Prefix Sum

We can count candles between two positions in O(1) using a prefix sum array dp. Before we can do that, 
we need to find the leftmost (first) and rightmost (last) candle for each query.

We can also do it in O(1) by tracking next and prev candle for each position on the table.

The time complexity of this solution is O(n + m), where n is the number of queries, and m - the
 length of the string. */

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int psum[] = new int[s.length() + 1];
        int next[] = new int[s.length() + 1], prev[] = new int[s.length() + 1];
        Arrays.fill(next, Integer.MAX_VALUE);
        int res[] = new int[queries.length];
        for (int i = 0; i < s.length(); ++i) {
            psum[i + 1] = psum[i] + (s.charAt(i) == '|' ? 1 : 0);
            prev[i + 1] = s.charAt(i) == '|' ? i : prev[i];
        }
        for (int i = s.length() - 1; i >= 0; --i)
            next[i] = s.charAt(i) == '|' ? i : next[i + 1];
        for (int j = 0; j < queries.length; ++j) {
            int l = next[queries[j][0]], r = prev[queries[j][1] + 1];
            res[j] = l < r ? r - l - (psum[r] - psum[l]) : 0;
        }        
        return res;
    }


    //Approach 3: Prefix Sum with tree
    public int[] splatesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        TreeMap<Integer, Integer> map = new TreeMap<>(); // <index, presum>
    
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') sum++;
            else map.put(i, sum);
        }
    
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0], end = queries[i][1];
            Integer left = map.ceilingKey(start);
            Integer right = map.floorKey(end);
            if (left != null && right != null && left < right) {
                res[i] = map.get(right) - map.get(left);
            }
        }
        return res;
    }

}
