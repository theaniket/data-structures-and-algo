package com.github.theaniket.misc;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithNoDuplicate {
    public static int solve(String input){
        if(input == null)return 0;
        if(input.length() <= 1)return input.length();
        Map<Character,Integer> count = new HashMap<>();
        int[] dp = new int[input.length()];
        for(int i=0;i<input.length();i++){
            count.clear();
            count.put(input.charAt(i),1);
            int maxLen = 1;
            for(int j=i+1;j<input.length();j++){
                if(count.containsKey(input.charAt(j))){
                    break;
                } else{
                    maxLen++;
                    count.put(input.charAt(j),1);
                }
            }
            dp[i] = maxLen;
        }

        int result = Integer.MIN_VALUE;
        for(int value: dp){
            if(value > result){
                result = value;
            }
        }
        return result;
    }
}
