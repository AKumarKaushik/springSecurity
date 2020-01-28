package Learning.javaExample.MultiKeyMap;

import java.util.HashMap;
import java.util.Map;

public class MultiKeyMap<K1, K2, V> {

    private Map<Key<K1, K2>, V> map = new HashMap<>();

    public V get(K1 k1, K2 k2) {
        return map.get(new Key<>(k1, k2));
    }

    public void put(K1 k1, K2 k2, V v1) {
        map.put(new Key<>(k1, k2), v1);
    }

    class Key<K1, K2> {

        private K1 k1;
        private K2 k2;

        Key(K1 k1, K2 k2) {
            this.k1 = k1;
            this.k2 = k2;
        }
    }
}
