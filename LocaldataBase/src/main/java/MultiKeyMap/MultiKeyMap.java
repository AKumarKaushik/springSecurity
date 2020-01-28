package MultiKeyMap;

import java.util.HashMap;
import java.util.Map;

public class MultiKeyMap<K1, K2, V1> {

    private Map<Key<K1, K2>, V1> map = new HashMap();

    public V1 get(K1 k1, K2 k2) {
        return map.get(new Key<K1, K2>(k1, k2));
    }

    public void put(K1 k1, K2 k2, V1 v1) {
        map.put(new Key<K1, K2>(k1, k2), v1);
    }

    class Key<K1, K2> {

        private K1 k1;
        private K2 k2;

        Key(K1 k1, K2 k2) {
            this.k1 = k1;
            this.k2 = k2;
        }
    }

    public static void main(String[] args) {

    }
}
