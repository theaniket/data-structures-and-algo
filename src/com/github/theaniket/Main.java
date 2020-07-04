package com.github.theaniket;

import com.github.theaniket.linkedList.LinkedList;

import java.util.Stack;

class MyThread extends Thread{
    MyThread(){
        System.out.println("MyThread");
    }

    @Override
    public void run(){
        System.out.println("runm");
    }

    public void run(String s){
        System.out.println("runnnnnnnnn");
    }
}

class BinaryTree{
    int data;
    BinaryTree left;
    BinaryTree right;
}


public class Main {

    public static int[][] getNeighbours(int x,int y){
        int[][] neighbours = new int[4][2];
        // left
        neighbours[0][0] = x;
        neighbours[0][1] = y - 1;
        //right
        neighbours[1][0] = x;
        neighbours[1][1] = y + 1;
        // up
        neighbours[2][0] = x - 1;
        neighbours[2][1] = y;
        // down
        neighbours[3][0] = x + 1;
        neighbours[3][1] = y;
        return neighbours;
    }

    public static boolean isMirror(BinaryTree leftNode,BinaryTree righNode){
        if(leftNode == null && righNode == null)return true;
        if(leftNode !=null && righNode != null && leftNode.data == righNode.data){
            return isMirror(leftNode.left,righNode.right)
                    && isMirror(leftNode.right,righNode.left);
        }
        return false;
    }

    public static boolean mirrorTreeUtil(BinaryTree rootNode){
        return isMirror(rootNode,rootNode);
    }

    public static void main(String[] args) {
        for (int[] a: getNeighbours(0,0)){
            System.out.println(a[0] + "," + a[1]);
        }
    }
}
