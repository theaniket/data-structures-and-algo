package com.github.theaniket.stacks;

import java.util.Stack;

public class FastMaxStack {

    private Stack<Integer> stack;
    private  Stack<Integer> cache;

    public FastMaxStack(){
        this.stack = new Stack<>();
        this.cache = new Stack<>();
    }

    public void push(int data){
        this.stack.push(data);
        if(this.cache.isEmpty()){
            this.cache.push(data);
        } else {
            if(data < this.cache.peek()){
                this.cache.push(this.cache.peek());
            } else {
                this.cache.push(data);
            }
        }
    }

    public int pop(){
        this.cache.pop();
        return this.stack.pop();
    }

    public int max(){
        return this.cache.peek();
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
}
