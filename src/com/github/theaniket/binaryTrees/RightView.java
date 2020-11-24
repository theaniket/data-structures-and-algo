package com.github.theaniket.binaryTrees;

//               10
//             /   \
//          20      30
//         /   \
//        40   60
//
//          Right View is: 10 30 60.

import java.util.LinkedList;
import java.util.Queue;

public class RightView {

    private static int max = 0;

    private static void rightViewUtil(BinaryTreeNode root,int level){
        if(root == null)return;
        if(max < level){
            System.out.println(root.data);
            max = level;
        }
        rightViewUtil(root.right,level+1);
        rightViewUtil(root.left,level+1);
    }
    public static void printRightViewOfBinaryTree(BinaryTreeNode root){
        rightViewUtil(root,1);
    }
}
