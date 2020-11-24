package com.github.theaniket.misc;

import java.util.Arrays;

class Box implements  Comparable<Box>{
    public int width;
    public int length;
    public int height;
    public int area;
    public Box(int height,int length,int width){
        this.width = width;
        this.height = height;
        this.length = length;
        this.area = this.length*this.width;
    }

    @Override
    public int compareTo(Box o) {
        return o.area - this.area;
    }
}

public class BoxStackingProblem {
    public static int solve(int[] lengths,int[] heights,int[] widths,int size){
        int count = size*3;
        Box[] boxes = new Box[count];
        for(int i=0;i<size;i++){
            boxes[3*i] = new Box(heights[i],Math.max(lengths[i],
                    widths[i]),Math.min(lengths[i],widths[i]));
            boxes[3*i + 1] = new Box(lengths[i],Math.max(heights[i],
                    widths[i]),Math.min(heights[i],widths[i]));
            boxes[3*i + 2] = new Box(widths[i],Math.max(heights[i],
                    lengths[i]),Math.min(heights[i],lengths[i]));
        }
        Arrays.sort(boxes);
        int[] dp = new int[count];
        int result = Integer.MIN_VALUE;
        for(int i=0;i<count;i++){
            Box currentBox = boxes[i];
            dp[i] = currentBox.height;
            int previousHeight = 0;
            for(int j=0;j<i;j++){
                if(boxes[j].width > currentBox.width && boxes[j].length > currentBox.length){
                    previousHeight = Math.max(previousHeight,dp[j]);
                }
            }
            dp[i] += previousHeight;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
