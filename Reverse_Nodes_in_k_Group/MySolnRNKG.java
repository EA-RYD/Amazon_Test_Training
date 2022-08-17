package Reverse_Nodes_in_k_Group;
import java.util.*;

public class MySolnRNKG {
    /*
     * Given the head of a linked list, reverse the nodes of the list k at a time, 
     * and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
     */

     // O()
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 3;
        ListNode newHead = reverseKGroup(head, k);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode initialTemp = new ListNode();
        ListNode refToInitial = initialTemp;
        ListNode startCopy = new ListNode(-1);
        int counter = 1;
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            if (counter == k) {
                initialTemp.next = reverse(nums);
                nums.clear();
                while (initialTemp.next != null)
                    initialTemp = initialTemp.next;
                counter = 0;
            } else if (counter == 1) {
                startCopy = head;
            }
            counter++;
            head = head.next;
        }        
        if (!nums.isEmpty())
            initialTemp.next = startCopy;
        return refToInitial.next;    
    }
    public static ListNode reverse(ArrayList<Integer> nums) {
        ListNode resultNode = new ListNode();
        for (int i = 0; i < nums.size(); i++) {
            resultNode.val = nums.get(i);
            ListNode temp = new ListNode(0,resultNode);
            if (i!=nums.size()-1)
                resultNode = temp;
        }
        return resultNode;
    }

}
