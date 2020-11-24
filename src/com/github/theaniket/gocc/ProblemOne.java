package com.github.theaniket.gocc;

import java.util.HashMap;
import java.util.Map;

public class ProblemOne {
    public static int solve(int N,int M,int[] A,int[] B){
        int min = N;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(A[i],i);
        }
//        for(int i=0;i<M;i++){
//            int current = B[i];
//            if(map.containsKey(current)){
//                int count = 0;
//                for(int j=0;j<M;j++){
//                    int next = B[j];
//                    if(map.containsKey(next) && next != current){
//                        count++;
//                        min = Math.min()
//                    }
//                }
//            }
//        }
        return min;
    }
}
