package Linked_List_Cycle;

public class IdealSolnLLC {
    //TWO POINTER TECHNIQUE ONE FAST ONE SLOW
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
          
          if (slow == fast) 
              return true;
        }
        
        return false;
      }
}
