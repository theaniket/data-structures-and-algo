package com.github.theaniket.heap;

import java.util.Arrays;

public class MaxHeap {
    int[] tree;
    int size;
    int capacity;

    public MaxHeap(int capacity){
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

    private void ensureExtraSpace(){
        if(this.size == this.capacity){
            this.tree = Arrays.copyOf(this.tree,this.capacity*2);
            this.capacity *= 2;
        }
    }

    private void swap(int indexOne,int indexTwo){
        int temp = this.tree[indexOne];
        this.tree[indexOne] = this.tree[indexTwo];
        this.tree[indexTwo] = temp;
    }

    public void add(int data) {
        this.ensureExtraSpace();
        this.tree[this.size] = data;
        this.size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int currentIndex = this.size - 1;
        while (hasParent(currentIndex) && getParent(currentIndex) < this.tree[currentIndex]){
            swap(getParentIndex(currentIndex),currentIndex);
            currentIndex = getParentIndex(currentIndex);
        }
    }
}
