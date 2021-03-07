import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        //设置线程池属性
        //executorService.setKeepAliveTime();
        //executorService.setCorePoolSize();

        //适合使用runnable
        Runnable window = new Window2();
        executorService.execute(window);
        //适合使用Callable
        Callable numberThread = new NumberThread();
        executorService.submit(numberThread);

        //关闭连接池
        executorService.shutdown();

    }
}
