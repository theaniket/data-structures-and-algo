package com.github.theaniket.graph;

import java.util.LinkedList;
import java.util.Queue;

class RottenOrangesNode{
    public int x;
    public int y;
    public int timeFrame;
    public RottenOrangesNode(int x,int y,int timeFrame){
        this.x = x;
        this.y = y;
        this.timeFrame = timeFrame;
    }
}

public class RottenOranges {

    public boolean isValidCell(int x,int y,int r,int c){
        return (x >= 0) && (x < r) && (y >= 0) && (y < c);
    }

    public boolean areAllRotten(int[][] a,int r,int c){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getNeighbours(int x,int y){
        int[][] neighbours = new int[4][2];
        // left
        neighbours[0][0] = x;
        neighbours[0][1] = y - 1;
        //right
        neighbours[1][0] = x;
        neighbours[1][1] = y + 1;
        // up
        neighbours[2][0] = x - 1;
        neighbours[2][1] = y;
        // down
        neighbours[3][0] = x + 1;
        neighbours[3][1] = y;
        return neighbours;
    }

    public int solve(int[][] a,int r,int c){
        Queue<RottenOrangesNode> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(a[i][j] == 2){
                    queue.add(new RottenOrangesNode(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        int timeFrame = 0;
        while (!queue.isEmpty()){
            RottenOrangesNode rottenOrangesNode = queue.poll();
            for(int[] neighBours: getNeighbours(rottenOrangesNode.x,rottenOrangesNode.y)){
                int x = neighBours[0];
                int y = neighBours[1];
                if(isValidCell(x,y,r,c) && a[x][y] == 1 && !visited[x][y]){
                    a[x][y] = 2;
                    int currentTimeFrame = rottenOrangesNode.timeFrame;
                    queue.add(new RottenOrangesNode(x,y,currentTimeFrame + 1));
                    visited[x][y] = true;
                    if(currentTimeFrame > timeFrame){
                        timeFrame = currentTimeFrame;
                    }
                }
            }
        }
        return areAllRotten(a,r,c) ? timeFrame : -1;
    }
}
