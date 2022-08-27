package LRU_Cache;

public class MainTest {
    public static void main(String[] args) {
        int capacity = 2;
        LRUCache test = new LRUCache(capacity);
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1));
        test.put(3, 3);
        System.out.println(test.get(2));
        test.put(4, 4);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
    }
}
