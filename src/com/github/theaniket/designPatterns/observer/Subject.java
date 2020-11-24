package com.github.theaniket.designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject {

    private List<IObserver> observers;

    public Subject(){
        observers = new ArrayList<>();
    }

    @Override
    public void register(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String value) {
        for(IObserver observer : this.observers){
            observer.update(value);
        }
    }

    @Override
    public void notifyObserver(IObserver observer, String value) {
        observer.update(value);
    }
}
