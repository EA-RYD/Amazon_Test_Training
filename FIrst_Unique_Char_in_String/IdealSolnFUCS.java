package FIrst_Unique_Char_in_String;

public class IdealSolnFUCS {
    public class Solution {
        public int firstUniqChar(String s) {
            int freq [] = new int[26];
            for(int i = 0; i < s.length(); i ++)
                freq [s.charAt(i) - 'a'] ++;
            for(int i = 0; i < s.length(); i ++)
                if(freq [s.charAt(i) - 'a'] == 1)
                    return i;
            return -1;
        }
    }
}
