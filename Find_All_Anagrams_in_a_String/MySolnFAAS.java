package Find_All_Anagrams_in_a_String;
import java.util.*;

public class MySolnFAAS {
    /*
     * Given two strings s and p, 
     * return an array of all the start indices of p's anagrams in s. 
     * You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the 
letters of a different word or phrase, typically using all 
the original letters exactly once.
     */
    public static void main(String[] args) {
        
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indice = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (p.contains(String.valueOf(s.charAt(i)))) {
                
            }
        }
        
        return indice;
    }
}
