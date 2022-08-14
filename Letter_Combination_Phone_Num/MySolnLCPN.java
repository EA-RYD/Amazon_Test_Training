package Letter_Combination_Phone_Num;

import java.util.*;
public class MySolnLCPN {
    /*
     * Given a string containing digits from 2-9 inclusive, 
     * return all possible letter combinations that the number could represent. 
     * Return the answer in any order.

        A mapping of digits to letters (just like on the telephone buttons) is given below. 
        Note that 1 does not map to any letters.
     */
    public static void main(String[] args) {
        String digits = "23";
        for (String s: letterCombinations(digits)) {
            System.out.println(s);
        }
    }
    
    
    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {return new ArrayList<>();}
        String[] dictionary = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();

        findCombination("",result, digits, 0, dictionary);
        return result;
    }

    private static void findCombination(String temp, List<String> strings, String digits, int start,String[] dict) {
        if (start >= digits.length()) {
            strings.add(temp);
            return;
        } else {
            String letters = dict[(digits.charAt(start) - '0')];
            for (int i = 0; i < letters.length(); i++) {
                findCombination(temp + letters.charAt(i), strings, digits, start + 1, dict);
            }
        }
        
    }
}