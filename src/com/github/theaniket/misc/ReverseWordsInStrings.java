package com.github.theaniket.misc;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

// Input : the sky is blue
// output : blue is the sky
public class ReverseWordsInStrings {
    public static String solve(String s){
        String[] input = s.split(" ");
        Collections.reverse(Arrays.asList(input));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i< input.length - 1;i++){
            stringBuilder.append(input[i] + " ");
        }
        stringBuilder.append(input[input.length - 1]);
        return stringBuilder.toString();
    }
}
