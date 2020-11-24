package com.github.theaniket.dynamicProgramming;

import java.util.Arrays;

public class MaximumIncreasingNonContigousSubArray {
    public static int solve(int[] array){
        int noOfItems = array.length;
        int[] dp = new int[noOfItems];
        Arrays.fill(dp,1);
        for(int i=1;i<noOfItems;i++){
            for(int j=0;j<i;j++){
                if(array[i] > array[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int value: dp){
            if(value > max){
                max = value;
            }
        }
        return max;
    }
}
