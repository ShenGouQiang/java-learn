package com.gouqiang.shen;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        Integer c = 10;
        Integer d = 10;
        int e = 10;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(c == d);
        System.out.println(a == e);
        System.out.println(d == e);
    }
}
