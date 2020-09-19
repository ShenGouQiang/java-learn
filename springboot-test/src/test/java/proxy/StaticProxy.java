package proxy;

public class StaticProxy implements IUserDao{

    private IUserDao userDao;

    public StaticProxy(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void print() {
        System.out.println("static proxy before");
        userDao.print();
        System.out.println("static proxy after");
    }
}
