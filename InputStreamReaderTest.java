import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
转换流：属于字符流
InputStreamReader：字节输入转字符输入
OutputStreamWriter：字符输出转字节输出

解码：字节-->字符
编码：字符-->字节
 */
public class InputStreamReaderTest {

    //字节输入转字符输入
    @Test
    public void test(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(new File("hello.txt"));
            //字节输入转字符输入时要指定字符集
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            char[] cubf = new char[5];
            int len;
            while ((len = isr.read(cubf))!= -1){
                String str = new String(cubf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    综合使用InputStreamReader和OutputStreamWriter
    可以实现的事情：将文件编码转变并且保存
     */
    @Test
    public void outputTest(){
        FileInputStream fis = null;
        InputStreamReader isr = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(new File("hello.txt"));
            fos = new FileOutputStream(new File("hello_gbk.txt"));

            //字节输入转字符输入时要指定字符集
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            osw = new OutputStreamWriter(fos, "GBK");
            char[] cubf = new char[5];
            int len;
            while ((len = isr.read(cubf))!= -1){
                osw.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
