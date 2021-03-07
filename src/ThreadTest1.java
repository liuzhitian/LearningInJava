
/*
    实现一个窗口类，在里面run方法，就是在卖票，一共50张票
 */

import org.junit.Test;

class Window implements Runnable{

    private static int ticket = 50;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class ThreadTest1 {

    @Test
    public void test(){
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
