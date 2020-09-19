package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {
//        IUserDao proxy = new StaticProxy(new UserDaoImpl());
//        proxy.print();
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//
//        IUserDao target = new UserDaoImpl();
//        IUserDao jdkProxy = (IUserDao)new JDKProxy(target).getProxyInstances();
//        jdkProxy.print();

         List<Integer> list = new ArrayList<>();
         list.add(1);
         list.add(2);
         list.add(3);
         list.add(4);
         list.add(5);
//         for (int i=0;i<list.size();i++){
//             if(list.get(i) % 2 == 0){
//                 list.add(i * 10 +1 );
//             }
//         }
//         for (int i=list.size()-1;i>=0;i--){
//             if(list.get(i) % 2 == 0){
//                list.add(i * 10);
//             }
//         }
        for (int temp: list){
            if(temp %2 == 0){
                list.remove(temp);
                break;
            }
        }
        System.out.println(list);

//        Enhancer en = new Enhancer();
//        en.setSuperclass(target.getClass());
//        en.setCallback(new MethodInterceptor() {
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                System.out.println("cglib proxy before");
//                methodProxy.invokeSuper(o,objects);
//                System.out.println("cglib proxy after");
//                return null;
//            }
//        });
//        IUserDao proxy = (IUserDao)en.create();
//        proxy.print();
    }
}
