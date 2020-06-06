package designpatterns.singleton;

import java.io.Serializable;

/**
 * 饿汉模式
 *
 * 防止：
 *  1.并发
 *  2.反射(防君子，不妨小人)
 *  3.克隆
 *
 * @author shengouqiang
 * @date 2020/3/19
 */
public class HungarySingleton implements Serializable,Cloneable {

    private static int loadCount = 0;

    private HungarySingleton(){
        synchronized (HungarySingleton.class){
            if(loadCount < 1){
                loadCount++;
            }else{
                throw new RuntimeException("HungarySingleton 已被加载过，请直接调用getInstances处理");
            }
        }

    }

    private Object readResolve(){
        return getInstances();
    }

    private static class  HungarySingletonHolder {
        private static final HungarySingleton INSTANCES = new HungarySingleton();
        private HungarySingletonHolder(){

        }
    }

    public static HungarySingleton getInstances() {
        return HungarySingletonHolder.INSTANCES;
    }

    @Override
    protected Object clone(){
        return getInstances();
    }
}
