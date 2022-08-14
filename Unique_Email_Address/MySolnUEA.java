package Unique_Email_Address;
import java.util.*;

public class MySolnUEA {
    public static void main(String[] args) {
        String[] emails = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    //faster than 83.66, 90 less memory
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> unique = new HashSet<>();
        for (String s : emails) {
            String local = s.substring(0,s.indexOf('@'));
            String domain = s.substring(s.indexOf('@') + 1);
            if (local.contains("+"))
                local = local.substring(0, local.indexOf("+"));
            if (local.contains("."))
                local = local.replace(".", "");
            unique.add(local + "@" + domain);
        }
        return unique.size();
    }
}
