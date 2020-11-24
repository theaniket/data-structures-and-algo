package com.github.theaniket.designPatterns;

public class Singleton {
    private static Singleton INSTANCE;
    private Singleton(){
        System.out.println("Initializing Singleton");
    }
    // Basic
//    public static Singleton getInstance(){
//        INSTANCE = new Singleton();
//        return INSTANCE;
//    }
    // Thread Safe and Lazy initialization
    // perfect way
    public static Singleton getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
