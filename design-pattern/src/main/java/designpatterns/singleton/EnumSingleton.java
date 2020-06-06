package designpatterns.singleton;

import java.io.Serializable;

/**
 * 枚举模式
 *
 * 防止：
 *  1.并发
 *  2.反射(防君子，不妨小人)
 *  3.克隆
 *
 * @author shengouqiang
 * @date 2020/3/19
 */
public enum EnumSingleton implements Serializable,Cloneable {
    INSTANCES;

    public static EnumSingleton getInstances(){
        return INSTANCES;
    }
}
