package day13;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Formatter;

public class Test01 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Calendar c=Calendar.getInstance();
		System.out.println(c);
		String date=String.format("현재 시간은 %tk 시 : %tM 분 : %tS 초\n", c,c,c);
		System.out.println(date);
		
		StringBuffer sb=new StringBuffer();
		//Formatter fm=new Formatter(sb);
		Formatter fm=new Formatter("sss.txt");
		fm.format("현재 시간은 %tk 시 : %tM 분 : %tS 초\n", c,c,c);
		fm.format("%f", Math.PI);
		System.out.println(sb);
		fm.flush();
		System.out.println("main end");
	}

}
