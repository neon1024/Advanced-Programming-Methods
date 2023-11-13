package model.adt;

import exceptions.DictionaryException;

import java.util.Set;

public interface IDict<K, V> {

    void add(K key, V value) throws DictionaryException;

    void update(K key, V value) throws DictionaryException;
    void remove(K key) throws DictionaryException;

    V get(K key) throws DictionaryException;

    boolean containsKey(K key);

    void put(K key, V val);

    Set<K> keySet();

    IDict<K,V> copy() throws DictionaryException;
}
