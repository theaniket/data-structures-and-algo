package com.github.theaniket.misc;

// Given x,y coordinates count number of rectangles
// parallel to x and y axis

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CountRectangles {

    private static String make_pair(int y,int y2){
        return y+ "_" + y2;
    }

    public static int solve(List<Point> points){
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        for(Point point: points){
            for(Point abovePoint: points){
                if(abovePoint.x == point.x && abovePoint.y > point.y){
                    String key = make_pair(abovePoint.y,point.y);
                    if(!map.containsKey(key)){
                        map.put(key,0);
                    } else {
                        int value = map.get(key);
                        answer += value;
                        map.put(key,value + 1);
                    }
                }
            }
        }
        return answer;
    }
}
