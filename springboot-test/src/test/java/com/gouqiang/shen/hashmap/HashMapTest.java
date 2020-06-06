package com.gouqiang.shen.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void testOne(){
        Map<String,String> map = new HashMap<>(12);
        map.put("shen","shen");
    }

    @Test
    public void testTwo(){
        Map<Integer,Integer> map = new HashMap<>(1 << 30);
        for(int i=0;i<1 << 30;i++){
            map.put(i,i);
        }
        map.put(-1,-1);
    }

    public static void main(String[] args) {
        int cap = 14;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n+1);
    }
}
