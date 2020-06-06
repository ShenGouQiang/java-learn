package com.gouqiang.shen;

import lombok.Data;

/**
 * @author shengouqiang
 * @date 2020/5/29
 */
@Data
public class B {

    private A a;

    public void m (){
        System.out.println("B");
    }

}
