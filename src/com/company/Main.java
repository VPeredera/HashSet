package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();
        mySet.add("Object1");
        System.out.println(mySet.contains("Object1"));
        mySet.add("Object2");
        System.out.println(mySet.contains("Object2"));
        System.out.println(Arrays.toString(mySet.toArray()));
        mySet.remove("Object1");
        System.out.println(Arrays.toString(mySet.toArray()));
        mySet.add("Object3");
        System.out.println(Arrays.toString(mySet.toArray()));
        mySet.clear();
        System.out.println(Arrays.toString(mySet.toArray()));
        System.out.println(mySet.isEmpty());
        System.out.println(mySet.size(mySet));
    }
}
