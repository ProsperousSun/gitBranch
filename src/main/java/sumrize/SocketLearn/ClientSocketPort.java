package sumrize.SocketLearn;

import java.io.*;
import java.net.Socket;

public class ClientSocketPort {
    public int port=8080;
    Socket socket=null;

    public static void main(String[] args) {
        new ClientSocketPort();
    }

    public ClientSocketPort() {
        try {
            socket=new Socket("127.0.0.1",port);
            new ClientThread().start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while ((message=bufferedReader.readLine())!=null){
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    class ClientThread extends Thread{
        @Override
        public void run() {
            try {
                //InputStream in = System.in; System.in 从控制台不断地获取数据
                BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
                String msg2;
                while (true) {  //一直开启着线程,并且进行控制台获取数据
                    msg2 = re.readLine();
                    pw.println(msg2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
