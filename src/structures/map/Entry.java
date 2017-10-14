package structures.map;
import java.util.Map;

public class Entry<K,V> implements Map.Entry<K,V> {

    final K key;
    V value;

    Entry<K,V> next;
    final int hash;

    Entry(int h, K k, V v, Entry<K,V> n) {
        value = v;
        next = n;
        key = k;
        hash = h;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if(!(o instanceof Map.Entry)) {
            return false;
        }
        Map.Entry e = (Map.Entry)o;
        Object k1 = getKey();
        Object k2 = e.getKey();
        if(k1 == k2 || (k1 != null && k1.equals(k2))) {
            Object v1 = getValue();
            Object v2 = e.getValue();
            if (v1 == v2 || (v1 != null && v1.equals(v2))) {
                return true;
            }
        }
        return false;

    }

    public final int hashCode() {
        return (key==null ? 0 : key.hashCode() ^
                (value==null ? 0 : value.hashCode()));
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }

    void recordAccess(HashMap m) {

    }

    void recordRevome(HashMap m) {

    }





}
