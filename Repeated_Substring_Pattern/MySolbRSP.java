package Repeated_Substring_Pattern;

public class MySolbRSP {

    /*
     * Given a string s, check if it can be constructed 
     * by taking a substring of it and appending multiple 
     * copies of the substring together.
     * 
     */
    public static void main(String[] args) {
        
    }

    //find substring pattern and if we find then split string by pattern and see if every
    // split the same

    // substring pattern must be able to divide string length evenly

    /*
     * 
    The length of the repeating substring must be a divisor of the length of the 
    input string
    Search for all possible divisor of str.length, starting for length/2
    If i is a divisor of length, repeat the substring from 0 to i the number of times 
    i is contained in s.length
    If the repeated substring is equals to the input str return true

     */
    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
