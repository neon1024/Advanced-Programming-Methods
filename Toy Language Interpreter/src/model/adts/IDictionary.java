package model.adts;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface IDictionary<K, V> {
    void add(K key, V value);

    void remove(K key);

    V get(K key);

    void update(K key, V value);

    boolean search(K key);

    int size();

    boolean isEmpty();

    Set<K> keys();

    Collection<V> values();

    Collection<Map.Entry<K, V>> entrySet();

    IDictionary<K, V> deepCopy();
}
