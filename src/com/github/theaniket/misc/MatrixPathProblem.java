package com.github.theaniket.misc;


//https://www.youtube.com/watch?v=RFyPmMwmgx8&list=PLfBJlB6T2eOtMXgK3FLUTawHjzpIEySHF&index=2

// Given a cost matrix of n*m. Find maximum cost to reach n,m from 0,0
public class MatrixPathProblem {
    public static long solve(long[][] costMatrix,int row,int col){
        long[][] dp = new long[row][col];
        for(int i=1;i<row;i++){
            costMatrix[i][0] += costMatrix[i-1][0];
        }
        for(int i=1;i<col;i++){
            costMatrix[0][i] += costMatrix[0][i];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                costMatrix[i][j] = Math.max(costMatrix[i-1][j],costMatrix[i][j-1]) + costMatrix[i][j];
            }
        }
        return costMatrix[row][col];
    }
}
