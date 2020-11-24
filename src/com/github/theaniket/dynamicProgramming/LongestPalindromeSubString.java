package com.github.theaniket.dynamicProgramming;

public class LongestPalindromeSubString {
    public static String solve(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int start = 0;
        for (int i=0;i<len;i++){
            dp[i][i] = true;
        }
        for(int i=0;i<len-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }
        for(int k=3;k<=len;k++){
            for(int i=0;i<len-k+1;i++){
                int j = i + k - 1;
                if(dp[i+1][j-1] && str.charAt(i) == str.charAt(j)){
                    dp[i][j] = true;
                    if(k > maxLen){
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return str.substring(start,start+maxLen);
    }
}
