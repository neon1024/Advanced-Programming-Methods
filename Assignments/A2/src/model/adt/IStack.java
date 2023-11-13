package model.adt;

public interface IStack<T> {
    public void push(T item);

    public T pop();

    public boolean isEmpty();
}
