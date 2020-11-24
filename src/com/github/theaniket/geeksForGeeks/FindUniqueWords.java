package com.github.theaniket.geeksForGeeks;

//Given two sentences A and B of lower case English letters, the task is to find all unique words.
// A word is unique if it appears exactly once in one of the sentences and does not appear in the other sentence.
// You need to return a list of all unique words in lexicographical order.

import java.util.*;

public class FindUniqueWords {
    public static void updateHashMapForTokens(Map<String,Integer> map,String[] tokens){
        for(String token: tokens){
            if(map.containsKey(token)){
                map.put(token,2);
            } else {
                map.put(token, 1);
            }
        }
    }
    public static ArrayList<String> solve(String A,String B){
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String,Integer> map = new HashMap<>();
        updateHashMapForTokens(map,a);
        updateHashMapForTokens(map,b);
        ArrayList<String> result = new ArrayList<>();
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue() < 2){
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
