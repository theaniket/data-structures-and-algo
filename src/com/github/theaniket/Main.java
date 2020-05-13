package com.github.theaniket;

import com.github.theaniket.linkedList.LinkedList;

interface Example{
    static void method_1(){
        System.out.println("Hello");
    }
    static void method_2(){
        System.out.println("World");
    }
}

@FunctionalInterface
interface ExampleFunctional{
    void show();
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        ExampleFunctional exampleFunctional = new ExampleFunctional() {
            @Override
            public void show() {
                      
            }
        };
        LinkedList linkedList = new LinkedList();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(2);
        linkedList.add(0);
        linkedList.add(0);
        linkedList.sortListContainingZerosOnesAndTwos();
        System.out.println(linkedList.toString());
    }
}
