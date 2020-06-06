package designpatterns.singleton.test;

import org.junit.Test;
import designpatterns.singleton.EnumSingleton;
import designpatterns.singleton.HungarySingleton;
import designpatterns.singleton.LazySingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author shengouqiang
 * @date 2020/3/19
 */
public class TestSingleton {

    /***********************************显示测试单例模式***********************************/
    @Test
    public void testHungry(){
        for (int i=0;i<100;i++){
            new Thread(()-> System.out.println(HungarySingleton.getInstances().hashCode())).start();
        }
    }

    @Test
    public void testLazy(){
        for (int i=0;i<100;i++){
            new Thread(()-> System.out.println(LazySingleton.getInstances().hashCode())).start();
        }
    }

    @Test
    public void testEnums(){
        for (int i=0;i<100;i++){
            new Thread(()-> System.out.println(HungarySingleton.getInstances().hashCode())).start();
        }
    }

    /***********************************利用发射破坏单例模式***********************************/

    @Test
    public void reflectBrokeHungry() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Constructor con = HungarySingleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        HungarySingleton h1 = (HungarySingleton )con.newInstance();
        HungarySingleton h2 =  (HungarySingleton )con.newInstance();
        System.out.println(h1 == h2);
    }

    @Test
    public void reflectBrokeLazy() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor con = LazySingleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        LazySingleton l1 = (LazySingleton )con.newInstance();
        LazySingleton l2 =  (LazySingleton )con.newInstance();
        System.out.println(l1 == l2);
    }

    @Test
    public void reflectBrokeEnums() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor con = EnumSingleton.class.getDeclaredConstructor();
        con.setAccessible(true);
        EnumSingleton e1 = (EnumSingleton )con.newInstance();
        EnumSingleton e2 =  (EnumSingleton )con.newInstance();
        System.out.println(e1 == e2);
    }

    /***********************************利用序列化破坏单例模式***********************************/

    @Test
    public void seializeBrokeHungry() throws IOException, ClassNotFoundException {
        HungarySingleton instances = HungarySingleton.getInstances();
        FileOutputStream fos = new FileOutputStream("hungry");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(instances);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("hungry");
        ObjectInputStream ois = new ObjectInputStream(fis);
        HungarySingleton i1 = (HungarySingleton)ois.readObject();
        System.out.println(instances == i1);
    }

    @Test
    public void seializeBrokeLazy() throws IOException, ClassNotFoundException {
        LazySingleton instances = LazySingleton.getInstances();
        FileOutputStream fos = new FileOutputStream("lazy");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(instances);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("lazy");
        ObjectInputStream ois = new ObjectInputStream(fis);
        LazySingleton i1 = (LazySingleton)ois.readObject();
        System.out.println(instances == i1);
    }

    @Test
    public void seializeBrokeEnums() throws IOException, ClassNotFoundException {
        EnumSingleton instances = EnumSingleton.getInstances();
        FileOutputStream fos = new FileOutputStream("enum");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(instances);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream("enum");
        ObjectInputStream ois = new ObjectInputStream(fis);
        EnumSingleton i1 = (EnumSingleton)ois.readObject();
        System.out.println(instances == i1);
    }

    /***********************************利用克隆破坏单例模式***********************************/

    @Test
    public void cloneBrokeHungry() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HungarySingleton instances = HungarySingleton.getInstances();
        Method method = instances.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungarySingleton i1 = (HungarySingleton) method.invoke(instances);
        System.out.println(instances == i1);
    }

    @Test
    public void cloneBrokeLazy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LazySingleton instances = LazySingleton.getInstances();
        Method method = instances.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        LazySingleton i1 = (LazySingleton) method.invoke(instances);
        System.out.println(instances == i1);
    }

    @Test
    public void cloneBrokeEnums() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        EnumSingleton instances = EnumSingleton.getInstances();
        Method method = instances.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        EnumSingleton i1 = (EnumSingleton) method.invoke(instances);
        System.out.println(instances == i1);
    }
}
