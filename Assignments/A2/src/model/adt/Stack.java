package model.adt;

import java.util.Deque;
import java.util.LinkedList;

public class Stack<T> implements IStack<T> {
    Deque<T> stack;

    public Stack() {
        this.stack = new LinkedList<>();
    }

    @Override
    public void push(T item) {
        this.stack.push(item);
    }

    @Override
    public T pop() {
        return this.stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
}
