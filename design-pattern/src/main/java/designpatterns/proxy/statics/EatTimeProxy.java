package designpatterns.proxy.statics;

import designpatterns.proxy.domain.Animal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EatTimeProxy implements Animal {

    private Animal animal;

    @Override
    public void eat() {

        Long startTimestamp = System.currentTimeMillis();
        animal.eat();
        Long endTimestamp = System.currentTimeMillis();

        System.out.println("eat cost time is " + (endTimestamp- startTimestamp) );
    }
}
