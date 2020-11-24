package com.github.theaniket.dynamicProgramming;


public class KnapsackProblem {
    public static int solve(int weight,int[] weights,int[] values){
        int noOfItems = weights.length;
        int[][] dp = new int[noOfItems+1][weight+1];
        for(int i=0;i<=noOfItems;i++){
            for(int w=0;w<=weight;w++){
                if(i==0||w==0){
                    dp[i][w] = 0;
                } else if(weights[i-1] <= w){
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]],dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        return dp[noOfItems][weight];
    }
    public static int recursiveSolution(int weight,int[] weights,int[] values,int n){
        if(weight == 0||n == 0){
            return 0;
        }
        if(weights[n-1]>weight){
            return recursiveSolution(weight,weights,values,n-1);
        }
        return Math.max(values[n-1] + recursiveSolution(weight-weights[n-1],weights,values,n-1),
                recursiveSolution(weight,weights,values,n-1));
    }
}
