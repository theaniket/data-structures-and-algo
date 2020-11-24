package com.github.theaniket.designPatterns.observer;

// Like Instagram follower
public interface ISubject {
    void register(IObserver observer);
    void unregister(IObserver observer);
    void notifyObservers(String value);
    void notifyObserver(IObserver observer,String value);
}
