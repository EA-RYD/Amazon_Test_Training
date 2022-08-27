package Word_Break;
import java.util.*;

public class SolnWB {
    /*
     * Given a string s and a dictionary of strings wordDict, return true if s can be 
     * segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
     */
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        System.out.println(wordBreak(s, wordDict));
    }

    // O([length of s]^3)
    public static boolean wordBreak(String s, List<String> wordDict) {
        wordDict.stream().filter(str -> str.length() <= s.length());
        wordDict.sort((x,y) -> Integer.compare(x.length(), y.length()));

        return stringCheck(s, wordDict);
    }

    private static boolean stringCheck(String word, List<String> dict) {
        if (dict.isEmpty()) return false;

        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break; // found conc word
                }
            }
        }
        return dp[word.length()];
    }
}
