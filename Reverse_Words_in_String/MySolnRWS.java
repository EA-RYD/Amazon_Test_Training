package Reverse_Words_in_String;
import java.util.*;

public class MySolnRWS {
    /*
     * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in 
s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces 
between two words. The returned string should only have a single space
separating the words. Do not include any extra spaces.
     */
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    // efficiency of this is O(n + sArr.length) so just O(n)
    // space is O(n)
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] sArr = s.trim().split(" +");
        for (int i = sArr.length-1; i >= 0; i--) 
            if (i != 0)
                res.append(sArr[i] + " ");
            else
                 res.append(sArr[i]);
        
        return res.toString();
    }
}
