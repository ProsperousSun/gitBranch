package sumrize.SocketLearn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerSocketPort {
    private int port;
    private List<Socket> clients;
    private ServerSocket server;

    public static void main(String[] args) {
        new ServerSocketPort();
    }
    public ServerSocketPort(){
        try {
            port=8080;
            clients=new ArrayList<>();
            server=new ServerSocket(port);

            while (true){
                Socket socket = server.accept();
                clients.add(socket);
                new ServerThread(socket).start();
            }

        }catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    class ServerThread extends Thread{
        Socket socket;
        private BufferedReader br;
        private PrintWriter pw;
        public String msg;

        public ServerThread(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                br = new BufferedReader(new InputStreamReader(inputStream));
                msg="欢迎【"+socket.getInetAddress()+"]进入聊天室！当前聊天室有"+clients.size()+"人";
                sendMsgToAll(msg);

                while ((msg=br.readLine())!=null){
                    msg+="["+socket.getInetAddress()+"]说："+msg;
                    sendMsgToAll(msg);
                }
            }catch (Exception e){
                System.out.println("Exception : "+e);
            }

        }

        public void sendMsgToAll(String msg){
            try {
                System.out.println(msg+"____");
                clients.forEach((client)->{
                    try {
                        pw=new PrintWriter(client.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    pw.println(msg);
                    pw.flush();//这个地方可以在 new PrintWriter(client.getOutputStream(),true);设置为自动刷新
                });
            }catch (Exception e){
                System.out.println("Exception:"+e);
            }
        }
    }
}


