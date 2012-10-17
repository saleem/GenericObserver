package com.saleem_siddiqui.java.util.elvis;

import com.saleem_siddiqui.java.util.Filter;

import java.io.PrintStream;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.AUGUST;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:48 AM
 */
public class LogicalElvisObserver extends ElvisObserver {
    private final PrintStream out;

    public LogicalElvisObserver(PrintStream out) {
        this.out = out;
    }

    public void update(Elvis observable, ElvisEvent event) {
        out.printf("A possible Elvis sighting reported on %D\n", event.getLatestSightingDate());
    }

    public static final Filter<ElvisEvent> LOGICAL_ELVIS_FILTER = new Filter<ElvisEvent>() {
        private final Date LAST_SIGHTING_DATE = new GregorianCalendar(1977, AUGUST, 16).getTime();

        public boolean accept(ElvisEvent event) {
            return !(LAST_SIGHTING_DATE.before(event.getLatestSightingDate()));
        }
    };
}
