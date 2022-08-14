package Linked_List_Cycle;

public class MySolnLLC {
    public static void main(String[] args) {
        
    }


    public boolean hasCycle(ListNode head) {
        while (head  != null) {
            if (head.val == Integer.MIN_VALUE) {
                return true;
            } else {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
        }
        return false;
    }
}
