package FIrst_Unique_Char_in_String;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

public class MySolnFUCS {
    /*
     * Given a string s, find the 
     * first non-repeating character in it and return its index. 
     * If it does not exist, return -1
     */
    public static void main(String[] args) {
        String  s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    // hashmap where count is key, take first value of 
    // FASTER THAN 60% mem and speed    
    // eff O(2*n) O(map.size())
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),-1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        int lowestLocation = s.length();
        for (Map.Entry<Character,Integer> e : map.entrySet()) 
            if (e.getValue() != -1) 
                lowestLocation = Integer.min(e.getValue(), lowestLocation);
            
        

        return lowestLocation==s.length() ? -1 : lowestLocation;
    }
}
