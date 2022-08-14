package Reverse_Array_Queries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'performOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. 2D_INTEGER_ARRAY operations
     */

    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        for (List<Integer> list : operations) {
            //int length = list.get(1) - list.get(0);
            for (int i = list.get(0),j = list.get(1);i < j;i++,j--) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, temp);
            }
        }
        return arr;
        }

}

