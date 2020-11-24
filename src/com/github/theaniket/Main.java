package com.github.theaniket;

import com.github.theaniket.dynamicProgramming.LongestPalindromeSubString;
import com.github.theaniket.geeksForGeeks.ReachMthStair;
import com.github.theaniket.geeksForGeeks.mockTests.NumberOfPizza;
import com.github.theaniket.graph.ReachTargetWord;
import com.github.theaniket.misc.*;
import com.github.theaniket.stacks.BalancedBrackets;
import com.github.theaniket.strings.ConvertStringIntoPalindromeOfMaximumValue;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ReverseWordsInStrings.solve("my name is aniket chadha"));
//        System.out.println(MinCostToConvert.solve(40000,100000));
//        System.out.println(LongestPalindromeSubString.solve("zzczz"));
//        System.out.println(BoxStackingProblem.solve(new int[]{4,1,4,10},new int[]{6,2,5,12},new int[]{7,3,6,32},4));
//        System.out.println(CoinChangeProblem.fastSolveUsingMemoization(new int[]{1,2,3},3,4));
//        System.out.println(ToffeeDistribution.solve(new int[]{2,3,4,5,6,7,8,9,12,1,1,1},12,5,6));
//        System.out.println(TetrahedronProblem.solve(2));
//        System.out.println(LongestSubStringWithNoDuplicate.solve("aqwertyuiop123456789aaaaaaaaaaaaabcfghjkl"));
//        System.out.println(NumberOfPizza.solve(new int[]{5 ,3, 4, 11, 2},5));
//        StringBuilder stringBuilder = new StringBuilder("Aniket Chadha");
//        stringBuilder.setCharAt(0,'a');
//        System.out.println(stringBuilder.toString());
//        System.out.println(BalancedBrackets.solve(null));
//        System.out.println(ReachMthStair.solve(0));
//        ArrayList<Integer> a = new ArrayList<>();
//        ArrayList<Integer> b = new ArrayList<>();
//        a.add(1);
//        a.add(-10);
//        b.add(4);
//        b.add(1);
//        System.out.println(getPath(a,b));
    }

    public static String getPath(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.add(0);
        B.add(0);
        int cuurentX = 0;
        int currentY = 0;
        String result = "";
        for(int i=0;i<A.size();i++){
            int nextX = A.get(i);
            int nextY = B.get(i);
//            System.out.println(nextX - currentY);
            int diifY = nextY - currentY;
            int diffX = nextX - cuurentX;
            String tempresult1 = "";
            String tempResult2 = "";

            if(diffX != 0 ){
                String temp = "R";
                if(diffX < 0 ){
                    temp = "L";
                    diffX *= -1;
                }
                for(int j=1;j<=diffX;j++){
                    tempresult1 += temp;
                }
            }
            if(diifY != 0 ){
                String temp = "U";
                if(diifY < 0 ){
                    temp = "D";
                    diifY *= -1;
                }
                for(int j=1;j<=diifY;j++){
                    tempresult1 += temp;
                }
            }

            diifY = nextY - currentY;
            diffX = nextX - cuurentX;

            if(diifY != 0 ){
//                System.out.println(diifY);
                String temp = "U";
                if(diifY < 0 ){
                    temp = "D";
                    diifY *= -1;
                }
                for(int j=1;j<=diifY;j++){
                    tempResult2 += temp;
                }
            }
            if(diffX != 0 ){
//                System.out.println(diffX);
                String temp = "R";
                if(diffX < 0 ){
                    temp = "L";
                    diffX *= -1;
                }
                for(int j=1;j<=diffX;j++){
                    tempResult2 += temp;
                }
            }


//             System.out.println(tempresult1);
//             System.out.println(tempResult2);
//            System.out.println(tempresult1.compareToIgnoreCase(tempResult2));

            if(tempResult2.compareTo(tempresult1) >= 0 ){
                result += tempResult2;
            } else {
                result += tempresult1;
            }

            cuurentX = nextX;
            currentY = nextY;
        }
        return result;
    }

    public static int solve(String S,int[] X,int[] Y){
        Map<Character,Integer> min1 = new HashMap<>();
        Map<Character,Integer> min2 = new HashMap<>();
        Integer max = null;
        int noOfPoints = X.length;
        for(int i=0;i<noOfPoints;i++){
            int radius = X[i]*X[i] + Y[i]*Y[i];
            char tag = S.charAt(i);
            if(min1.containsKey(tag)){
                if(radius < min1.get(tag)){
                    min2.put(tag,min1.get(tag));
                    max = min2.get(tag);
                    min1.put(tag,radius);
                }
                if(!min2.containsKey(tag) || radius < min2.get(tag)){
                    min2.put(tag,radius);
                    max = radius;
                }
            } else {
                min1.put(tag,radius);
            }
        }
        int result = 0;
        for(int i=0;i<noOfPoints;i++) {
            int radius = X[i] * X[i] + Y[i] * Y[i];
            if(max == null || radius < max){
                result += 1;
            }
        }
        return result;
    }

    public static String compress(String s){
        StringBuilder sb = new StringBuilder();
        int i=0;
        int count = 0;
        while (i<s.length() -1){
            count++;
            if(s.charAt(i) != s.charAt(i+1)){
                if(count <= 1){
                    sb.append(s.charAt(i));
                } else {
                    sb.append(count).append(s.charAt(i));
                }
                count = 0;
            }
            i++;
        }
        if(count <= 1){
            sb.append(s.charAt(i));
        } else {
            sb.append(count).append(s.charAt(i));
        }
        return sb.toString();
    }

    public static int solve(String S,int K){
        String min_s= S;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<S.length() -K;i++){
            StringBuilder stringBuilder = new StringBuilder(S);
            int start = i;
            int end = i+K;
            stringBuilder.delete(start,end);
            String result = compress(stringBuilder.toString());
            if(result.length() < min){
                min = result.length();
                min_s = result;
            }
        }
        return min;
    }

    public static int solve(String S){
        int n=S.length();
        int a_count[]=new int[n];
        int count=0;
        for(int i=0; i<n;i++){
            if(S.charAt(i)=='a'){
                count++;
            }
            a_count[i]=count;
        }

        int result=0;
        for(int i=0;i<=n-3;i++){

            for(int j=i+1;j<=n-2;j++){

                int count_part1=a_count[i];
                int count_part2=a_count[j]-a_count[i];
                int count_part3=a_count[n-1]-a_count[j];

                if(count_part1==count_part2 && count_part2==count_part3) result++;
            }
        }

        return result;
    }
}