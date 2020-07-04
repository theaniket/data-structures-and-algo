package com.github.theaniket.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    Set<Integer> visited;
    List<Integer> traversal;

    DepthFirstSearch(){
        this.visited = new HashSet<>();
        this.traversal = new ArrayList<>();
    }

    private void dfsUtil(List<List<Integer>> graph,int vertex){
        this.visited.add(vertex);
        this.traversal.add(vertex);
        for(int neighbour: graph.get(vertex)){
            if(!this.visited.contains(neighbour)){
                dfsUtil(graph,neighbour);
            }
        }
    }
    public List<Integer> solve(List<List<Integer>> graph){
        dfsUtil(graph, 0);
        return this.traversal;
    }
}
