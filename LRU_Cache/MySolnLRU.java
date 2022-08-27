package LRU_Cache;
import java.util.*;

public class MySolnLRU {
    public static void main(String[] args) {
        int key = 0;
        int value = 10;
        int capacity = 5;
        LRUCache obj = new LRUCache(capacity);
        int param_1 = obj.get(key);
        obj.put(key,value);
    }


}
