package Pascals_Triangle2;
import java.util.*;
import java.util.stream.Collectors;

public class MySolnPT {
    /*
     * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

     */
    public static void main(String[] args) {
        int rowIndex = 7;
        System.out.println();
        for (Integer i : getRow(rowIndex)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> getRow(int rowIndex) {
       int[] row = new int[rowIndex + 1];
       row[0] = 1;
        for (int i = 1;i<=rowIndex;i++) {
            for (int j = i; j > 0; j--) 
                row[j] = row[j] + row[j - 1];
        }

        return Arrays.stream(row).boxed().collect(Collectors.toList());
    }
}
