package com.github.theaniket.misc;

// link : https://codeforces.com/problemset/problem/166/E

// Rachit Jain Youtube DP Playlist
public class TetrahedronProblem {
    public static long solve(int steps){
        long MOD = 1000000007;
        long[][] dp = new long[2][steps + 1];
        dp[1][0] = 1;
        dp[0][0] = 0;
        // runs out of space
//        for(int i=1;i<=steps;i++){
//            dp[1][i] = (3L*dp[0][i-1])%MOD;
//            dp[0][i] = (2L*dp[0][i-1] + dp[1][i-1])%MOD;
//        }
        // alternate solution
        // it works
        long D = 1;
        long ABC = 0;
        for(int i=1;i<= steps;i++){
            long nD = (3L*ABC)%MOD;
            long nABC = (2L*ABC + D)%MOD;
            D = nD;
            ABC = nABC;
        }
        return D;
    }
}
