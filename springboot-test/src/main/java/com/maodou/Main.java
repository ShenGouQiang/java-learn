package com.maodou;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/5/26
 */
public class Main {
    public static void main(String[] args) {
        Byte[] array = new Byte[1024*1024];
        List<Byte[]> resultList = new LinkedList<>();
        for (;;){
            resultList.add(new Byte[1024*1024]);
        }
    }
}
