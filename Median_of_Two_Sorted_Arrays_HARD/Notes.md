# Prompt
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).
# Notes
- Brute force O(m+n)
   - combine arrays and take middle depending on even or odd array
- In order to solve this question, we need to first understand what a median is. A median is the middle value of a dataset.
Since we have 2 seperately sorted array in this question, to find the middle value is somewhat complicated. However, keep in mind that we do not care about the actual value of the numbers, what we want is the middle point from the combination of 2 arrays. In other words, we are looking for the middle index of the 2 arrays. Thus approach like binary search could be employed.
- Based on the fact that the 2 arrays are sorted seperatedly, we could try to get the submedian of the 2 arrays in each round. Than compare them. And the basic idea is that the left half of the array with a smaller submedian can never contains the common median.

- BINARY SEARCH
  - time complexity of the Linear search is O(n)
  - is a searching algorithm used in a sorted array by repeatedly dividing the search interval in half. The idea of binary search is to use the information that the array is sorted and reduce the time complexity to O(Log n)
  - Binary Search Algorithm: The basic steps to perform Binary Search are:

    1. Begin with the mid element of the whole array as a search key.
    2. If the value of the search key is equal to the item then return an index of the search key.
    Or if the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
    3. Otherwise, narrow it to the upper half.
    4. Repeatedly check from the second point until the value is found or the interval is empty.
  - Iterative Method,Recursive Method
- The key point of this problem is to ignore half part of A and B each step recursively by comparing the median of remaining A and B
  - if (aMid < bMid) Keep [aRight + bLeft]    
else Keep [bRight + aLeft]
- 