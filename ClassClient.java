import java.util.Date;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

class ClassClient {
    public static void main(String[] args){
        try{
            MessageChat msg = new MessageChat();
            msg.setName("Passapol Sutatam");
            msg.setMessage("Test Socket");
            msg.setDate(new Date());
            byte[] serializedObject = new byte[2048];
            
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(msg);
            so.flush();
            serializedObject = bo.toByteArray();

            Socket socket = new Socket("10.34.3.181",50101);
            PrintStream dataOut = new PrintStream(socket.getOutputStream());
            dataOut.write(serializedObject);
            dataOut.close();
        }catch(Exception e){}
    }
}
