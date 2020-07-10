package com.gouqiang.shen.concurrenthashmap;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestTwo {

    @Test
    public void testOne() {
        Map<String, String> testMap = new ConcurrentHashMap<>();
        testMap.put("1","2");
        testMap.put("1","2");
        testMap.put("1","5");
        testMap.put("2","3");
        testMap.get("1");
    }

    @Test
    public void testTwo(){
        System.out.println(Integer.numberOfLeadingZeros(10));
    }
}
