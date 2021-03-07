import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest1 {

    //无参，无返回值
    @Test
    public void test(){
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("hhhhhhhhhh");
            }
        };

        r1.run();

        System.out.println("******************");
        //使用Lambda表达式重写run方法
        Runnable r2 = () -> {
            System.out.println("llllllllll");};

        r2.run();
    }

    //一个参数，无返回值
    @Test
    public void test2(){

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("hhhhhhh");
        System.out.println("******************");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };

        consumer1.accept("lllllll");

    }

    //数据类型可以省略，因为可由编译器推断出，称为类型推断
    @Test
    public void test3(){
        //优化test2中的lambda表达式
        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };

        consumer1.accept("lllllll");

        System.out.println("******************");

        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };

        consumer2.accept("hhhhhhhh");

    }

    //Lambda只需要一个参数，括号可以省略
    @Test
    public void test4(){
        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };

        consumer2.accept("hhhhhhhh");

        System.out.println("******************");

        Consumer<String> consumer3 = s -> {
            System.out.println(s);
        };

        consumer3.accept("lllllllllll");
    }

    //有两个及以上参数，多条执行语句，有返回值
    //这种就结构写的会比较全
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1,Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("******************");

        Comparator<Integer> com2 = (o1,o2) ->  {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };

        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);
    }

    //当lambda体只有一条语句，return和大括号如果有可以省略
    @Test
    public void test6(){
        Comparator<Integer> com1 = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println("******************");

        Comparator<Integer> com2 = (o1,o2) ->  Integer.compare(o1,o2);

        int compare2 = com2.compare(12, 21);
        System.out.println(compare2);

        System.out.println("******************");
        Consumer<String> consumer3 = s -> {
            System.out.println(s);
        };

        consumer3.accept("lllllllllll");

        System.out.println("******************");

        Consumer<String> consumer4 = s -> System.out.println(s);

        consumer4.accept("lllllllllll");

    }

}
