package model.adt;

import exceptions.DictionaryException;
import model.adt.IDict;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dict<K, V> implements IDict<K, V> {

    Map<K, V> dictionary;

    public Dict() {
        this.dictionary = new HashMap<>();
    }

    @Override
    public void add(K key, V value) throws DictionaryException {
        // TODO check if already exists
        if(this.dictionary.containsKey(key)) throw new DictionaryException("Key already exists");

        this.dictionary.put(key, value);
    }

    @Override
    public void update(K key, V value) throws DictionaryException {
        if(! this.dictionary.containsKey(key)) throw new DictionaryException("Key doesn't exist");

        this.dictionary.replace(key, value);
    }

    @Override
    public void remove(K key) throws DictionaryException {
        if(! this.dictionary.containsKey(key)) throw new DictionaryException("Key doesn't exist");

        this.dictionary.remove(key);
    }

    @Override
    public V get(K key) throws DictionaryException {
        if(! this.dictionary.containsKey(key)) throw new DictionaryException("Key doesn't exist");

        return this.dictionary.get(key);
    }

    @Override
    public void put(K key, V value) {
        this.dictionary.put(key, value);
    }

    @Override
    public Set<K> keySet() {
        return this.dictionary.keySet();
    }

    @Override
    public boolean containsKey(K key) {
        return this.dictionary.containsKey(key);
    }

    @Override
    public IDict<K, V> copy() throws DictionaryException {
        IDict<K, V> toReturn = new Dict<>();

        for(K key : keySet())
            toReturn.put(key, get(key));

        return toReturn;
    }
}
