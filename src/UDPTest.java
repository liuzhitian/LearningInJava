import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPTest {

    @Test
    public void sender()throws IOException{
        DatagramSocket socket = new DatagramSocket();
        String str = "UDP test!!!!";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,localHost,12345);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(12345);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
