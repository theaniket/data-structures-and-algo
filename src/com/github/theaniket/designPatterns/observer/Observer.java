package com.github.theaniket.designPatterns.observer;

public class Observer implements IObserver {
    public void update(String value){
        System.out.println("Value");
    }
}
