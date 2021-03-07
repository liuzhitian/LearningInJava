
/**
* @Author: 刘志天
* @Date: 2021/2/26
 * 使用同步机制将单例中懒汉式改写为线程安全的
*/
class Bank{
    private Bank(){

    }

    private static Bank instance = null;
//方式一，效率低
/*    public static synchronized Bank getInstance(){
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }*/
   //方式二，效率高
    public static Bank getInstance(){


        synchronized (Bank.class) {
            if (instance == null){
                instance = new Bank();
            }
        }
        return instance;
    }
}

public class BankTest {
}
