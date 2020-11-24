package com.github.theaniket.misc;

import java.util.Arrays;

public class CoinChangeProblem {
    static int[][] dp = new int[10000][10000];
    static boolean[][] visited = new boolean[10000][10000];
    public static int recursiveSolve(int[] coins,int n,int pos,int sum){
        if(pos == n){
            if(sum == 0)return 1;
            return 0;
        }
        int ans = 0;
        int times = 0;
        while (times*coins[pos] <= sum){
            ans += recursiveSolve(coins,n,pos+1,sum - times*coins[pos]);
            times++;
        }
        return ans;
    }
    public static int fastSolveUsingMemoization(int[] coins,int n,int sum){
        int[] dp = new int[sum+1];
        Arrays.fill(dp,0);
        dp[0] = 1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=sum;j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }
}
