package day09;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Test02_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="Java programming/23000";
		System.out.println(msg.indexOf("/"));
		String d1=msg.substring(0,msg.indexOf("/"));
		String d2=msg.substring(msg.indexOf("/")+1);
		System.out.println(d1);
		System.out.println(d2);
		
		String url="http://127.0.0.1:8080/web1/list.do";
		System.out.println(url.lastIndexOf('/'));
		System.out.println(url.substring(url.lastIndexOf('/')));
		System.out.println(url.contains("web1"));
		
		String data="2019001_홍길동/90_70/100";
		data=data.replace('_','/');
		System.out.println(data);
		String[] sdata=data.split("/");
		System.out.println(Arrays.toString(sdata));
		data="2019001_홍길동/ 90_ 70/100";
		StringTokenizer st=new StringTokenizer(data,"/_");
		System.out.println(st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.print(st.nextToken()+", ");
		}
	}

}
