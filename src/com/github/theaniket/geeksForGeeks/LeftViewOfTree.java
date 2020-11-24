package com.github.theaniket.geeksForGeeks;

import com.github.theaniket.binaryTrees.BinaryTreeNode;

public class LeftViewOfTree {
    int max = 0;
    void leftView(BinaryTreeNode root,int level){
        if(root == null)return;
        if(max < level){
            System.out.print(root.data + " ");
            max = level;
        }
        leftView(root.left,level+1);
        leftView(root.right,level+1);
    }
    void leftView(BinaryTreeNode root)
    {
        leftView(root,1);
    }
}
