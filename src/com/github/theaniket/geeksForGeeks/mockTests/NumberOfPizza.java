package com.github.theaniket.geeksForGeeks.mockTests;


//There are N number of Pizza bowls and in each bowl there are ai pizzas .
//You can eat pizzas from any bowl but you cannot eat pizzas from two consecutive bowls .
//Find the maximum number of pizzas you can eat.
public class NumberOfPizza {
    public static int solve(int[] arr,int n){
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i] = arr[i];
        }
        for(int i=0;i<n;i++){
            max = dp[i];
            for(int j=0;j<i - 1;j++){
                if(dp[i] + dp[j] > max){
                    max = dp[i] + dp[j];
                }
            }
            dp[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int value: dp){
            if(value > max){
                max = value;
            }
        }
        return max;
    }
}
