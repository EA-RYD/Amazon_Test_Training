package Amazon_LC_Q_1;
import java.util.*;

public class MySolnALCQ1 {
    public static void main(String[] args) {
        ListNode head = new ListNode("tomato");
        head.next = new ListNode("potato");
        String[][] operations = {{"PUSH_TAIL","onion"},{"POP_HEAD","-"},{"POP_HEAD","oil"},{"PUSH_HEAD","carrot"}};
        head = getShoppingCart(head, operations);
        while (head != null) {
            System.out.print(head.name + " ");
            head = head.next;
        }
        System.out.println();

    }

    //ops = PUSH_TAIL,PUSH_HEAD,POP_HEAD,
    // ops is ["operation"]["item name"]
    // keep two pointers, one at end and one at beginning
    public static ListNode getShoppingCart(ListNode head, String[][] operations) {
        ListNode firstNode = head;
        while (head.next != null) {
            head = head.next;
        }
        for (String[] s : operations) {
            if (s[0].equals("PUSH_TAIL")) {
                head.next = new ListNode(s[1]);
                head = head.next;
            } else if  (s[0].equals("PUSH_HEAD")) {
                ListNode temp = new ListNode(s[1]);
                temp.next = firstNode;
                firstNode = temp;
            } else  {
                firstNode = firstNode.next;
            }
        }
        return firstNode;
    }
}
