package  Sort_the_Summary;
import java.util.*;

public class MySolnSTS {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3,7,12,3);
        for (List<Integer> i : groupSort(arr)) {
            for (Integer j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer i : arr) 
            map.put(i, map.getOrDefault(i, 0) + 1);
        
        for (var v : map.entrySet()) 
            res.add(Arrays.asList(v.getKey(),v.getValue()));
        
        Collections.sort(res, new Comparator<List<Integer>>() {
            public int compare(List<Integer> l1,List<Integer>l2) {
                if (l2.get(1) > l1.get(1)) 
                    return 1;
                else if (l2.get(1) < l1.get(1)) 
                    return -1;
                else  
                    if (l2.get(0) < l1.get(0)) 
                        return 1;
                    else if (l2.get(0) > l1.get(0))
                        return -1;
                
                return 0;
            }
        });
    
        return  res;
    }
}
