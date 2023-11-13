package model.adt;

import java.util.function.Consumer;

public interface IList<T> {

    void add(T item);
    T pop();
    boolean isEmpty();
    void forEach(Consumer<? super T> action);
    java.util.List<T> getList();
}
