package udp.receive;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class InetAddressTest {
	@Test
	public void fun1() throws UnknownHostException {
		InetAddress localhost = InetAddress.getLocalHost();
		System.out.println(localhost.getHostAddress());
	}
}
