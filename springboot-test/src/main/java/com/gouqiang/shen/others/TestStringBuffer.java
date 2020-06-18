package com.gouqiang.shen.others;

public class TestStringBuffer {

    public static void main(String[] args) {
        StringBuffer bA = new StringBuffer("1234");
        StringBuffer bB = new StringBuffer("23");
        int a = bA.toString().indexOf(bB.toString());
        int b = bB.toString().indexOf(bA.toString());
    }
}
