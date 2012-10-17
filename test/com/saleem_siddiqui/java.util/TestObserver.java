package com.saleem_siddiqui.java.util;

import com.saleem_siddiqui.java.util.elvis.Elvis;
import com.saleem_siddiqui.java.util.elvis.FanaticalElvisObserver;
import com.saleem_siddiqui.java.util.elvis.LogicalElvisObserver;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Saleem Siddiqui on 10/13/12 at 11:49 PM
 */
public class TestObserver {
    private PrintStream mockPrintStream;
    private Elvis elvis;
    private LogicalElvisObserver logicalElvisObserver;
    private FanaticalElvisObserver fanaticalElvisObserver;
    private final Date born = new GregorianCalendar(1935, JANUARY, 8).getTime();
    private final Date conscripted = new GregorianCalendar(1958, MARCH, 24).getTime();
    private final Date died = new GregorianCalendar(1977, AUGUST, 16).getTime();
    private final Date today = new Date();

    @Before
    public void setUp() throws Exception {
        mockPrintStream = mock(PrintStream.class);
        elvis = Elvis.theOne();
        logicalElvisObserver = new LogicalElvisObserver(mockPrintStream);
        fanaticalElvisObserver = new FanaticalElvisObserver(mockPrintStream);
    }

    @Test
    public void fanaticalObserverReportsOnAllElvisEvents() {
        elvis.addObserver(fanaticalElvisObserver);

        elvis.observedOn(born);
        verify(mockPrintStream).printf("News Flash: the King was sighted on %D!!\n", born);
        elvis.observedOn(conscripted);
        verify(mockPrintStream).printf("News Flash: the King was sighted on %D!!\n", conscripted);
        elvis.observedOn(died);
        verify(mockPrintStream).printf("News Flash: the King was sighted on %D!!\n", died);
        elvis.observedOn(today);
        verify(mockPrintStream).printf("News Flash: the King was sighted on %D!!\n", today);

        elvis.deleteObserver(fanaticalElvisObserver);
    }

    @Test
    public void logicalObserverReportsOnReliableEventsOnly() {
        elvis.addObserver(logicalElvisObserver, LogicalElvisObserver.LOGICAL_ELVIS_FILTER);

        elvis.observedOn(born);
        verify(mockPrintStream).printf("A possible Elvis sighting reported on %D\n", born);
        elvis.observedOn(conscripted);
        verify(mockPrintStream).printf("A possible Elvis sighting reported on %D\n", conscripted);
        elvis.observedOn(died);
        verify(mockPrintStream).printf("A possible Elvis sighting reported on %D\n", died);
        elvis.observedOn(today);
        verify(mockPrintStream, never()).printf(anyString());

        elvis.deleteObserver(logicalElvisObserver);
    }
}

