package com.gouqiang.shen;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean("a");
        context.getBean("b");
    }
}
