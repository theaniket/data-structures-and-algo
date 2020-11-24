package com.github.theaniket.binaryTrees;

import java.util.Stack;

// Given Tree
//     1
//   2    3
//4   5  6  7
// Traversal :
//1 2 3 7 6 5 4

public class ZigZagTraversal {
    public static void solve(BinaryTreeNode root){
        if(root == null){
            return;
        }
        Stack<BinaryTreeNode> stack_1 = new Stack<>();
        Stack<BinaryTreeNode> stack_2 = new Stack<>();
        stack_1.push(root);
        while (!stack_1.isEmpty() || !stack_2.isEmpty()){
            while(!stack_1.isEmpty()){
                BinaryTreeNode node = stack_1.pop();
                System.out.println(node.data);
                if(node.left != null){
                    stack_2.push(node.left);
                }
                if (node.right != null){
                    stack_2.push(node.right);
                }
            }
            while(!stack_2.isEmpty()){
                BinaryTreeNode node = stack_2.pop();
                System.out.println(node.data);
                if (node.right != null){
                    stack_1.push(node.right);
                }
                if(node.left != null){
                    stack_1.push(node.left);
                }
            }
        }
    }
}
