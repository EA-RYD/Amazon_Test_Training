package Maximize_Distance_to_Closest_Person;

/*
 * Explanation

last is the index of last seated seat.
Loop on all seats, when we met a people, we count the distance from the last.
The final result = max(distance at the beginning, 
distance in the middle / 2, distance at the end).
 */

public class IdealSolnMDCP {
    public int maxDistToClosest(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }
}
