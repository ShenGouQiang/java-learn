package designpatterns.singleton;

import java.io.Serializable;
import java.util.Objects;

/**
 * 懒汉模式
 *
 * 防止：
 *  1.并发
 *  2.反射(防君子，不妨小人)
 *  3.克隆
 *
 * @author shengouqiang
 * @date 2020/3/19
 */
public class LazySingleton implements Serializable,Cloneable{

    private static int loadCount = 0;

    private static volatile LazySingleton INSTANCES;

    private LazySingleton(){
        synchronized (HungarySingleton.class){
            if(loadCount < 1){
                loadCount++;
            }else{
                throw new RuntimeException("HungarySingleton 已被加载过，请直接调用getInstances处理");
            }
        }
    }

    private Object readResolve(){
        return INSTANCES;
    }

    public static LazySingleton getInstances(){
        if(Objects.isNull(INSTANCES)){
            synchronized (LazySingleton.class){
                if(Objects.isNull(INSTANCES)){
                    INSTANCES = new LazySingleton();
                }
            }
        }
        return INSTANCES;
    }

    @Override
    protected Object clone(){
        return getInstances();
    }
}
