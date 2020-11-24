package com.github.theaniket.misc;

import java.util.LinkedList;
import java.util.Queue;

class Num{
    public int cost;
    public int steps;
    public int num;
    public Num(int num,int steps,int cost){
        this.num = num;
        this.steps = steps;
        this.cost = cost;
    }
    public Num(int num){
        this.num = num;
        this.steps = 0;
        this.cost = 0;
    }
    public Num(){}
}

public class MinCostToConvert {

    public static int solve(int N,int M){
        Num[] dp = new Num[M+1];
        boolean[] vis = new boolean[M+1];
        for(int i=0;i<=M;i++){
            dp[i] = new Num(i);
        }
        Queue<Num> queue = new LinkedList<>();
        queue.add(new Num(N));
        vis[N] = true;
        while (!queue.isEmpty()){
            Num parent = queue.poll();
            for(int divisor=2;divisor<=parent.num/2;divisor+=2){
                int child = parent.num + divisor;
                if(child <= M && parent.num%divisor == 0){
                    int childSteps = parent.steps + 1;
                    int childCost = parent.cost + (parent.num/divisor);
                    Num nextNum = new Num(child,parent.steps + 1,
                            childCost);
                    if(!vis[child]){
                        queue.add(nextNum);
                        dp[child] = nextNum;
                    }
                    vis[child] = true;
                }
            }
        }
        return vis[M] ? dp[M].cost : -1;
    }
}
