package Sort_Characters_By_Frequency;
import java.util.*;

public class MySolnSCF {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,StringBuilder> strings = new HashMap<>();
        PriorityQueue<Character> que = new PriorityQueue<>((x,y) -> Integer.compare(map.get(y),map.get(x))); 
        
        for (Character character : s.toCharArray()) {
            map.put(character, map.getOrDefault(character, 0) + 1);

            if(strings.containsKey(character))
                strings.get(character).append(character);
            else  {
                strings.put(character, new StringBuilder());
                strings.get(character).append(character);
            }
    
            if (!que.contains(character))
                que.add(character);
            else {
                que.remove(character);
                que.add(character);
            }
        }
        while (!que.isEmpty()) {
            Character c = que.poll();
            ans.append(strings.get(c));
        }
        return ans.toString();
    }
}
