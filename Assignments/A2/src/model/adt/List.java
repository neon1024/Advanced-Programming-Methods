package model.adt;

import model.adt.IList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

public class List<T> implements IList<T> {

    final java.util.List<T> list;

    public List() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(T item) {
        this.list.add(item);
    }

    @Override
    public T pop() {
        return this.list.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        synchronized (this.list) {
            this.list.forEach(action);
        }
    }

    @Override
    public java.util.List<T> getList() {
        return this.list;
    }
}
