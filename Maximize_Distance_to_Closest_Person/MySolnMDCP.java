package Maximize_Distance_to_Closest_Person;
import java.util.*;

public class MySolnMDCP {
    /*
     * You are given an array representing a row of seats where seats[i] = 1 represents 
     * a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.
     */
    public static void main(String[] args) {
        int[] seats = {0,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    //TWO POINTERS
    public static int maxDistToClosest(int[] seats) {
        int left = -1, maxDis = 0;
        int len = seats.length;
        
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) continue;

            if (left == -1) { // goes until 1 hit
                maxDis = Math.max(maxDis, i);
            } else { // distance between left and right 1s div by 2
                maxDis = Math.max(maxDis, (i - left) / 2);
            }
            left = i;
        }
        
        if (seats[len - 1] == 0) {
            maxDis = Math.max(maxDis, len - 1 - left);
        }
        
        return maxDis;
    }
}
