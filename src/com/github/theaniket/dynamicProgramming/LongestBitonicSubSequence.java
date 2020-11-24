package com.github.theaniket.dynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubSequence {
    public static int solve(int[] a){
        int noOfElements = a.length;
        int[] dpLtoR = new int[noOfElements];
        int[] dpRtoL = new int[noOfElements];
        Arrays.fill(dpLtoR,1);
        Arrays.fill(dpRtoL,1);
        for(int i=1;i<noOfElements;i++){
            for(int j=0;j<i;j++){
                if(a[i] > a[j] && dpLtoR[i] < dpLtoR[j] + 1){
                    dpLtoR[i] = dpLtoR[j] + 1;
                }
            }
        }
        for (int i=noOfElements-2;i>=0;i--){
            for (int j=noOfElements-1;j>i;j--){
                if(a[i] > a[j] && dpRtoL[i] < dpRtoL[j] + 1){
                    dpRtoL[i] = dpRtoL[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<noOfElements;i++){
            if(max < dpLtoR[i] + dpRtoL[i] - 1){
                max = dpLtoR[i] + dpRtoL[i] - 1;
            }
        }
        return max;
    }
}
