package com.github.theaniket.graph;

import java.util.LinkedList;
import java.util.Queue;

class WordItem{
    public String word;
    public int length;
    public WordItem(String word,int len){
        this.word = word;
        this.length = len;
    }
}

public class ReachTargetWord {
    private static boolean isAdjacent(String a,String b){
        if(a.length() != b.length())return false;
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i))count++;
        }
        return count == 1;
    }
    public static int solve(String start,String Target,String[] dictionary){
        Queue<WordItem> queue = new LinkedList<>();
        queue.add(new WordItem(start,1));
        while (!queue.isEmpty()){
            WordItem wordItem = queue.poll();
            for(String word: dictionary){
                if(isAdjacent(word,wordItem.word)){
                    if(word.equals(wordItem.word))return wordItem.length;
                    else {
                        queue.add(new WordItem(word,wordItem.length + 1));
                    }
                }
            }
        }
        return -1;
    }
}
