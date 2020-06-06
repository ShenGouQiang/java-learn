package com.maodou.order;


/**
 * @Author: chenjingang@guazi.com  2020-05-19 11:52
 */
public class ParentImpl1 extends Parent {

    @Override
    public Integer run(Integer p1, Integer p2) {
        super.run(p1, p2);
        System.out.println("ParentImpl1 p1:{}, p2:{}" +  p1 + p2);
        return p1 + p2;
    }

    public void test1() {

        Integer p1 = 1;
        Integer p2 = 2;
        ParentImpl1 parentImpl1 = new ParentImpl1();
        Integer run = ((ParentInterface) new ParentWrapper().wapper((ParentInterface) ParentImpl1.super::run))
                .run(p1, p2);
    }


    public static void main(String[] args){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        new ParentImpl1().test1();
    }

}

class ParentWrapper {

    public Object wapper(Object parent) {
        System.out.println(parent instanceof ParentInterface);
        System.out.println(parent instanceof Parent);
        System.out.println(parent.getClass());
        System.out.println(parent.getClass().getSuperclass());
        return new ParentImpl2((ParentInterface) parent);
    }

}


class ParentImpl2 implements ParentInterface {
    public ParentInterface parentInterface;

    public ParentImpl2(ParentInterface parentInterface) {
        this.parentInterface = parentInterface;
    }

    @Override
    public Integer run(Integer p1, Integer p2) {
        System.out.println("ParentImpl2 p1:{}, p2:{}"+p1+p2);
        return parentInterface.run(p1,p2);
    }

//    @Override
//    public void sum() {
//
//    }

}

interface ParentInterface {

    Integer run(Integer p1, Integer p2);

//    void sum();
}

class Parent implements ParentInterface {

    @Override
    public Integer run(Integer p1, Integer p2) {
        System.out.println("Parent p1:{}, p2:{}"+p1 + p2);
        System.out.println("Parent p1:{}, p2:{}" + p1 + "," + p2);
        return p1 + p2;
    }

    //    @Override
    public void sum() {
        System.out.println("sum");
    }

}