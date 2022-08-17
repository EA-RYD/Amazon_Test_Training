package FIrst_Unique_Char_in_String;

public class IdealSolnFUCS {
    
        public static void main(String[] args) {
            String  s = "leetcode";
            System.out.println(firstUniqChar(s));
        }

        // O(n) O(alphabet size)
        public static int firstUniqChar(String s) {
            int freq [] = new int[26]; // alphabet
            for(int i = 0; i < s.length(); i ++)
                freq [s.charAt(i) - 'a'] ++; //-a to convert a to z to 0 to 26
            for(int i = 0; i < s.length(); i ++)
                if(freq [s.charAt(i) - 'a'] == 1) // iterate through same places in string
                    return i;
            return -1;
        }
    
}
