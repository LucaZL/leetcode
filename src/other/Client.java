package other;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        System.out.println("client start");
        try {
            Socket socket = new Socket("127.0.0.1", 22222);
            if (socket.isConnected()) {
                System.out.println("isConnected");
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("STREAM");
                File file = new File("/Users/bjhl/Desktop/test.png");
                // dos.writeLong(file.length());
                byte[] buff = new byte[1024];
                InputStream inputStream = new FileInputStream(file);
                int len = -1;
                while ((len = inputStream.read(buff)) != -1) {
                    dos.write(buff, 0, len);
                }
                inputStream.close();
                dos.flush();
                dos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("client end");
    }
}
