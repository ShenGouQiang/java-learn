package mianshi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 写一个固定容量同步容器，拥有put和get方法。以及getCount方法。
 * 能够支持2个生产者线程和10个消费者线程的阻塞调用
 *
 */
public class MianShi_03 {

    private volatile Set<Integer> c = new HashSet<>(16);

    public void put(int i){

    }
}
