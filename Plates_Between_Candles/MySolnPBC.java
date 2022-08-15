package Plates_Between_Candles;
import java.util.*;

public class MySolnPBC {
    /*
     * There is a long table with a line of plates and candles arranged on top of it. 
     * You are given a 0-indexed string s consisting of characters '*' and '|' only, where 
     * a '*' represents a plate and a '|' represents a candle.

You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] 
denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the 
number of plates between candles that are in the substring. A plate is considered between 
candles if there is at least one candle to its left and at least one candle to its right in the substring.

    For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The 
    number of plates between candles in this substring is 2, as each of the two plates has 
    at least one candle in the substring to its left and right.

Return an integer array answer where answer[i] is the answer to the ith query.
     */
    public static void main(String[] args) {
        int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
        String s = "***|**|*****|**||**|*";
        for (int is : platesBetweenCandles(s, queries)) {
            System.out.print(is + " ");
        }
        System.out.println();
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int q=0;q<queries.length;q++) {
            int totalCount = 0;
            for (int i = queries[q][0],j=i; i < queries[q][1];) {
                int tempCount = 0;
                if (s.charAt(i) == '|') {
                    j = i+1;
                    while(j<=queries[q][1] && s.charAt(j) != '|') {
                        tempCount++;
                        j++;
                    }
                    if (j>queries[q][1]) {
                        break;
                    } else {
                        i = j;
                        totalCount += tempCount;
                    }
                } else {
                    i++;
                }      
            }
            ans[q] = totalCount;
        }
        return ans;
    }
}
