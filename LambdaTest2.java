import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
消费型接口Consumer<T>     void accept(T t)
供给型接口Supplier<T>     T get()
函数型接口Function<T,R>   R apply(T t)
断定型接口Predicate<T>    boolean test(T t)
四大内置核心接口
 */
public class LambdaTest2 {

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test1(){
        happyTime(500.0, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费了" + aDouble);
            }
        });

        System.out.println("*************************");

        happyTime(500.0,money->System.out.println("消费了" + money));

    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s:list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("111", "222", "333");
        List<String> strings = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !"333".equals(s);
            }
        });
        System.out.println(strings);

        System.out.println("***************************");

        List<String> strings1 = filterString(list,s -> !"333".equals(s));
        System.out.println(strings1);

    }

}
