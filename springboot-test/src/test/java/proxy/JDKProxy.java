package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {

    private IUserDao userDao;

    public JDKProxy(IUserDao userDao){
        this.userDao = userDao;
    }

    public Object getProxyInstances(){
        return Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk proxy before");
                Object o = method.invoke(userDao,args);
                System.out.println("jdk proxy after");
                return o;
            }
        });
    }
}
