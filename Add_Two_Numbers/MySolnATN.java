package Add_Two_Numbers;
import java.util.*;

public class MySolnATN {
    public static void main(String[] args) {
        ListNode test11 = new ListNode(9);
        ListNode test12 = new ListNode(9);
        ListNode test13 = new ListNode(9);
        ListNode test14 = new ListNode(9);
        ListNode test15 = new ListNode(9);
        ListNode test16 = new ListNode(9);
        ListNode test17 = new ListNode(9);

        test11.next = test12;
        test12.next = test13;
        test13.next = test14;
        test14.next = test15;
        test15.next = test16;
        test16.next = test17;

        ListNode test21 = new ListNode(9);
        ListNode test22 = new ListNode(9);
        ListNode test23 = new ListNode(9);
        ListNode test24 = new ListNode(9);

        test21.next = test22;
        test22.next = test23;
        test23.next = test24;


        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);


        ListNode temp = addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode();
        ListNode temp = res;

        while(true) {
            int add = l1.val + l2.val + carry;
            if (add >= 10) {
                res.val = (add) % 10;
                carry = (add) / 10;
            } else {
                res.val = (add);
                carry = 0;
            }
            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null || l2 == null) {
                break;
            } else {
                res.next = new ListNode();
                res = res.next;
            }
        }

        if (l1 != null || l2 != null) {
            ListNode nonNull = (l1 == null) ? l2 : l1;
            res.next = new ListNode();
            res = res.next; 
            while(true) {
                int add = nonNull.val + carry;
                if (add >= 10) {
                    res.val = (add) % 10;
                    carry = (add) / 10;
                } else {
                    res.val = (add);
                    carry = 0;
                }
                
                nonNull = nonNull.next;
                if (nonNull == null) {
                    break;
                } else {
                    res.next = new ListNode();
                    res = res.next;
                }
            }
        }

        if (carry != 0) {
            res.next = new ListNode();
            res = res.next;
            res.val = carry;
        }

        return temp;
    }
}
