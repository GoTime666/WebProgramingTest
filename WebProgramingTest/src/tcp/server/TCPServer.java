package tcp.server;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TCPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8888);
		Socket s = ss.accept();
		OutputStream out = s.getOutputStream();
		out.write("你已经连上服务器".getBytes());
		out.close();
	}

	@Test
	public void fun1() throws IOException {
		//Gotime2
		ServerSocket serverSocket = new ServerSocket(8888);
		Socket clientSocket = serverSocket.accept();
		InetAddress ipObject = clientSocket.getInetAddress();
		String ip = ipObject.getHostAddress();
		System.out.println("小样,抓到你了,链接我" + "IP: " + ip);
		InputStream in = clientSocket.getInputStream();
		// java路径要用\\或//
		BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream("D:\\迅雷下载\\寄生虫.mp4"));
		byte[] buffer = new byte[1024];
		int len = -1;
		while((len=in.read(buffer))!=-1){
			fileOut.write(buffer, 0, len);
		}
		OutputStream out=clientSocket.getOutputStream();
		out.write("图片上传成功".getBytes());
		out.close();
		fileOut.close();
		in.close();
		clientSocket.close();
	}
}
