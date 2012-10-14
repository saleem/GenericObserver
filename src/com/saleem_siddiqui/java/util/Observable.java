package com.saleem_siddiqui.java.util;

/**
 * Created by Saleem Siddiqui on 10/10/12 at 11:44 AM
 */
public interface Observable<T extends Observer<E>, E> {
    void addObserver(T observer);

    void deleteObserver(T observer);

    void notifyObservers();

    void notifyObservers(E event);

    void deleteObservers();

    boolean hasChanged();

    int countObservers();
}
