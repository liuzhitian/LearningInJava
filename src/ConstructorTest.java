import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

class Employee{
    private Integer id;

    public Employee() {
        System.out.println("a new employee");
    }

    public Employee(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}

public class ConstructorTest {

    @Test
    public void test1(){
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier.get());

        System.out.println("****************");

        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());

        System.out.println("****************");
        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier1.get());

    }

    @Test
    public void test2(){
        Function<Integer,Employee> function = id -> new Employee(id);
        System.out.println(function.apply(1000));

        System.out.println("****************");

        //会自动去找对应参数的构造器
        Function<Integer,Employee> function1 = Employee::new;
        System.out.println(function1.apply(1001));

    }

    //数组引用
    @Test
    public void test3(){
        Function<Integer,String[]> function = length -> new String[length];
        String[] arr1 = function.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("***********************");

        Function<Integer,String[]> function1 = String[]::new;
        String[] arr2 = function1.apply(6);
        System.out.println(Arrays.toString(arr2));

    }
}
