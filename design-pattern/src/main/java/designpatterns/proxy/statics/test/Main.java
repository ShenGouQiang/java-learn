package designpatterns.proxy.statics.test;

import designpatterns.proxy.domain.Person;
import designpatterns.proxy.statics.EatLogProxy;
import designpatterns.proxy.statics.EatTimeProxy;

public class Main {
    public static void main(String[] args) {
        new EatLogProxy(new EatTimeProxy(new Person())).eat();
    }
}
