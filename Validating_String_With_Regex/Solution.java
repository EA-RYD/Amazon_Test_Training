package Validating_String_With_Regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    final static Scanner scan = new Scanner(System.in);
    final static String fileName = System.getenv("OUTPUT_PATH");
    

    /*
     * Write the regular expression in the blank space below
     */
    final static String regularExpression = "([ab])(.*\\1)?";
    /*() Character group, matches the characters in that exact order
[ ] Character class, matches any character contained between the square brackets
so ([ab]) means match a or b
. period matches any single character except a line break
* matches 0 or more repetitions of the preceding symbol
The backreference \1 (backslash one) references the first capturing group, \1 matches the exact same text that was matched by the first capturing group
we have \\1 because the first \ escapes the next character, which allows us to match reserved character \1
then in the end we have ? to make the preceding symbol optional(.*\\1), so if we have just a single 'a' or 'b' would also return true. */
    

    public static void main(String[] args) throws IOException {
        System.out.println("a".matches(regularExpression));


        /* 
        int query = Integer.parseInt(scan.nextLine());
        String[] result = new String[query];
        Arrays.fill(result, "False");
        
        for (int i = 0; i < query; i++) {
            String someString = scan.nextLine();
            
            if (someString.matches(regularExpression)) {
                result[i] = "True";
            }
        }
        
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
        for (String res: result) {
            fileOut.write(res + "\n");
        }
        
        fileOut.close();
        */
    }
}
