package com.gouqiang.shen.concurrenthashmap;

import org.junit.jupiter.api.Test;

public class TestOne {

    @Test
    public void testOne(){
        int initialCapacity = 12;
        System.out.println( tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
    }

    public  static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
