import java.lang.annotation.*;

@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String[] value() default "hello";
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface MyAnnotations{
    MyAnnotation[] value();
}

@MyAnnotation(value = "456")
@MyAnnotation(value = "123")
class Person{

}


public class AnnotationTest {

}