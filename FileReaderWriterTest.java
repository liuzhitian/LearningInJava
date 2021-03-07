import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

    @Test
    public void testFileReader() {
        FileReader fileReader = null;
        try {
            //1.创建文件对象
            File file = new File("hello.txt");
            System.out.println(file.getAbsolutePath());
            //2.创建字符输入流
            fileReader = new FileReader(file);
            //3.读取操作
            //方式一 read()会一直读取，直到读取到-1(代表读取到文件的末尾)
            /*int data = fileReader.read();
            while (data!=-1){
                System.out.print((char) data);
                data = fileReader.read();
            }*/
            //方式二
            //read(char[] cbuf):返回每次读获取了几个字符，如果到末尾返回-1
            //在这里有一个难点，如果文件中有7个字符，为abcdefg
            //第一次read cbuf里面，存储的是abcde
            //第二次read cbuf里面，存储的是fgcde
            //cbuf并不会在每次read的时候做自动清空，所在遍历或者使用String的时候要注意
            //不要循环多了，这样就会出问题
            char[] cbuf = new char[5];
            int len;
            while((len = fileReader.read(cbuf)) != -1){
                //使用for循环遍历
                /*for(int i=0;i<len;i++){
                    System.out.print(cbuf[i]);
                }*/
                //使用String
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.最最重要：关闭流，这个很容易忘
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        从内存中写出数据
     */
    @Test
    public void testFileWriter(){
        FileWriter fw = null;
        try {
            //1.创建文件对象
            File file = new File("hello1.txt");
            //2.创建输出流对象
            fw = new FileWriter(file,true);
            //3.写出的操作
            //如果当前file有内容，写出会覆盖该内容，
            //如果不想覆盖,在创建FileWriter的时候使用(File file,boolean append)构造器
            fw.write("asdasqwe\n");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //复制文本文件
    @Test
    public void testReaderWriter(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File inputfile = new File("hello.txt");
            File outputfile = new File("hello2.txt");
            fr = new FileReader(inputfile);
            fw = new FileWriter(outputfile);

            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
