package com.saleem_siddiqui.java.util.elvis;

import com.saleem_siddiqui.java.util.Observable;
import com.saleem_siddiqui.java.util.Observer;

import java.io.PrintStream;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:48 AM
 */
public class FanaticalElvisObserver implements Observer<ElvisEvent> {
    private final PrintStream out;
    public FanaticalElvisObserver(PrintStream out) {
        this.out = out;
    }
    public void update(Observable observable, ElvisEvent event) {
           out.printf("News Flash: Elvis was sighted on %D!!\n", event.getLatestSightingDate());
    }
}
