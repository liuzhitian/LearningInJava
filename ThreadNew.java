import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//创建一个实现callable接口的实现类
class NumberThread implements Callable<Integer>{
    //实现call方法
    @Override
    public Integer call() throws Exception {
        int count = 0;
        for(int i = 1;i < 100;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
                count += i;
            }
        }
        return count;
    }
}

public class ThreadNew {

    public static void main(String[] args) {
        //3.创建callable接口实现类对象
        NumberThread numberThread = new NumberThread();
        //4.将此callable接口实现类对象传入到FutureTask构造器中，创建FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<>(numberThread);
        //5.以FutureTask对象作为参数，传递到Thread构造器中，开启Thread线程
        new Thread(futureTask).start();

        Integer integer = null;
        try {
            //get为获取call方法的返回值
            integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}
