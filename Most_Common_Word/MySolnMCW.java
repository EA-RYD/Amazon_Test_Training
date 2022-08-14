package Most_Common_Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MySolnMCW {
    /*
     * Given a string paragraph and a string array of the banned words banned, 
     * return the most frequent word that is not banned.
     * 
     * The words in paragraph are case-insensitive and 
     * the answer should be returned in lowercase. 
     */
    public static void main(String[] args) {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        System.out.println(mostCommonWord(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        ArrayList<String> convert = new ArrayList<>(Arrays.asList(banned));
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : paragraph.toLowerCase().replaceAll("[^A-Za-z0-9]", " ").trim().split(" ")) 
            if (!convert.contains(s) && !s.equals("")) 
                map.put(s, map.getOrDefault(s, 0) + 1);
        
        String largest = "";
        int mostCommon = 0;

        for (String s : map.keySet()) {
            if (map.get(s) > mostCommon) {
                mostCommon = map.get(s);
                largest = s;
            }
        }

        return largest;
    }
}
