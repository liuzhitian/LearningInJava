import org.junit.Test;

import java.io.*;

public class FIleInputOutputStreamTest {

    /**
     * @Description: 使用字节流复制非文本文件
     * @Param: []
     * @return: void
     * @Date: 2021/2/28
     */
    @Test
    public void fileInputOutputStreamTest(){

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            File inputfile = new File("testpic.jpg");
            File outputFile = new File("testpic1.jpg");
            fileInputStream = new FileInputStream(inputfile);
            fileOutputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer))!= -1){
                fileOutputStream.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
