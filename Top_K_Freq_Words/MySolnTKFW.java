package Top_K_Freq_Words;
import java.util.*;

public class MySolnTKFW {
    public static void main(String[] args) {
        String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        for (String string : topKFrequent(words, k)) {
            System.out.println(string);
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            map.putIfAbsent(s, 1);
        }

        PriorityQueue<String> que = new PriorityQueue<>(map.keySet().size(),new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (map.get(s1) < map.get(s2)) 
                    return 1;
                else if (map.get(s1) > map.get(s2))
                    return -1;
                else {
                    return s1.compareTo(s2);
                }
            }
        });

        que.addAll(map.keySet());
        
        List<String> topK = new ArrayList<>();
        for (int i=0;i<k;i++) {
            topK.add(que.poll());
        }

        return topK;
    }
}
