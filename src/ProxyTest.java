import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{

    String getBelief();
    void eat(String food);

}
//被代理类
class SuperMan implements Human{

    public String getBelief() {
        return "god";
    }

    public void eat(String food) {
        System.out.println("我吃了"+food);
    }
}
/*
动态代理需要解决的问题：
1.如何根据内存中的被代理类，动态的创建一个被代理类及其对象
2.通过代理类对象调用方法时，如何去动态调用同名的方法
 */

class ProxyFactory{

    //调用该方法，返回代理类对象
    public static Object getProxyInstance(Object obj){
        //该函数三个变量为，类加载器，该类实现的接口，以及一个Handler，
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();

        MyInvocationHandler handler = new MyInvocationHandler(obj);

        Object newProxyInstance = Proxy.newProxyInstance(
                classLoader, interfaces, handler);

        return newProxyInstance;

    }
}
//实现一个Handler类
class MyInvocationHandler implements InvocationHandler{
    private Object obj;

    public MyInvocationHandler(Object obj){
        this.obj=obj;
    }


    //当我们通过代理类的对象，调用他们的方法的时候，就会通过invoke去调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理开始");
        Object invoke = method.invoke(obj, args);
        System.out.println("动态代理结束");
        return invoke;
    }
}


public class ProxyTest {

    @Test
    public void ProxyTest(){
        Human human = new SuperMan();
        //proxyInstance就是代理对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(human);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("面条");

        System.out.println("********************");

        ClothFactory nikeClothFactory =  new NikeClothFactory();
        ClothFactory nikeProxyInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        nikeProxyInstance.productCloth();

    }
}
