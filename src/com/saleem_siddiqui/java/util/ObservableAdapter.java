package com.saleem_siddiqui.java.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saleem Siddiqui on 10/14/12 at 12:28 AM
 */
public class ObservableAdapter<T extends Observer<E>, E> implements Observable<T, E> {
    private boolean changed = false;
    private List<T> obs;

    public ObservableAdapter() {
        obs = new ArrayList<T>();
    }

    public synchronized void addObserver(T observer) {
        if (observer == null) {
            throw new NullPointerException();
        }
        if (!obs.contains(observer)) {
            obs.add(observer);
        }
    }

    public synchronized void deleteObserver(T observer) {
        obs.remove(observer);
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(E event) {
        List<T> localCopy = null;
        synchronized (this) {
            if(!changed) return;
            localCopy = new ArrayList<T>(obs);
            clearChanged();
        }
        notifyObservers(localCopy, event);
    }


    /**
     * This is the only method that uses operations that are theoretically type unsafe. It is annotated to suppress
     * unchecked warnings.
     * The operations are only <i>theoretically</i> type unsafe, because in reality, the compiler will verify that
     * both Observer and Observable are coupled to the same "Event" type. This type check is performed for the
     * addObserver() method of this class -- the only way to associate Observers with this ObservableAdapter.
     * Therefore, there cannot be any Observers in the observerList that aren't "related" to this ObservableAdapter
     * through the same "Event" type.
     * @param observerList
     * @param event
     */
    @SuppressWarnings("unchecked")
    private void notifyObservers(List<T> observerList, E event) {
        for (Observer o : obs)  {
            o.update(this, event);
        }
    }

    public synchronized void deleteObservers() {
        obs.removeAll(obs);
    }

    public synchronized boolean hasChanged() {
        return changed;
    }

    public synchronized int countObservers() {
        return obs.size();
    }

    protected synchronized void setChanged() {
        changed = true;
    }

    protected synchronized void clearChanged() {
        changed = false;
    }
}
