package com.saleem_siddiqui.java.util.elvis;

import com.saleem_siddiqui.java.util.Observable;
import com.saleem_siddiqui.java.util.Observer;

import java.io.PrintStream;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.AUGUST;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:48 AM
 */
public class LogicalElvisObserver implements Observer<ElvisEvent> {
    private final PrintStream out;
    private final static Date LAST_SIGHTING_DATE = new GregorianCalendar(1977, AUGUST, 16).getTime();
    public LogicalElvisObserver(PrintStream out) {
        this.out = out;
    }
    public void update(Observable observable, ElvisEvent event) {
        if (LAST_SIGHTING_DATE.before(event.getLatestSightingDate())) {
           out.printf("An unreliable Elvis sighting reported on %D\n", event.getLatestSightingDate());
        }
        else {
           out.printf("A possible Elvis sighting reported on %D\n", event.getLatestSightingDate());
        }
    }
}
