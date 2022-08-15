package K_Closest_Points_to_Origin;
import java.util.*;

public class MySolnKCPO {
    /*
     * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and 
     * an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
     */
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        for (int[] is : kClosest(points, k)) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }

    //prio que, add all points
    //85.31%
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a,int[] b) {
                double da = Math.sqrt((a[0] * a[0]) + (a[1] * a[1]));
                double db = Math.sqrt((b[0] * b[0]) + (b[1] * b[1]));
                if (da > db) 
                    return 1;
                else if (db > da)
                    return -1;
                else 
                    return 0;
            }
        });

        for (int[] coord : points) 
            que.offer(coord);
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) 
            res[i] = que.poll();
    
        return res;
    }
}
