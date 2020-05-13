package com.github.theaniket.heap;

import java.util.Arrays;

public class MinHeap {
    int[] tree;
    int size;
    int capacity;

    public MinHeap(int capacity){
        this.capacity = capacity;
        this.tree = new int[this.capacity];
        this.size = 0;
    }

    private int getLeftChildIndex(int index){ return index*2 + 1; }
    private int getRightChildIndex(int index){ return index*2 + 2; }
    private int getParentIndex(int index){ return (index-1)/2; }

    private int getLeftChild(int index){ return this.tree[index*2 + 1];}
    private int getRightChild(int index){ return this.tree[index*2 + 2];}
    private int getParent(int index){ return this.tree[(index-1)/2];}

    private boolean hasParent(int index){return getParentIndex(index) >= 0;}
    private boolean hasLeftChild(int index){return getLeftChildIndex(index) > this.size;}
    private boolean hasRightChild(int index){return getRightChildIndex(index) < this.size;}

    private void swap(int indexOne,int indexTwo){
        int temp = this.tree[indexOne];
        this.tree[indexOne] = this.tree[indexTwo];
        this.tree[indexTwo] = temp;
    }


    private void ensureExtraSpace(){
        if(this.size == this.capacity){
            this.tree = Arrays.copyOf(this.tree,this.capacity*2);
            this.capacity *= 2;
        }
    }

    private int peek(){
        if(this.size == 0)throw  new IllegalStateException();
        return this.tree[0];
    }

    private int poll(){
        if(this.size == 0)throw  new IllegalStateException();
        int item = this.tree[0];
        this.tree[0] = this.tree[this.size - 1];
        this.size -= 1;
        heapifyDown();
        return item;
    }

    private void add(int value){
        ensureExtraSpace();
        this.size += 1;
        this.tree[this.size - 1] = value;
        heapifyUp();
    }

    private void heapifyDown(){
        int currentIndex = 0;
        while(hasLeftChild(currentIndex)){
            int smallerChildIndex = getLeftChildIndex(currentIndex);
            if(hasRightChild(currentIndex) && getRightChild(currentIndex) < getLeftChild(currentIndex)){
                smallerChildIndex = getRightChildIndex(currentIndex);
            }
            if(this.tree[smallerChildIndex] > this.tree[currentIndex]){
                break;
            } else {
                swap(currentIndex,smallerChildIndex);
            }
            currentIndex = smallerChildIndex;
        }
    }

    private void heapifyUp(){
        int currentIndex = this.size - 1;
        if(hasParent(currentIndex) && getParent(currentIndex) > this.tree[currentIndex]){
            swap(getParentIndex(currentIndex),currentIndex);
            currentIndex = getParentIndex(currentIndex);
        }
    }
}
