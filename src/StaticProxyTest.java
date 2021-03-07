import org.junit.Test;

interface ClothFactory{

    void productCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    public void productCloth() {
        System.out.println("代理工厂开始做事情");
        factory.productCloth();
        System.out.println("代理工厂结束做事情");
    }
}
//被代理类
class NikeClothFactory implements ClothFactory{

    public void productCloth() {
        System.out.println("nike生产衣服");
    }
}

public class StaticProxyTest {

    @Test
    public void test(){
        //创建被代理类对象
        ClothFactory nike = new NikeClothFactory();

        //创建代理类对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.productCloth();
    }

}
