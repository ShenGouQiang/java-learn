package designpatterns.proxy.dynamic.jdk;

import designpatterns.proxy.domain.Animal;
import designpatterns.proxy.domain.Person;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonProxy {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Animal animal = (Animal )Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Animal.class},new PersonInvocationHandler(new Person()));
        animal.eat();
    }

}

@AllArgsConstructor
class PersonInvocationHandler implements InvocationHandler{

    private Animal animal;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("man eat start ....");
        Long startTimestamp = System.currentTimeMillis();
        Object o = method.invoke(animal,args);
        Long endTimestamp = System.currentTimeMillis();
        System.out.println("eat cost time is " + (endTimestamp- startTimestamp) );
        System.out.println("man eat end ....");
        return o;
    }
}

