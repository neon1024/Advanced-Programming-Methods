package model.adts;

import exceptions.ADTException;

public interface IStack<T> {

    void push(T element);

    T pop() throws ADTException;

    int size();

    boolean isEmpty();
}
