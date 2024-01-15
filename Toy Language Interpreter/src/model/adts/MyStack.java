package model.adts;

import exceptions.ADTException;

import java.util.*;

public class MyStack<T> implements IStack<T> {

    Stack<T> stack;

    public MyStack() {
        this.stack = new Stack<T>();
    }
    @Override
    public void push(T element) {
        this.stack.push(element);
    }

    @Override
    public T top() throws ADTException {
        if(this.stack.isEmpty()) throw new ADTException("Stack is empty");

        return this.stack.peek();
    }

    @Override
    public T pop() throws ADTException {
        try {
            return this.stack.pop();
        } catch(Exception adte) {
            throw new ADTException(adte.getMessage());
        }
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(T element : this.stack.reversed()) {
            stringBuilder.append(element.toString()).append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public Collection<T> reversed() {
        List<T> reversed = new ArrayList<>(this.stack);
        Collections.reverse(reversed);
        return reversed;
    }
}
