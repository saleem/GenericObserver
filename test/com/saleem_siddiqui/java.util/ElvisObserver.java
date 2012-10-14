package com.saleem_siddiqui.java.util;

import java.io.PrintStream;
import java.util.Date;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:48 AM
 */
class ElvisObserver<ElvisEvent> implements Observer<ElvisEvent> {
    private final PrintStream out;
    private Date latestSightingDate;
    public ElvisObserver(PrintStream out) {
        this.out = out;
    }
//    public void update(Observable observable, ElvisEvent event) {
//        out.printf("News Flash: Latest Elvis sighting at %D\n", event.getLatestSightingDate());
////        out.println("News Flash: Latest Elvis sighting at " + event);
//    }

    public void update(Observable observable, ElvisEvent event) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
