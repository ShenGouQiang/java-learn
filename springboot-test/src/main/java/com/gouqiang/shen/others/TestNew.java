package com.gouqiang.shen.others;

/**
 * @author shengouqiang
 * @date 2020/6/5
 */
public class TestNew {

    public static void main(String[] args) {
        System.out.println(Test.count);
    }
}

class Test {

    public static Test t = new Test();
    public static int count =2;

    private Test(){
        count++;
    }
}
