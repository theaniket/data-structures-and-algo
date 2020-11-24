package com.github.theaniket.misc;

public class FindMissingElement {
    public static int solve(int[] elements,int n){
        int sum = n*(n+1)/2;
        for(int element: elements){
            sum -= element;
        }
        return sum;
    }
}
