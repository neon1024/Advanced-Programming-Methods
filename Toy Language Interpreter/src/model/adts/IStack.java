package model.adts;

import exceptions.ADTException;
import model.statements.Statement;

import java.util.Collection;

public interface IStack<T> {

    void push(T element);

    T top() throws ADTException;

    T pop() throws ADTException;

    int size();

    boolean isEmpty();

    Collection<T> reversed();
}
