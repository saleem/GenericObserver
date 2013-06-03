package com.thoughtworks.genericObserver.elvis;

import java.io.PrintStream;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:48 AM
 */
public class FanaticalElvisObserver extends ElvisObserver {
    private final PrintStream out;
    public FanaticalElvisObserver(PrintStream out) {
        this.out = out;
    }
    public void update(Elvis observable, ElvisEvent event) {
           out.printf("News Flash: the King was sighted on %D!!\n", event.getLatestSightingDate());
    }
}
