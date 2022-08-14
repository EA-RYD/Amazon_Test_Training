# Explain
dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
State transition:
dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
Initialization: dp[i][i] = 1


You will be considering substrings starting at left and ending at right (inclusive). To do this you will iterate over all lengths from 1 to n and within each length iterate over staring (or left) position. The key is that you get the answers for a single length at all start positions before going to the next length because the dp depends on the answers from shorter lengths. If you do it this way you will have 3 cases to consider on every iteration, pick the one with the highest value.

    the answer from removing the left edge char
    the answer from removing the right edge char
    and if the left and right chars are equal, 2 plus the answer from removing both left and right

the 3rd case is how the answer grows. After iterating through all you will have performed O(n^2) checks and used O(n^2) memory, the answer is where left is 0 and right is n-1 which will be your very last calculation.

# Example