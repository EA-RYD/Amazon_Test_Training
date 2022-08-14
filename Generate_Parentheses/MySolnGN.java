package Generate_Parentheses;
import java.util.*;

public class MySolnGN {

    /*
     * 
     * Given n pairs of parentheses, 
     * write a function to generate all combinations of 
     * well-formed parentheses.
     */
    public static void main(String[] args) {
        int n  = 8;
        for (String s: generateParenthesis(n)) {
            System.out.println(s);
        }
    }

    //dp or recursion
    //at choice break points save and  re use
    // number of partheses on right has to be less than left to be able to insert
    
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        iterator(1, 0, ans, n,"", '(');
        return ans;
    }

    // slow but works
    private static void iterator(int lCount,int rCount,List<String> strings,int n,String temp, char c) {
        temp += c;
        if (lCount == n && rCount == n) {
            strings.add(temp);
        } else {
            if (lCount == rCount && lCount != n) {
                iterator(lCount + 1, rCount, strings, n, temp, '(');
                temp.substring(0,temp.length()-1);
            } else if (lCount == n) {
                iterator(lCount, rCount + 1, strings, n, temp, ')');
                temp.substring(0,temp.length()-1);
            } else {
                iterator(lCount, rCount + 1, strings, n, temp, ')');
                temp.substring(0,temp.length()-1);
                
                iterator(lCount + 1, rCount, strings, n, temp, '(');
                temp.substring(0,temp.length()-1);
            }
        }
    }
}
