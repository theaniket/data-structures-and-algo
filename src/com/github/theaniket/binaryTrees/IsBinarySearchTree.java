package com.github.theaniket.binaryTrees;

public class IsBinarySearchTree {
    public static boolean solve(BinaryTreeNode root,Integer min,Integer max){
        if(max != null && root.data > max){
            return false;
        }
        if(min != null && root.data < min){
            return false;
        }
        if(max == null && !solve(root.left,min,root.data)){
            return false;
        }
        if(min == null && !solve(root.right,root.data,max)){
            return false;
        }
        return true;
    }
}
