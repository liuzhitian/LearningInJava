import org.junit.Test;
import java.util.concurrent.locks.ReentrantLock;

class Window2 implements Runnable{

    private int ticket = 100;
    //实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //调用lock方法
                lock.lock();
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //调用解锁方法，解锁lock
                lock.unlock();
            }
        }
    }

}

public class ThreadTest4 {

    @Test
    public void test(){
        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }
}
