# Prompt
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

# Explanation
We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.

At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

    If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

    Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

    As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]

# SOLN 2
For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4

    partition the array in blocks of size w=4. The last block may have less then w.
    2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|

    Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
    left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56

    Similarly calculate max in future by traversing from end to start.
    right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56

    now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
    sliding_max = 4, 6, 6, 8, 9, 10, 12, 56

 public static int[] slidingWindowMax(final int[] in, final int w) {
    final int[] max_left = new int[in.length];
    final int[] max_right = new int[in.length];

    max_left[0] = in[0];
    max_right[in.length - 1] = in[in.length - 1];

    for (int i = 1; i < in.length; i++) {
        max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

        final int j = in.length - i - 1;
        max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
    }

    final int[] sliding_max = new int[in.length - w + 1];
    for (int i = 0, j = 0; i + w <= in.length; i++) {
        sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
    }

    return sliding_max;
}
