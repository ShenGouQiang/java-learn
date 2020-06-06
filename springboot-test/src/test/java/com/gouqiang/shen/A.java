package com.gouqiang.shen;

import lombok.Data;

/**
 * @author shengouqiang
 * @date 2020/5/29
 */
@Data
public class A {

    private B b;

    public void m (){
        System.out.println("A");
    }
}
