package com.github.theaniket.geeksForGeeks;

//There are m stairs, a person standing at the bottom wants to reach the top.
// The person can climb either 1 stair or 2 stairs at a time.
// Count the number of ways, the person can reach the top (order does matter).
// Note: The stair count starts from 0.

public class ReachMthStair {
    public static long solve(int m){
        if(m == 0)return (long)1;
        if(m <= 2)return (long)m;
        int[] dp = new int[m+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=m;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[m];
    }
}
