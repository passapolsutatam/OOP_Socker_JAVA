import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class Client{
    public static void main(String[] args){
        while (true) {
            try{
                Socket socket = new Socket("10.34.3.138", 55555);
                PrintStream dataOut = new PrintStream(socket.getOutputStream());
                String msg = "Passapol#"+"สวัดดีครับ";
                dataOut.println(msg);
                dataOut.close();
            }catch(Exception e){}
        }
    }
}