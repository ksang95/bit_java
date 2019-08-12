package day09;

import java.util.Date;

public class Test03_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="";
		msg=msg+"hello "+new java.util.Date()+" java"+" test";
		System.out.println(msg);
		String msg2="";
		//StringBuffer sb=new StringBuffer();
		StringBuilder sb=new StringBuilder();
		sb.append("hello ");
		sb.append(new Date());
		sb.append(" java");
		sb.append(" test");
		//msg2=sb.toString();
		msg=new String(sb);
		System.out.println(msg);
	}

}
