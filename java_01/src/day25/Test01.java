package day25;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InetAddress ip=null;
		
		try {
			ip=InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("HostName : "+ip.getHostName());
		System.out.println("HostAddress : "+ip.getHostAddress());
		System.out.println(ip.toString());
		System.out.println("===========================================");
		try {
			ip=InetAddress.getByName("www.naver.com");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("HostName : "+ip.getHostName());
		System.out.println("HostAddress : "+ip.getHostAddress());
		System.out.println(ip.toString());
	}

}
