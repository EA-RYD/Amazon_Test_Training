package Sliding_Window_Max;
import java.util.*;

public class SolnSWW {
    public static void main(String[] args) {
        
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[]a = nums;
        if (a == null || k <= 0) {
			return new int[0];
		}
		int[] r = new int[a.length-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
    }
}
