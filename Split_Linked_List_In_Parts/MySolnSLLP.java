package Split_Linked_List_In_Parts;
import java.util.*;
/*
 * Given the head of a singly linked list and an integer k, split the 
 * linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts 
should have a size differing by more than one. This may lead to some parts
 being null.

The parts should be in the order of occurrence in the input list, and parts 
occurring earlier should always have a size greater than or equal to parts 
occurring later.

Return an array of the k parts.
 */

public class MySolnSLLP {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        
        head.next.next.next.next.next.next.next = new ListNode(8);
    
        //head.next.next.next.next.next.next.next.next = new ListNode(9);
        //head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    
        int k = 3;

        for (ListNode node : splitListToParts(head, k)) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] holder = new ListNode[k];
        ListNode[] ans = new ListNode[k];

        ListNode fast = head;
        int length = 0;

        while (fast!=null && fast.next!=null) {
            length++;
            fast = fast.next.next;
        }
        length *= 2;
        if (fast != null)
            length++;

        int n = length / k, r = length%k;


        for (int i = 0; head != null &&  i < k; i++, r--) {
            ans[i] = head;
            ListNode temp = null;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) { // for each indice in r go to n+1
                temp = head;
                head = head.next;
            } 
            temp.next = null;
        }
        
        return ans;
    }

}
