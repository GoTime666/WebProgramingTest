package udp.receive;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceive {
	public static void main(String[] args) throws IOException {
		DatagramSocket receiveSocket = new DatagramSocket(12306);
		byte[] buffer = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buffer, 1024);
		receiveSocket.receive(dp);
		InetAddress ipAddress = dp.getAddress();
		String ip = ipAddress.getHostAddress();
		byte[] data = dp.getData();
		int length = dp.getLength();
		String dataStr = new String(data, 0, length);
		System.out.println("IP地址: "+ip+"数据是 "+dataStr);
		receiveSocket.close();
	}
}
