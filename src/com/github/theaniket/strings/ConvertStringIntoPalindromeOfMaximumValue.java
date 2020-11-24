package com.github.theaniket.strings;

// Convert a given string of numeric characters into maximum value palindrome
// Given n changes are allowed
public class ConvertStringIntoPalindromeOfMaximumValue {
    public static String solve(String value,int n){
        StringBuilder stringBuilder = new StringBuilder(value);
        int left = 0, right = value.length() - 1;
        while(left<right){
            char leftChar = stringBuilder.charAt(left);
            char rightChar = stringBuilder.charAt(right);
            if(leftChar > rightChar){
                rightChar = leftChar;
                n--;
            } else if(leftChar < rightChar){
                leftChar = rightChar;
                n--;
            }
            stringBuilder.setCharAt(left,leftChar);
            stringBuilder.setCharAt(right,rightChar);
            left++;
            right--;
        }
        if(n<0){
            return null;
        }
        left = 0;
        right = value.length() - 1;
        while (left <= right){
            if(left == right){
                if(n>0){
                    stringBuilder.setCharAt(left,'9');
                }
            }
            if(stringBuilder.charAt(left) < '9'){
                if(n >= 2 && stringBuilder.charAt(left) == value.charAt(left)
                        && stringBuilder.charAt(right) == value.charAt(right)){
                    stringBuilder.setCharAt(left,'9');
                    stringBuilder.setCharAt(right,'9');
                    n -= 2;
                }
                if(n >= 1 && (stringBuilder.charAt(left) == value.charAt(left)
                        || stringBuilder.charAt(right) == value.charAt(right))){
//                    System.out.println("========");
                    stringBuilder.setCharAt(left,'9');
                    stringBuilder.setCharAt(right,'9');
                    n-= 1;
                }
            }
            left++;
            right--;
        }
        return stringBuilder.toString();
    }
}
