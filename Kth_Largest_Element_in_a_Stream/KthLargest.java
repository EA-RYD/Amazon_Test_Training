package Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.stream.Stream;

public class KthLargest {
    PriorityQueue<Integer> que;
    int k;
    public KthLargest(int k, int[] nums) {
        que = new PriorityQueue<>(k);
        for (int i : nums)  {
            que.offer(i);
            if (que.size() > k) que.poll();
        }
            
        this.k = k;
    }
    
    public int add(int val) {
        if (que.size() < k) {
            que.offer(val);
        } else if (que.peek() < val) {
            que.poll();
            que.offer(val);
        }
        return que.peek();
    }
}
