import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {
        InnerServer server = new InnerServer(55555);
        server.start();
    }
}

class InnerServer extends Thread {
    ServerSocket server;
    int port;
    InnerServer(int port){
        this.port = port;
    }
    public void run(){
        try{
            server = new ServerSocket(this.port);
            while (true) {
                String line = "";
                Socket socket = server.accept();
                InputStream input = socket.getInputStream();
                InputStreamReader inputStream = new InputStreamReader(input);
                BufferedReader bufferIn = new BufferedReader(inputStream);
                while ((line = bufferIn.readLine())!= null) {
                    System.out.println(line);
                }
            }
        }catch(Exception e){}
    }
}

