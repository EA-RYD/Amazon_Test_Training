package Distant_Barcodes;

import java.util.*;
import java.util.stream.Collectors;

public class MySolnDB {
    public static void main(String[] args) {
        int[] barcodes = new int[] {1,1,1,1,2,2,3,3};
        System.out.println();
        for (int i : rearrangeBarcodes(barcodes)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //prio que where prio is determined on count inserted
    /*
     * 
    Store all the elements along with their number of occurrences in a HashMap.
    Add them to a PriorityQueue in descending order of their occurrences.
    Each time, poll an element from the head of the queue to add to the result list, 
    decrease the occurrences of that element and store it in a temporary list/ queue 
    to freeze it from being picked for K elements where K = 2.
    Add elements from the temporary list back into the PriorityQueue and repeat until 
    the PriorityQueue is empty.
    Return the result array.

     */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        int[] result = new int[barcodes.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i : barcodes) 
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else   
                map.put(i,1);
        
        for (Map.Entry<Integer,Integer> m : map.entrySet()) {
            
        }
        PriorityQueue<Integer> que = new PriorityQueue<>(barcodes.length,new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) < map.get(o2)) 
                    return 1;
                else if (map.get(o1) > map.get(o2)) 
                    return -1;
                return 0;
            }
        });

        //que.addAll(Arrays.stream(barcodes).boxed().collect(Collectors.toList()));
        
        int i = 0;
        ArrayList<Integer> tempHolder = new ArrayList<>();
        while (!map.isEmpty()) {
            que.add(i);
            if (map.get(result[i]) == 0)
                map.remove(result[i]);
            else 
                map.put(result[i], map.get(result[i]) - 1);
            i++;
        }

        return result;
    }
}
