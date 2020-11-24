package com.github.theaniket.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void printLevelOrderTraversal(BinaryTreeNode node){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode tempNode;
        queue.add(node);
        while (!queue.isEmpty()){
            tempNode = queue.remove();
            System.out.print(tempNode.data + " ");
            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
    }
}
