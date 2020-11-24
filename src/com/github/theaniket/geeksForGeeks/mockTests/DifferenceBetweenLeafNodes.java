package com.github.theaniket.geeksForGeeks.mockTests;

//There is a computer network connected in a Binary tree-like structure.
//You as a network engineer want to connect any of the leaf computers with all other leaf computers with wlan wires.
//It is not possible to connect two leaf computer if the difference between their depth from the root is greater than 1.
//You need to tell your Boss whether it is possible to connect any of the leaf computers with all other leaf computers.

import com.github.theaniket.binaryTrees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class DifferenceBetweenLeafNodes {
    public static boolean solve(BinaryTreeNode root){
        List<Integer> list = new ArrayList<>();
        depthOfLeafNodes(root,0,list);
        if(list.size() < 1)return false;
        int min = list.get(0);
        int max = list.get(0);
        for(int i=1;i<list.size();i++){
            int value = list.get(i);
            max = Math.max(value, max);
            min = Math.min(value, min);
        }
        return max - min <= 1;
    }

    private static void depthOfLeafNodes(BinaryTreeNode root,int depth,List<Integer> list){
        if(root == null)return;
        int nextDepth = depth + 1;
        if(root.left == null && root.right == null){
            list.add(nextDepth);
        }
        depthOfLeafNodes(root.left,nextDepth,list);
        depthOfLeafNodes(root.right,nextDepth,list);
    }
}
