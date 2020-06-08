package com.gouqiang;

/**
 * @author shengouqiang
 * @date 2020/6/8
 */
public class TestVolatile {

    public volatile  int a =0;

    public void testOne(){
       a = 10;
    }
}
