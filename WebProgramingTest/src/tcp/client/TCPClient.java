package tcp.client;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;


public class TCPClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("192.168.101.7", 8888);
		InputStream in = s.getInputStream();
		byte[] buffer = new byte[1024];
		int length = in.read(buffer);
		System.out.println(new String(buffer, 0, length));
		in.close();
		s.close();
	}

	@Test
	public void fun1() throws UnknownHostException, IOException {
		Socket socket=new Socket("192.168.101.7",8888);
		OutputStream out=socket.getOutputStream();
		BufferedInputStream fileIn=new BufferedInputStream(new FileInputStream("J:\\学习\\01.讲义+笔记+资料\\01.java课件源码\\34.Oracle\\59.oracle\\oracle\\oracle_day01\\资料\\oracle安装及操作资源\\xp_oracle.zip"));
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=fileIn.read(buffer))!=-1) {
			out.write(buffer, 0, len);
		}
		socket.shutdownOutput();
		
		InputStream in=socket.getInputStream();
		byte[] info=new byte[1024];
		int length=in.read(info);
		System.out.println(new String(info,0,length));
		in.close();
		fileIn.close();
		out.close();
		socket.close();
		
	}
	
	
	
}
