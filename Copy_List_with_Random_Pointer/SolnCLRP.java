package Copy_List_with_Random_Pointer;
import java.util.*;

public class SolnCLRP {
    


    public static void main(String[] args) {
        
    }

    public static Node copyRandomList(Node head) {
       if (head == null) return null;
  
        Map<Node, Node> map = new HashMap<Node, Node>();
        
        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            Node temp = new Node(node.val);
            map.put(node, temp);
            node = node.next;
        }
        
        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}
