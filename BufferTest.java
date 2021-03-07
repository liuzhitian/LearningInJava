/*
缓冲流：
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter
作用：提高读取写入速度
 */

import org.junit.Test;

import java.io.*;

public class BufferTest {
    @Test
    public void BufferStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("testpic.jpg");
            File destFile = new File("testpic2.jpg");
            //造流
            //1.造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //2.造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //其他与之前一样
            byte[] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer))!= -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要求：先关闭外层的流，再关闭内层的流
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //在关闭外层流的同时，内层的流也会同时关闭，所以内层流关闭可忽略
         /* if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }
}
