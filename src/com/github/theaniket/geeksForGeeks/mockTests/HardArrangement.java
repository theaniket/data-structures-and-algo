package com.github.theaniket.geeksForGeeks.mockTests;


import java.util.ArrayList;
import java.util.Collections;

//You are given two array A[] and B[].
//Your task is to arrange elements of first array according to the order defined by second array.
//The first array contains integers which represent heights of persons and second array defines
//how many persons in front of him should stand with height greater than or equal to that person.
public class HardArrangement {
    // not working . WRONG SOLUTION. FIX THIS
    public static ArrayList<Integer> solve(ArrayList<Integer> A,ArrayList<Integer> B,int n){
        ArrayList<Person> persons = new ArrayList<>();
        for(int i=0;i<n;i++){
            persons.add(new Person(A.get(i),B.get(i)));
        }
        Collections.sort(persons, (person1, person2) -> {
            if(person1.numberOfTallPersonBefore == person2.numberOfTallPersonBefore){
                if(person1.height < person2.height){
                    return -1;
                } else {
                    return 1;
                }
            }
            else if (person1.numberOfTallPersonBefore < person2.numberOfTallPersonBefore) {
                if (person1.height < person2.height)
                    return -1;
            }
            else if (person1.numberOfTallPersonBefore > person2.numberOfTallPersonBefore) {
                if (person1.height > person2.height)
                    return 1;
            }
            return -1;
        });
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            Person person = persons.get(i);
            result.add(person.height);
        }
        return result;
    }
}

class Person{
    public int height;
    public int numberOfTallPersonBefore;
    public Person(int height,int numberOfTallPersonBefore){
        this.height = height;
        this.numberOfTallPersonBefore = numberOfTallPersonBefore;
    }
}
