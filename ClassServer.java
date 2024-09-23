import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

class ClassServer {
    public static void main(String[] args){
		InnerServerClass server = new InnerServerClass(50555);
		server.start();
    }
}

class InnerServerClass extends Thread{
    ServerSocket server;
	int port;
    InnerServerClass(int port){
        this.port = port;
    }
	public void run(){
		try{
			this.server = new ServerSocket(this.port);
			while (true) {
				String line = "";
				Socket socket = server.accept();
				InputStream input = socket.getInputStream();

				byte[] data = new byte[2048];
				input.read(data);
				ByteArrayInputStream bi = new ByteArrayInputStream(data);
				ObjectInputStream si = new ObjectInputStream(bi);
				MessageChat chat = (MessageChat) si.readObject();
				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				System.out.println((chat.getName() + " said \"" + chat.getMessage() + "\" at "+ df.format(chat.getDate())));
			}
		}catch(Exception e){}
	}
}

