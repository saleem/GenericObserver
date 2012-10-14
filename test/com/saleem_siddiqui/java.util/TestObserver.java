package com.saleem_siddiqui.java.util;

import com.saleem_siddiqui.java.util.elvis.*;
import org.junit.Test;

import java.io.PrintStream;

/**
 * Created by Saleem Siddiqui on 10/13/12 at 11:49 PM
 */
public class TestObserver {
    @Test
    public void shouldBeAbleToAddElvisObserversToElvisEvent() throws Exception {
        PrintStream mockPrintStream = mock(PrintStream.class);
        Elvis elvis = Elvis.theOne();
        LogicalElvisObserver logicalElvisObserver = new LogicalElvisObserver(mockPrintStream);
        FanaticalElvisObserver fanaticalElvisObserver = new FanaticalElvisObserver(mockPrintStream);
    }
}

