package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author boyang.lby
 * @date 5/30/17
 * @description
 */
public class ServerSocketTest {
    public static void main(String[]args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        System.out.println("服务端已启动，等待客户端连接..");
        Socket socket=serverSocket.accept();
        InputStream in = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(in);
        byte[]bytes = new byte[1024];
        byte len = -1;
        byte[] bytes1 = new byte[3];
        int i = 0;
        while((len = (byte)in.read()) != -1){
            bytes1[i] = len;
            if(i == 2){
                System.out.println(new String(bytes1));
                i = 0;
                continue;
            }
            i++;
        }
    }
}
