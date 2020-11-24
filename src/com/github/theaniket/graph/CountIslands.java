package com.github.theaniket.graph;

public class CountIslands {

    public static int solve(int[][] island,int row,int col){
        boolean[][] visited = new boolean[row][col];
        int noOfIslands = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && island[i][j] == 1){
                    visitNeighbours(island,i,j,visited,row,col);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }

    private static void visitNeighbours(int[][] island, int i, int j, boolean[][] visited, int row, int col) {
        // linear neighbours
        if(isValidCell(island,i+1,j,row,col)){
            visitNeighbours(island,i+1,j,visited,row,col);
        }
        if(isValidCell(island,i,j+1,row,col)){
            visitNeighbours(island,i,j+1,visited,row,col);
        }
        if(isValidCell(island,i-1,j,row,col)){
            visitNeighbours(island,i-1,j,visited,row,col);
        }
        if(isValidCell(island,i,j-1,row,col)){
            visitNeighbours(island,i,j-1,visited,row,col);
        }

        //diagonal neighbours
        if(isValidCell(island,i+1,j+1,row,col)){
            visitNeighbours(island,i+1,j+1,visited,row,col);
        }
        if(isValidCell(island,i-1,j-1,row,col)){
            visitNeighbours(island,i-1,j-1,visited,row,col);
        }
        if(isValidCell(island,i-1,j+1,row,col)){
            visitNeighbours(island,i-1,j+1,visited,row,col);
        }
        if(isValidCell(island,i+1,j-1,row,col)){
            visitNeighbours(island,i+1,j-1,visited,row,col);
        }
        visited[i][j] = true;
    }

    private static boolean isValidCell(int[][] island, int i, int j, int row, int col) {
        return (i >= 0 && i < row) &&
                (j >= 0 && j < col) &&
                (island[i][j] == 1);
    }
}
