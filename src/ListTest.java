import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

    @Test
    public void test(){
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<list.size();i++){
            list.add(i+1);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        Iterator<Integer> it = list.listIterator();
        int i=0;
        while (it.hasNext()){
            if (i==3){
                list.remove(3);
            }
            Integer value = it.next();
            System.out.println(value);
            i++;
        }

        for (Object o: list) {
            System.out.println(o);
        }
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++ ) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0 ;
        while(iterator.hasNext()) {
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(iterator.next());
            i ++;
        }
    }

}
