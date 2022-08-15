package Number_of_Provinces;
import java.util.*;

public class MySolnNOP {

    /*
     * There are n cities. Some of them are connected, while some are not. If city a is 
     * connected directly with city b, and city b is connected directly with city c, then city a 
     * is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city 
are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
     */

     //Union Find type problem
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int m = isConnected.length, cnt = 0;
        int[] root = new int[m]; 
        for (int i = 0; i < m; i++) root[i] = i; 
        for (int i = 0; i < m; i++) 
            for (int j = i + 1; j < m; j++)
                if (isConnected[i][j] == 1) unionFind(root, i, j);

        for (int i = 0; i < m; i++)
            if (i == root[i]) cnt++;
        return cnt;
    }
    
    static void  unionFind (int[] root, int v1, int v2) {
        while (root[v1] != v1) v1 = root[v1]; //find v1's root
        while (root[v2] != v2) v2 = root[v2]; //find v2's root
        if (root[v1] != root[v2]) root[v2] = v1; //unite the 2 subtrees 
    }
}
