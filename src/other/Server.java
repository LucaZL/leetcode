package other;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("server start");
        try{
            ServerSocket server = new ServerSocket(22222);
            Socket socket = server.accept();
            System.out.println("server get data");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String type = dis.readUTF();

            byte[] buff = new byte[1024];
            OutputStream os = new FileOutputStream("/Users/bjhl/Desktop/test-server.png");
            int len = -1;
            while ((len = dis.read(buff)) != -1) {
                os.write(buff, 0, len);
            }
            os.flush();
            os.close();
            dis.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("server end");
    }
}
