/*
对象流:ObjectInputStream\ObjectOutputStream
 */
import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStream {

    //序列化
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
            oos.writeObject(new String("阿萨德"));
            oos.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //反序列化
    @Test
    public void testInputStream(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.txt"));

            String o = (String) ois.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
