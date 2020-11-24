package com.github.theaniket.misc;

import java.util.ArrayList;
import java.util.List;

public class RecentCallCounter {
    List<Integer> requests;
    public RecentCallCounter(){
        requests = new ArrayList<>();
    }
    public int ping(int t){
       requests.add(t); 
       while (requests.size() > 0 && requests.get(0) < t - 3000){
           requests.remove(0);
       }
       return requests.size();
    }
}
