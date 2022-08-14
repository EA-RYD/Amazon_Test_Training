package Unique_Email_Address;
import java.util.*;

/*
 * 
 * it seems best to just iterate once through each email string, since using String split() or replace() or indexOf() implicitly iterates through the email string at each usage.
At each character:

    If '.' is encountered: skip to check next character
    If '+' is encountered: keep moving index to look for '@', then append rest of substring to StringBuilder; break
    If '@' is encountered: append rest of substring to StringBuilder; break
    For all other characters encountered, append to StringBuilder, then continue to check next character
    Build email string and add to set

    The set size is result.
 */
public class IdealSolnUEA {
    public int numUniqueEmails(String[] emails) {
        if (emails == null) {
          return 0;
        }
  
        Set<String> addresses = new HashSet<>();
        
        for (String email : emails) {
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            switch (ch) {
              case '.':
                break;
              case '+':
                while (ch != '@') {
                  ch = email.charAt(++i);
                }
                sb.append(email.substring(i));
                i = email.length();
                break;
              case '@':
                sb.append(email.substring(i));
                i = email.length();
              default:
                sb.append(ch);
            }
          }
          addresses.add(sb.toString());
        }
       
        return addresses.size();
      }
}
