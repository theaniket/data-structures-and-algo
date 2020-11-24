package com.github.theaniket.stacks;

import java.util.Stack;

public class BalancedBrackets {

    private static boolean doesMatch(char  a,char b){
        if(a == '{' || b == '}')return true;
        if(a == '[' || b == ']')return true;
        if(a == '(' || b == ')')return true;
        return false;
    }

    private static boolean isOpenBracket(char a){
        return a == '{' || a == '[' || a == '(';
    }
    private static boolean isCloseBracket(char a){
        return a == '}' || a == ']' || a == ')';
    }
    private static boolean startsWithCloseBracket(String s){
        return s.length() > 0 && isCloseBracket(s.charAt(0));
    }

    public static boolean solve(String input){
        if(input == null || input.length() < 1 || startsWithCloseBracket(input)){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input.length();i++){
            char bracket = input.charAt(i);
            if(isOpenBracket(bracket)){
                stack.push(bracket);
            } else {
                if(stack.isEmpty())return false;
                char openBracket = stack.pop();
                if(!doesMatch(openBracket,bracket)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
