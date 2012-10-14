package com.saleem_siddiqui.java.util;

import org.junit.Test;

import java.util.Vector;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Saleem Siddiqui on 10/13/12 at 11:49 PM
 */
public class TestObserver {
    @Test
    public void genericObserverIsEquivalentToJavaUtilObserver() throws Exception {
        Observer<Object> genericObserver = new Observer() {
            public void update(Observable observable, Object event) {
            }
        };
    }

    @Test
    public void arrayCopyIsShallow() {
        Vector<Value> original = new Vector<Value>();
        original.add(new Value("A"));
        original.add(new Value(null));
        Value[] copy = original.toArray(new Value[]{});
        assertThat(original.get(0), is(copy[0]));
        assertThat(original.get(1), is(copy[1]));
    }

    @Test
    public void vectorCopyIsShallow() {
        Vector<Value> original = new Vector<Value>();
        original.add(new Value("A"));
        original.add(new Value(null));
        Vector<Value> copy = (Vector<Value>)original.clone();
        assertThat(original.get(0), is(copy.get(0)));
        assertThat(original.get(1), is(copy.get(1)));
    }

    @Test
    public void twoValueObjectsWithSameStringAreNotEqual() {
        assertThat(new Value("a"), is(not(new Value("a"))));
    }



}

class Value {
    private final String value;
    public Value(String value) {
        this.value = value != null ? value : "HelloWorld";
    }
    public String getValue() {
        return value;
    }
}
