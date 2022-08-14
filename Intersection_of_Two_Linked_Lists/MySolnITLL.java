package Intersection_of_Two_Linked_Lists;
import java.util.*;;

public class MySolnITLL {

    //Given the heads of two singly linked-lists headA and headB, 
    //return the node at which the two lists intersect. If the two linked 
    //lists have no intersection at all, return null.
    public static void main(String[] args) {
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode output = getIntersectionNode(headA, headB);

    }

    //
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null && headB != null) {
            if (headA == headB)
                System.out.println("yo");
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
