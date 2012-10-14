package com.saleem_siddiqui.java.util;

/**
 * This interface represents an observable object, or "data"
 * in the model-view paradigm. It must be implemented by classes that represent an
 * object that the application wants to have observed. It is a generics based version
 * of java.util.Observer.
 * <p/>
 * An observable object can have one or more observers. An observer
 * may be any object that implements interface <tt>Observer</tt>. After an
 * observable instance changes, an application calling the
 * <code>Observable</code>'s <code>notifyObservers</code> method
 * causes all of its observers to be notified of the change by a call
 * to their <code>update</code> method.
 * <p/>
 * The order in which notifications will be delivered is unspecified.
 * The default implementation provided in the Observable class will
 * notify Observers in the order in which they registered interest, but
 * implementing classes may change this order, use no guaranteed order, deliver
 * notifications on separate threads, or may guarantee that their
 * subclass follows this order, as they choose.
 * <p/>
 * Note that this notification mechanism is has nothing to do with threads
 * and is completely separate from the <tt>wait</tt> and <tt>notify</tt>
 * mechanism of class <tt>Object</tt>.
 * <p/>
 * It is strongly recommended that that implementing classes have an empty
 * set of observers when any of their instances is newly created.
 * Two observers are considered the same if and only if the
 * <tt>equals</tt> method returns true for them.
 *
 * @author Saleem Siddiqui
 * @see com.saleem_siddiqui.java.util.Observable#notifyObservers()
 * @see com.saleem_siddiqui.java.util.Observable#notifyObservers(Object)
 * @see com.saleem_siddiqui.java.util.Observer
 * @see com.saleem_siddiqui.java.util.Observer#update(Observable, Object)
 * @see java.util.Observer
 */
public interface Observable<T extends Observer<E>, E> {

    /**
     * Implementing classes should supply logic to safely add an observer to the set of observers for this object,
     * provided that it is not the same as some observer already in the set. Ensuring thread-safety is the
     * responsibility of the implementing classes.
     * The order in which notifications will be delivered to multiple
     * observers is not specified. See the class comment.
     *
     * @param observer an observer to be added.
     * @throws NullPointerException if the parameter observer is null.
     */
    void addObserver(T observer);

    /**
     * Implementing classes should supply logic to safely delete an observer from the set of observers of this object.
     * Ensuring thread-safety is the responsibility of the implementing classes.
     * Passing <CODE>null</CODE> to this method should not throw any exceptions.
     *
     * @param o the observer to be deleted.
     */
    void deleteObserver(T observer);

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers.
     * Implementing classes should ensure that at the end of this method,
     * they clear the underlying flag (or condition) that <code>hasChanged</code> uses. Put simply:
     * if <code>hasChanged</code> returns a value of a boolean, this method should set that flag to
     * false before exiting.
     * <p/>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and <code>null</code>. In other
     * words, this method is equivalent to:
     * <blockquote><tt>
     * notifyObservers(null)</tt></blockquote>
     *
     * @see com.saleem_siddiqui.java.util.Observable#hasChanged()
     * @see com.saleem_siddiqui.java.util.Observer#update(Observable, Object)
     */
    void notifyObservers();

    /**
     * If this object has changed, as indicated by the
     * <code>hasChanged</code> method, then notify all of its observers.
     * Implementing classes should ensure that at the end of this method,
     * they clear the underlying flag (or condition) that <code>hasChanged</code> uses. Put simply:
     * if <code>hasChanged</code> returns a value of a boolean, this method should set that flag to
     * false before exiting.
     * <p/>
     * Each observer has its <code>update</code> method called with two
     * arguments: this observable object and the <code>event</code> argument.
     *
     * @see com.saleem_siddiqui.java.util.Observable#hasChanged()
     * @see com.saleem_siddiqui.java.util.Observer#update(Observable, Object)
     */
    void notifyObservers(E event);

    /**
     * Clears the observer list so that this object no longer has any observers. Implementing classes must
     * ensure thread-safety.
     */
    void deleteObservers();

    /**
     * Tests if this object has changed.
     * The notion of "change" will vary from one implementing class to another. A simple implementation suggestion
     * is to keep the "change status" in a boolean flag and set it to true whenever some state change occurs.
     * The <code>notifyObservers()</code> and <code><notifyObservers(E event)/code> methods must then clear
     * this boolean flag before they return. This method can simply return the value of that boolean flag.
     *
     * @return <code>true</code> if and only if there are no changes to this object since the last call
     *         to <code>notifyObservers()</code> or <code>notifyObservers(E event)</code> methods on this object;
     *         <code>false</code> otherwise.
     */
    boolean hasChanged();


    /**
     * Returns the number of observers of this <tt>Observable</tt> object.
     *
     * @return the number of observers of this object.
     */
    int countObservers();
}
