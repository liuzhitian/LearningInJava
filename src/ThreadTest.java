import org.junit.Test;

/**
 * @Author: 刘志天
* @Date: 2021/2/25
 *
*/
class MyThread extends Thread{

    @Override
    public void run() {
        //将需要此线程做的事声明在run方法中
        for (int i=0;i<101;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            if (i%20==0){
                yield();
            }
        }

    }

}

class MThread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<101;i++){
            if (i%2==0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

public class ThreadTest {

    @Test
    public void test() throws InterruptedException {
        MThread mThread = new MThread();
        new Thread(mThread).start();
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.start();
        //Thread.sleep(10000);
        //myThread.start();

        System.out.println("hello");

        for (int i=0;i<101;i++){
            if (i%2!=0) {
                System.out.println(Thread.currentThread().getName()+i);
            }
            if (i==20){
                myThread.join();
            }
        }
    }
}
