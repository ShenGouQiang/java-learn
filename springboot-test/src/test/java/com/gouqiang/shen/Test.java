package com.gouqiang.shen;

/**
 * @author shengouqiang
 * @date 2020/5/13
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    public synchronized void test(){
        System.out.println('1');
    }
}
