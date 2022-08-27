package Car_Pooling;
import java.util.*;;

public class MySolnCP {
    /*
     * There is a car with capacity empty seats. 
     * The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where 
trips[i] = [numPassengersi, fromi, toi] indicates that the ith 
trip has numPassengersi passengers and the locations to pick them
 up and drop them off are fromi and toi respectively. The locations 
 are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers 
for all the given trips, or false otherwise.
     */
    public static void main(String[] args) {
        int[][] trips = {{2,1,5},{3,3,7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }

    /*
     * We solve this problem by simulating the process of pickup and dropdown. 
     * To do so, we need

    1. sort trips by start_location
    2. Using a priorityQueue to store live trips.
     The element with the least end_location is at the top of the queue. 
     Each time we push a new trip into the queue, we compare its start_location 
     with the end_loation of peek element to remove dead trips.
    3.Update the capacity when a trip is pushed into or popped 
    out of the queue. If capacity is less than zero, then we cannot pick up 
    and drop off all passengers.

     */
    //sorted array, prio que
    public static boolean carPooling(int[][] trips, int capacity) {
        // 1. sort trips by start_location
        Arrays.sort(trips, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
    
        Queue<int[]> theQueue = new PriorityQueue<int[]>(new Comparator<int[]>(){
             public int compare(int[] t1, int[] t2) {
                 return t1[2] - t2[2];
             }
        });
    
        for (int i = 0; i < trips.length; i++) {
            while (!theQueue.isEmpty() && theQueue.peek()[2] <= trips[i][1]) { // 2. remove dead trips
                capacity += theQueue.peek()[0];
                theQueue.poll();
            }
            // 3. update capacity
            capacity -= trips[i][0];
            theQueue.offer(trips[i]);
            if( capacity < 0 )
                return false;
        }
        return true;
    }
    
}
