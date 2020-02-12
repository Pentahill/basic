package boot;
import java.util.*;

class App {

    Map<Integer, Integer> map = null;
    int capacity = 0;

    public App(int capacity) {
        this.capacity = capacity;

        this.map = new LinkedHashMap<Integer, Integer>(capacity, 1, true){

            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > App.this.capacity;
            }

        };

        this.map = Collections.synchronizedMap(map);
    }

    public int get(int key) {
        if(this.map.containsKey(key)) {
            return this.map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        this.map.put(key, value);
    }

    public static void main(String[] args) {
        App cache = new App(2);
        System.out.println(cache.map.size());
        cache.put(1,1);
        System.out.println(cache.map.size());
        cache.put(2,2);
        System.out.println(cache.map.size());
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.map.size());
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
