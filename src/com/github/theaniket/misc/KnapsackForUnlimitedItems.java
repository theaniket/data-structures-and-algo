package com.github.theaniket.misc;

public class KnapsackForUnlimitedItems {
    public static int solve(int totalWeight,int[] weights,int[] values,int noOfItems){
        int[] dp = new int[totalWeight + 1];
        for(int w=0;w<=totalWeight;w++){
            for(int i=0;i<noOfItems;i++){
                if(weights[i] <= w){
                    dp[w] = Math.max(values[i] + dp[w-weights[i]],dp[w]);
                }
            }
        }
        return dp[totalWeight];
    }
}
