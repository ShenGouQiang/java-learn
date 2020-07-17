package com.gouqiang.shen.concurrenthashmap;

import org.junit.Test;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class TestTwo {

    private volatile int a;

    @Test
    public void testOne() {
        ConcurrentHashMap<String, String> testMap = new ConcurrentHashMap<>();
        testMap.put("1", "2");
        testMap.put("1", "2");
        testMap.put("1", "5");
        testMap.put("2", "3");
        testMap.get("1");
    }

    /**
     * 疯狂的让hash进行碰撞，看看ConcurrentHashMap是如何处理的
     */
    @Test
    public void testFive() {
        Map<Person, Person> testMap = new ConcurrentHashMap<>();
        testMap.put(new Person(1, "Q"), new Person(1, "A"));
        testMap.put(new Person(2, "W"), new Person(2, "S"));
        testMap.put(new Person(3, "E"), new Person(3, "D"));
        testMap.put(new Person(4, "R"), new Person(4, "F"));
        testMap.put(new Person(5, "T"), new Person(5, "G"));
        testMap.put(new Person(6, "Y"), new Person(6, "H"));
        testMap.put(new Person(7, "U"), new Person(7, "J"));
        testMap.put(new Person(8, "I"), new Person(8, "K"));
        testMap.put(new Person(9, "O"), new Person(9, "L"));
    }


    @Test
    public void testFour() {
        sun.misc.Unsafe U = sun.misc.Unsafe.getUnsafe();
        U.compareAndSwapInt(this, a, 0, 1);
        System.out.println(a);
    }


    @Test
    public void testThree() {
        System.out.println(Integer.numberOfLeadingZeros(10) | (1 << (16 - 1)));
    }

    @Test
    public void testTwo() {
        System.out.println(Integer.numberOfLeadingZeros(10));
    }

    @Test
    public void testSeven() {

    }

    static class Person {

        private int age;

        private String name;


        public Person() {

        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }
    }

}
