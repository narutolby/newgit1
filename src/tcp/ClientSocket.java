package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author boyang.lby
 * @date 5/30/17
 * @description
 */
public class ClientSocket {
    public static void main(String[]args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        OutputStream outputStream=socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        while (scanner.hasNext()){
            scanner.next();
            outputStream.write("李".getBytes());
        }
    }
}
