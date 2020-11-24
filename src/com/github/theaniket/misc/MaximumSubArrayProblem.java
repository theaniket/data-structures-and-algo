package com.github.theaniket.misc;

import java.util.ArrayList;

public class MaximumSubArrayProblem {
    public static int solve(ArrayList<Integer> array){
        if(array == null)return -1;
        int max = array.get(0);
        int currentMax = max;
        for(int i=1;i<array.size();i++){
            int value = array.get(i);
            if(currentMax <= 0)currentMax = 0;
            currentMax += value;
            max = Math.max(currentMax,max);
        }
        return max;
    }
}
