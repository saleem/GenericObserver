package com.saleem_siddiqui.java.util.elvis;

import com.saleem_siddiqui.java.util.ObservableAdapter;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:50 AM
 */
public class Elvis extends ObservableAdapter<LogicalElvisObserver, ElvisEvent> {
    private Elvis() {
    }
    private static final Elvis theOne = new Elvis();
    public static Elvis theOne() {
        return theOne;
    }
}