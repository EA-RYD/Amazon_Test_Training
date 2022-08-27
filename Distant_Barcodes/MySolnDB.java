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

    Distant Barcodes

     */
    public static int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i : barcodes) 
            map.put(i, map.getOrDefault(i,0) + 1);
    
        PriorityQueue<int[]> que = new PriorityQueue<>(barcodes.length,(x,y) -> Integer.compare(y[1], x[1]));

        for (Map.Entry<Integer,Integer> e : map.entrySet()) 
            que.offer(new int[] {e.getKey(),e.getValue()});
        
    
        int i = 0;
        int[] result = new int[barcodes.length];
        while (!que.isEmpty()) {
            int[] temp = que.poll();
            if (i == 0 || temp[0] != result[i-1]) {
                result[i] = temp[0];
                if (--temp[1] > 0) {
                    que.add(temp);
                }
            } else {
                int[] second = que.poll();
                result[i] = second[0];
                if (--second[1] > 0) {
                    que.add(second);
                }
                que.add(temp);
            }
            i++;
        }

        return result;
    }
}
