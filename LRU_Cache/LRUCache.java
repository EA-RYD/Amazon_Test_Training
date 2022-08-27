package LRU_Cache;
import java.util.*;

// KEY IS HASHMAP OF NODES OF A DOUBLE LINKED LIST
class LRUCache {
    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        public Node(){
            key = 0;
            value = 0;
        }
        public Node(int key,int value) {
            this.value = value;
            this.key = key;
        }
    }

    HashMap<Integer,Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            int re = temp.value;
            deleteNode(temp);
            addToHead(temp);
            return re;
        } else 
            return -1;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            deleteNode(temp);
            addToHead(temp);
        } else {
            Node newNode = new Node(key,value);
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            } 
            map.put(key, newNode);
            addToHead(newNode);
            
        } 
    }
}
