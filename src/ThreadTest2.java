
import org.junit.Test;

class Window1 implements Runnable{

    private static int ticket = 50;
    Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            show();
        }

    }

    public synchronized void show(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票" + ticket);
            ticket--;
        } else {
            flag = false;
        }
    }

}


public class ThreadTest2 {

    @Test
    public void test(){
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}