package com.github.theaniket.linkedList;

public class LinkedList {
    private LinkedListNode headNode;
    public LinkedList() {
    }

    public void add(int data){
        LinkedListNode linkedListNode = new LinkedListNode(data);
        linkedListNode.next = headNode;
        headNode = linkedListNode;
    }

    public void reverse(){
        LinkedListNode tempNode = headNode;
        
    }

    public void addAtEnd(int data){
        LinkedListNode tempNode = headNode;
        while(tempNode.next != null){
            tempNode = tempNode.next;
        }
        LinkedListNode linkedListNode = new LinkedListNode(data);
        tempNode.next = linkedListNode;
    }

    public boolean find(int data){
        LinkedListNode tempNode = headNode;
        boolean dataFound = false;
        while (tempNode!=null){
            if(tempNode.data == data){
                dataFound = true;
                break;
            }
            tempNode = tempNode.next;
        }
        return dataFound;
    }

    // sort linked list of 0's , 1's and 2's
    public void sortListContainingZerosOnesAndTwos(){
        int[] hash = {0,0,0};
        LinkedListNode tempNode = headNode;
        while (tempNode != null){
            hash[tempNode.data]++;
            tempNode = tempNode.next;
        }
        tempNode = headNode;
        int data = 0;
        while (tempNode!=null){
            if(hash[data] == 0){
                data++;
            } else {
                tempNode.data = data;
                tempNode = tempNode.next;
                hash[data]--;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        LinkedListNode tempNode = headNode;
        while (tempNode != null){
            result = result + "=>" + tempNode.data;
            tempNode = tempNode.next;
        }
        return result;
    }
}
