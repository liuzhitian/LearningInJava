/***
 * 线程一二交替打印1-100的数字
 *
 *
*/
class Number implements Runnable{

    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                //唤醒线程
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "卖票" + number);
                    number++;

                    try {
                        //使调用wait方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();

        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();

    }
}
