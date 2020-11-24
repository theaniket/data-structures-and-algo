package com.github.theaniket.binaryTrees;

public class InorderTraversal {
    public static void print(BinaryTreeNode root){
        if(root != null){
            print(root.left);
            System.out.println(root.data);
            print(root.right);
        }
    }
}
