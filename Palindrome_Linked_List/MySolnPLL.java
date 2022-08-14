package Palindrome_Linked_List;
import java.util.*;

public class MySolnPLL {
    //Given the head of a singly linked list, return true if it is a palindrome.
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(0));
        head.next.next = new ListNode(1);
        //head.next.next.next = new ListNode(3);
        //head.next.next.next.next = new ListNode(3);
        System.out.println(isPalindrome(head));
    }

    // two pointers, fast and slow, one should be at middle while one is at end
    // just move one twice as fast to achieve this
    //if fast reaches end then you know slow is at middle
    //compare what has been iterated to second half of list
    public static boolean isPalindrome(ListNode head) {
        int sizeTotal = 0;
        List<Integer> firstHalf = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            firstHalf.add(slow.val);
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
                sizeTotal+=2;
            } 
            else  {
                fast = null;
                sizeTotal++;
            }
        }
    
        if (sizeTotal % 2 != 0 && firstHalf.size() > 1)// odd
            firstHalf.remove(firstHalf.size()-1);

        int i = firstHalf.size() - 1;
        while (slow != null) {
            if (i < 0 || slow.val != firstHalf.get(i)) 
                return false;
            
            i--;
            slow = slow.next;
        }

        return true;
    }
}
