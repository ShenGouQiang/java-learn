package com.gouqiang.shen;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext moduleContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"});
//        moduleContext.setAllowCircularReferences(false);
//        moduleContext.refresh();
//        A a = (A) moduleContext.getBean("a");
//        B b = (B) moduleContext.getBean("b");
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
//        PersonBean pb = (PersonBean) bf.getBean("personBean");
//        PersonBean p1 = (PersonBean) bf.getBean("p1");
//        System.out.println(p1);

//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
//        PersonBean pb = (PersonBean) bf.getBean("personBean");

//        A a = (A) bf.getBean("a");
//        B b = (B) bf.getBean("b");
//        b.getA().m();
//        a.getB().m();

//        PersonBean p = (PersonBean) bf.getBean("personBeanFactoryBean");
//        System.out.println(p);

//        PersonBeanFactoryBean factoryBean = (PersonBeanFactoryBean) bf.getBean("&personBeanFactoryBean");
//        System.out.println(factoryBean);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
//        A a = (A) context.getBean("a");
//        a.m();
    }
}
