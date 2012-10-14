package com.saleem_siddiqui.java.util;

/**
 * Created by Saleem Siddiqui on 10/10/12 at 11:41 AM
 */
public interface Observer<E> {
    public void update(Observable observable, E event);
}
