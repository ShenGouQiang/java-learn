package designpatterns.proxy.dynamic.cglib;

import designpatterns.proxy.domain.Dog;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DogProxy {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".");
        Enhancer enhancer = new Enhancer();
        // https://blog.csdn.net/aar49191/article/details/101961477
        // invoke 死循环的问题
        enhancer.setSuperclass(Dog.class);
        enhancer.setCallback(new DogProxyInterceptor());
        Dog dog = (Dog) enhancer.create();
        dog.eat();
    }
}

class DogProxyInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("dog eat start ....");
        Long startTimestamp = System.currentTimeMillis();
        Object o1 = methodProxy.invoke(o,objects);
        Long endTimestamp = System.currentTimeMillis();
        System.out.println("eat cost time is " + (endTimestamp- startTimestamp) );
        System.out.println("dog eat end ....");
        return o1;
    }
}
