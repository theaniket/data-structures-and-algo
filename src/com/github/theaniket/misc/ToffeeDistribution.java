package com.github.theaniket.misc;

import java.util.Arrays;

public class ToffeeDistribution {
    public static long solve(int[] toffees,int n,int start,int end){
        if(start < 0 || end >= n)return -1;
        if(n < 1)return -1;
        if(toffees == null || toffees.length < 1)return -1;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        dp[0] = toffees[0];
        for(int i=1;i<n;i++){
            dp[i] += dp[i-1] + toffees[i];
        }
        if(start == 0)return dp[end];
        else return dp[end] - dp[start -1];
    }
}