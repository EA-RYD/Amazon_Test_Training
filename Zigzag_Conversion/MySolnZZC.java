package Zigzag_Conversion;
import java.lang.reflect.Array;
import java.util.*;
/*
 * string to zigzag version depending on input
 */
public class MySolnZZC {
    public static void main(String[] args) {
        String s = "AB";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }
    public static String convert(String s, int numRows) {
        StringBuffer totalString = new StringBuffer("");
        ArrayList<StringBuffer> strs = new ArrayList<>();

        for (int i = 0;i<numRows;i++) 
            strs.add(new StringBuffer());
        
        boolean direction = true; // false for decreasing, true for increasing
        for (int i = 0,j=0; i < s.length(); i++) {
            strs.get(j).append(s.charAt(i));     
            if (numRows-1 != 0) {
                if (numRows-1 == 0) 
                    direction = true;
                else if (j == numRows-1 ) 
                    direction = false;
                else if (j == 0) 
                    direction = true;
                j = (direction) ? j + 1 : j - 1;
            }
        }

        for (StringBuffer stringBuffer : strs) {
            totalString.append(stringBuffer.toString());
        }

        return totalString.toString();
    }
}
