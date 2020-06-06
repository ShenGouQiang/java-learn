package designpatterns.proxy.statics;

import designpatterns.proxy.domain.Animal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EatLogProxy implements Animal {

    private Animal animal;

    @Override
    public void eat() {
        System.out.println("man eat start ....");
        animal.eat();
        System.out.println("man eat end ....");
    }
}
