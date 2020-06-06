package designpatterns.proxy.domain;

public class Person implements Animal {
    @Override
    public void eat() {
        System.out.println("man eat bia bia bia ...");
    }
}
